package edu.wbu.dorm.service;

import edu.wbu.dorm.model.Announcement;
import edu.wbu.dorm.service.base.BaseService;

import java.util.List;

public interface AnnouncementService extends BaseService<Announcement> {

    List<Announcement> findTopSixByTime();

    int deleteOne(int anouId,String uid,int role);

    int updateOne(int anouId,String title,String content,String uid,int role);
}
