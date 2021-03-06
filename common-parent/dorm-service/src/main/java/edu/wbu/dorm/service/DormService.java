package edu.wbu.dorm.service;

import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.service.base.BaseService;
import java.util.List;

public interface DormService  extends BaseService<Dorm> {
    /**
     * 查找对应楼号中所有的宿舍
     * @param db_id
     * @return
     */
    List<Dorm> findAllDorms(int db_id);

    /**
     * 判断该宿舍能否再入住一人
     * @param db_id
     * @param dorm_number
     * @return
     */
    Boolean isAdd(int db_id,int dorm_number);

    Boolean isOutside(String uid);

    /**
     * 在已有宿舍楼的基础上添加宿舍
     * @param db_Id
     * @param dorm_number
     * @param capacity
     * @return
     */
    int addDorm(int db_Id,int dorm_number,int capacity);
}
