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

    /**
     * 删除对应申请
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 修改申请
     * @param dorm
     * @return
     */
    int update(DormApplication dorm);

    /**
     * 查找对应的申请数据
     * @param id
     * @return
     */
    DormApplication findOne(int id);
}
