package edu.wbu.dorm.service;

import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.service.base.BaseService;
import java.util.List;

public interface DormService  extends BaseService<Dorm> {
    /**
     * 查找宿舍现住人数
     * @param dorm
     * @return
     */
    Dorm findOccupy(Dorm dorm);

    /**
     * 增加宿舍人数
     * @param dorm
     * @return
     */
    int addPerson(Dorm dorm);

    /**
     * 查找对应楼号中所有的宿舍
     * @param db_id
     * @return
     */
    List<Dorm> findAllDorms(int db_id);
}
