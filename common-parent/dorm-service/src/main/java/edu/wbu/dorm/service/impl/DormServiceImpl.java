package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.service.DormService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DormServiceImpl extends BaseServiceImpl<Dorm> implements DormService {

    @Override
    public int addPerson(Dorm dorm) {
        return dormMapper.updateOccupy(dorm);
    }

    @Override
    public List<Dorm> findAllDorms(int db_id) {
        return dormMapper.findAllDorms(db_id);
    }

    @Override
    public Boolean isAdd(int db_id, int dorm_number) {
        Dorm dorm = dormMapper.findByDbidAndDid(new Dorm(db_id, dorm_number));
        if (dorm==null)
            return false;//没有该宿舍
        if (dorm.getOccupy()<dorm.getCapacity())
            return true;//找到该宿舍且没有住满人
        else
            return false;//找到该宿舍但已满人
    }


    @Override
    public Dorm findById(String id) {
        return null;
    }

    @Override
    public Dorm findById(int id) {
        return dormMapper.findById(id);
    }
}
