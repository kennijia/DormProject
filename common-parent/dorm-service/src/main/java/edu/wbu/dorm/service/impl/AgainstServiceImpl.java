package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Against;
import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.service.AgainstService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AgainstServiceImpl extends BaseServiceImpl<Against> implements AgainstService {
    @Override
    public Against findById(String id) {
        return null;
    }

    @Override
    public Against findById(int id) {
        return null;
    }

    @Override
    public List<Against> findByDormId(int dorm_id) {
        return againstMapper.findByDormId(dorm_id);
    }

    @Override
    public int submitAgainst(int dorm_id, String description, String punishment) {
        Dorm byId = dormMapper.findById(dorm_id);
        int i = 0;
        if (byId!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(new Date());
            Against a = new Against();
            a.setDorm_id(dorm_id);
            a.setDescription(description);
            a.setCreateTime(date);
            a.setPunishment(punishment);
            i = againstMapper.insert(a);
        }
        return i;
    }
}
