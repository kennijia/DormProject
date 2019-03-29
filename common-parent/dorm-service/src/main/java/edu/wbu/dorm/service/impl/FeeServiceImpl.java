package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Fee;
import edu.wbu.dorm.service.FeeService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeeServiceImpl extends BaseServiceImpl<Fee> implements FeeService {
    @Override
    public Fee findById(String id) {
        return null;
    }

    @Override
    public Fee findById(int id) {
        return feeMapper.findById(id);
    }
}
