package edu.wbu.dorm.service;

import edu.wbu.dorm.model.Hygiene;
import edu.wbu.dorm.service.base.BaseService;

import java.util.List;

public interface HygieneService extends BaseService<Hygiene> {
    List<Hygiene> findByDormId(int dorm_id);
}
