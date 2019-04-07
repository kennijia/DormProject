package edu.wbu.dorm.service;

import edu.wbu.dorm.model.Announcement;
import edu.wbu.dorm.service.base.BaseService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AnnouncementService extends BaseService<Announcement> {

    List<Announcement> findTopSixByTime();

    int deleteOne(int anouId,String uid,int role);

    int updateOne(int anouId,String title,String content,String uid,int role);

    /**
     * 公告图片上传
     * @param anouImg 图片数据
     * @param imgUploadPath 保存图片数据的真实路径
     * @return 返回图片的网络路径数组
     */
    String[] imgUpload(List<MultipartFile> anouImg, String imgUploadPath);

    /**
     * 发布公告
     * @param uid
     * @param title
     * @param html
     * @param anouPath
     * @param anouModelPath
     * @return
     */
    Boolean publish(String uid,String title,String html,String anouPath,String anouModelPath);
}
