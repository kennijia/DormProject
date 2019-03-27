package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.service.DormService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormServiceImpl extends BaseServiceImpl<Dorm> implements DormService {

    @Override
    public Dorm findOccupy(Dorm dorm) {
        return dormMapper.findByDbidAndDid(dorm);
    }

    @Override
    public int addPerson(Dorm dorm) {
        return dormMapper.updateOccupy(dorm);
    }

    @Override
    public List<Dorm> findAllDorms(int db_id) {
        return dormMapper.findAllDorms(db_id);
    }

    @Override
    public Dorm findById(String id) {
        return null;
    }

    @Override
    public Dorm findById(int id) {
        return null;
    }
}
