package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.DormApplication;
import edu.wbu.dorm.model.DormApplicationExt;
import edu.wbu.dorm.model.PageBean;

import java.util.List;

public interface DormApplicationMapper extends BaseMapper<DormApplication> {
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

    /**
     * 根据id删除对应申请信息
     * @param id
     * @return
     */
    int deleteApplication(int id);

    /**
     * 根据id查询出对应申请信息
     * @param id
     * @return
     */
    DormApplication findOne(int id);

    /**
     * 根据id修改对应原来申请信息
     * @param dorm
     * @return
     */
    int updateApplication(DormApplication dorm);

    /**
     * 查找有多少条记录
     * @return
     */
    int countAll();

    /**
     * 查找对应页数下的记录信息
     * @param selectedRow
     * @return
     */
    List<DormApplicationExt> findByPage(int selectedRow);

    /**
     * 修改申请的受理状态
     * @param dormApplication
     * @return
     */
    int updateStatus(DormApplication dormApplication);

}
