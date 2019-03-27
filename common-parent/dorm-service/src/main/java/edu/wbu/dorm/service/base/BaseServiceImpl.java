package edu.wbu.dorm.service.base;

import edu.wbu.dorm.mapper.DormApplicationMapper;
import edu.wbu.dorm.mapper.DormBuildingMapper;
import edu.wbu.dorm.mapper.DormMapper;
import edu.wbu.dorm.mapper.StudentMapper;
import edu.wbu.dorm.model.DormBuilding;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    //统一管理dao
    @Autowired
    protected StudentMapper stuMapper;

    @Autowired
    protected DormApplicationMapper daMapper;

    @Autowired
    protected DormMapper dormMapper;

    @Autowired
    protected DormBuildingMapper dormBuildingMapper;
}
