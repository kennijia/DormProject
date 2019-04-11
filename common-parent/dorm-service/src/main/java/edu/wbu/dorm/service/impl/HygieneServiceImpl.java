package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.model.Hygiene;
import edu.wbu.dorm.service.HygieneService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class HygieneServiceImpl extends BaseServiceImpl<Hygiene> implements HygieneService {
    @Override
    public Hygiene findById(String id) {
        return null;
    }

    @Override
    public Hygiene findById(int id) {
        return null;
    }

    @Override
    public List<Hygiene> findByDormId(int dorm_id) {
        return hygieneMapper.findByDormId(dorm_id);
    }

    @Override
    public int submitHygiene(int dorm_id, String description, String comments) {
        Dorm byId = dormMapper.findById(dorm_id);
        int i = 0;
        if (byId!=null){
            Hygiene h = new Hygiene();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(new Date());
            h.setCreateTime(date);
            h.setDescription(description);
            h.setComments(comments);
            h.setDorm_id(dorm_id);
            i = hygieneMapper.insert(h);
        }
        return i;
    }
}
