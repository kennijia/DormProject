package edu.wbu.dorm.service;

import edu.wbu.dorm.model.DormApplication;
import edu.wbu.dorm.service.base.BaseService;

import java.util.List;

public interface DormApplicationService extends BaseService<DormApplication> {

    List<DormApplication> findOld(String pid);

    List<DormApplication> findNew(String pid);

    /**
     * 插入新的调换申请
     * @param da
     * @return
     */
    int insertNewApplication(DormApplication da);
}
