package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Repair;
import edu.wbu.dorm.service.RepairService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RepairServiceImpl extends BaseServiceImpl<Repair> implements RepairService {
    @Override
    public List<Repair> findByDormId(int dorm_id) {
        return repairMapper.findByDormId(dorm_id);
    }

    @Override
    public int insertNewRepair(int dorm_id, String content) {
        Repair r = new Repair(dorm_id,content);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        r.setCreateTime(date);
        int i = repairMapper.insert(r);
        return i;
    }

    @Override
    public Repair findById(String id) {
        return null;
    }

    @Override
    public Repair findById(int id) {
        return null;
    }
}
