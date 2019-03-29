package edu.wbu.dorm.service.base;

import edu.wbu.dorm.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    //统一管理dao
    @Autowired
    protected UserMapper userMapper;

    @Autowired
    protected DormApplicationMapper daMapper;

    @Autowired
    protected DormMapper dormMapper;

    @Autowired
    protected DormBuildingMapper dormBuildingMapper;

    @Autowired
    protected FeeMapper feeMapper;

    @Autowired
    protected HygieneMapper hygieneMapper;

    @Autowired
    protected AgainstMapper againstMapper;

    @Autowired
    protected RepairMapper repairMapper;
}
