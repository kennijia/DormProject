package edu.wbu.dorm.mapper;

import edu.wbu.dorm.model.DormApplication;

import java.util.List;

public interface DormApplicationMapper {
    /**
     * 通过id查询已受理调换申请记录
     * @param id
     * @return
     */
    List<DormApplication> findOldById(String id);

    /**
     * 通过id查询未受理调换申请记录
     * @param id
     * @return
     */
    List<DormApplication> findNewById(String id);

    /**
     * 将申请存入数据库中
     * @param dormApplication
     * @return
     */
    int insertApplication(DormApplication dormApplication);

}
