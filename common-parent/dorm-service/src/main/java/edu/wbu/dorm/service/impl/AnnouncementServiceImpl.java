package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Announcement;
import edu.wbu.dorm.model.User;
import edu.wbu.dorm.service.AnnouncementService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement> implements AnnouncementService {
    @Override
    public List<Announcement> findTopSixByTime() {
        return anouMapper.findTopSixByTime();
    }

    @Override
    public int deleteOne(int anouId, String uid, int role) {
        return anouMapper.delete(anouId);
    }

    @Override
    public int updateOne(int anouId, String title, String content, String uid, int role) {
        Announcement anou = new Announcement(anouId,title,content);
        return anouMapper.update(anou);
    }

    @Override
    public String[] imgUpload(List<MultipartFile> anouImg, String imgUploadPath) {
        //1.判断保存图片的文件夹是否存在
        File imgSaveFile = new File(imgUploadPath);
        if (!imgSaveFile.exists())
            imgSaveFile.mkdirs();
        String[] data = new String[anouImg.size()];//根据上传的图片数量创建字符串数组
        int index = 0;
        //2.遍历集合，保存每一张图片
        for (MultipartFile f:anouImg){
            //2.1首先为每张图片重新生成一个名字
            String suffix = f.getOriginalFilename().split("\\.")[1];
            String fileName = UUID.randomUUID().toString()+"."+suffix;
            //2.2将图片名字与保存路径组合成完整的保存路径
            String totalPath = imgUploadPath+"\\"+fileName;
            //2.3将图片写入该路径
            try {
                FileCopyUtils.copy(f.getInputStream(), new FileOutputStream(new File(totalPath)));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            //2.4将每张图片的路径放入字符串数组中
            String imgPath = "/uploadImg/"+fileName;
            data[index] = imgPath;
            index++;
        }
        return data;
    }

    @Override
    public Boolean publish(String uid,String title,String html, String anouPath,String anouModelPath) {
        File anouFile = new File(anouPath);//公告html路径
        File anouModel = new File(anouModelPath);//html模板文件路径
        if (!anouFile.exists())
            anouFile.mkdirs();
        try {
            //将复制的html文件加载进内存创建dom树
            Document document = Jsoup.parse(anouModel, "utf-8");
            Elements titles = document.getElementsByTag("title");
            Element title1 = document.getElementById("title");
            //将标题放入
            titles.get(0).html(title);
            title1.html(title);
            //将公告内容形成的html格式内容放入
            Element content = document.getElementById("content");
            content.html(html);
            //统一处理图片大小
            Elements img = document.getElementsByTag("img");
            img.attr("style","height:305px;width:450px;");
            //将模板文件起一个新名字放入到公告的统一存放路径中
            String newFileName = "anou"+System.currentTimeMillis()+".html";//新文件名
            String totalPath = anouPath+"\\"+newFileName;//完整存放路径
            //将修改后的html存在本地
            OutputStream os = new BufferedOutputStream(new FileOutputStream(totalPath));
            FileCopyUtils.copy(new String(document.html().getBytes()),new OutputStreamWriter(os,"utf-8"));
            //FileCopyUtils.copy(new String(document.html().getBytes("utf-8")),new FileWriter(totalPath));
            //生成网络访问路径
            String uriPath = "/anou/"+newFileName;
            //生成文件创建时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String createDate = sdf.format(new Date());
            //在公告表中插入新的公告记录
            User admin = userMapper.findById(uid);
            Announcement anou = new Announcement();
            anou.setTitle(title);
            anou.setContent(uriPath);
            anou.setPublisher(admin.getName());
            anou.setTime(createDate);
            anouMapper.insert(anou);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public Announcement findById(String id) {
        return null;
    }

    @Override
    public Announcement findById(int id) {
        return anouMapper.findById(id);
    }
}
