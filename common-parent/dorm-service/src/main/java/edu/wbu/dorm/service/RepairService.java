package edu.wbu.dorm.service;

import edu.wbu.dorm.model.PageBean;
import edu.wbu.dorm.model.Repair;
import edu.wbu.dorm.model.RepairExt;
import edu.wbu.dorm.service.base.BaseService;

import java.util.List;

public interface RepairService extends BaseService<Repair> {

    List<Repair> findByDormId(int dorm_id);

    int insertNewRepair(String uid,String content);

    List<Repair> findRepairs(String uid);

    PageBean<RepairExt> findByPage(int currentPage);

    int send(int rid,int status);

    int repairComplete(int rid,int status);

    int deleteRepair(int rid);

    String findContent(int rid);
}
