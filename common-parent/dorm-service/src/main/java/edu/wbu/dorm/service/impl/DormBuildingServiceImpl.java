package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.DormBuilding;
import edu.wbu.dorm.service.DormBuildingService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DormBuildingServiceImpl extends BaseServiceImpl<DormBuilding> implements DormBuildingService {
    @Override
    public List<DormBuilding> findAll() {
        return dormBuildingMapper.findAll();
    }

    @Override
    public int insertNewBuilding(DormBuilding dormBuilding) {
        return dormBuildingMapper.insert(dormBuilding);
    }

    @Override
    public DormBuilding findById(String id) {
        return null;
    }

    @Override
    public DormBuilding findById(int id) {
        return null;
    }
}
