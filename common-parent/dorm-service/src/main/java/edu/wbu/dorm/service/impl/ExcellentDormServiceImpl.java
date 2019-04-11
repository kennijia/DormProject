package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.ExcellentDorm;
import edu.wbu.dorm.service.ExcellentDormService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
@Transactional
public class ExcellentDormServiceImpl extends BaseServiceImpl<ExcellentDorm> implements ExcellentDormService {
    @Override
    public List<ExcellentDorm> findAll() {
        return excellentDormMapper.findAll();
    }

    @Override
    public int ed(int edId, int ed_dormId, List<MultipartFile> ed_imgs, MultipartFile ed_introduce, String savePath) {
        File file = new File(savePath);
        if (!file.exists())
            file.mkdirs();
        //处理3张图片
        StringBuilder totalImgs = new StringBuilder();
        StringBuilder content;
        try {
            for (MultipartFile f: ed_imgs){
                String suffix = f.getOriginalFilename().split("\\.")[1];
                System.out.println(suffix);
                String newImgName = System.currentTimeMillis()+"."+suffix;
                String totalPath = savePath+"/"+newImgName;
                FileCopyUtils.copy(f.getInputStream(),new FileOutputStream(new File(totalPath)));
                totalImgs.append("image/excellentDormImg/"+newImgName+",");
            }
            //处理上传的文本
            BufferedReader bf = new BufferedReader(new InputStreamReader(ed_introduce.getInputStream()));
            content = new StringBuilder();
            String line ;
            while (( line= bf.readLine())!=null) {
                content.append(line);
                System.out.println(line);
            }
            bf.close();
        } catch (IOException e) {
            return 0;
        }
        ExcellentDorm ed = new ExcellentDorm();
        ed.setId(edId);
        ed.setDorm_id(ed_dormId);
        ed.setImgs(totalImgs.toString());
        ed.setIntroduce(content.toString());
        int i = excellentDormMapper.update(ed);
        return i;
    }

    @Override
    public ExcellentDorm findById(String id) {
        return null;
    }

    @Override
    public ExcellentDorm findById(int id) {
        return null;
    }
}
