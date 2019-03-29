package edu.wbu.dorm.service;

import edu.wbu.dorm.model.Against;
import edu.wbu.dorm.service.base.BaseService;

import java.util.List;

public interface AgainstService extends BaseService<Against> {

    List<Against> findByDormId(int dorm_id);
}
