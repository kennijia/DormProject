package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Hygiene;
import edu.wbu.dorm.service.HygieneService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HygieneServiceImpl extends BaseServiceImpl<Hygiene> implements HygieneService {
    @Override
    public Hygiene findById(String id) {
        return null;
    }

    @Override
    public Hygiene findById(int id) {
        return null;
    }

    @Override
    public List<Hygiene> findByDormId(int dorm_id) {
        return hygieneMapper.findByDormId(dorm_id);
    }
}
