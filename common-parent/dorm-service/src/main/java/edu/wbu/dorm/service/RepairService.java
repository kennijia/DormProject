package edu.wbu.dorm.service;

import edu.wbu.dorm.model.Repair;
import edu.wbu.dorm.service.base.BaseService;

import java.util.List;

public interface RepairService extends BaseService<Repair> {

    List<Repair> findByDormId(int dorm_id);

    int insertNewRepair(int dorm_id,String content);
}
