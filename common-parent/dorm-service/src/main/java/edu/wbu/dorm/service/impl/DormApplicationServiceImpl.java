package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.DormApplication;
import edu.wbu.dorm.service.DormApplicationService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormApplicationServiceImpl extends BaseServiceImpl<DormApplication> implements DormApplicationService {
    @Override
    public List<DormApplication> findOld(String pid) {
        return daMapper.findOldById(pid);
    }

    @Override
    public List<DormApplication> findNew(String pid) {
        return daMapper.findNewById(pid);
    }

    @Override
    public int insertNewApplication(DormApplication da) {
        return daMapper.insertApplication(da);
    }

    @Override
    public DormApplication findById(String id) {
        return null;
    }

    @Override
    public DormApplication findById(int id) {
        return null;
    }


}
