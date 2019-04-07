package edu.wbu.dorm.service;

import edu.wbu.dorm.model.DormApplication;
import edu.wbu.dorm.model.DormApplicationExt;
import edu.wbu.dorm.model.PageBean;
import edu.wbu.dorm.service.base.BaseService;

import java.util.List;

public interface DormApplicationService extends BaseService<DormApplication> {

    List<DormApplication> findOld(String pid);

    List<DormApplication> findNew(String pid);

    /**
     * 新的换宿舍申请
     * @param uid
     * @param to_db_id
     * @param to_dorm_number
     * @param reason
     * @return
     */
    int insertNewApplication(String uid,int to_db_id,int to_dorm_number,String reason);

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

    /**
     * 查找所有申请
     * @return
     */
    PageBean<DormApplicationExt> findByPage(int currentPage);

    /**
     * 改变申请的状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(int id,int status);
}
