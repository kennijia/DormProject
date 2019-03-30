package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Announcement;
import edu.wbu.dorm.service.AnnouncementService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement> implements AnnouncementService {
    @Override
    public List<Announcement> findTopSixByTime() {
        return anouMapper.findTopSixByTime();
    }

    @Override
    public int deleteOne(int anouId, String uid, int role) {
        int i = 0;
        if (userMapper.findById(uid).getRole()==2){
            //权限通过
            i = anouMapper.delete(anouId);
        }else
            System.out.println("权限不足");
        return i;
    }

    @Override
    public int updateOne(int anouId, String title, String content, String uid, int role) {
        int m = 0;
        if (userMapper.findById(uid).getRole()==2){
            //权限通过
            Announcement anou = new Announcement(anouId,title,content);
            m = anouMapper.update(anou);
        }else
            System.out.println("权限不足");
        return m;
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
