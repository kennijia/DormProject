package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Against;
import edu.wbu.dorm.service.AgainstService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
