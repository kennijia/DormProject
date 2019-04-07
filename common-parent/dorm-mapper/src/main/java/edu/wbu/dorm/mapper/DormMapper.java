package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.Dorm;

import java.util.List;

public interface DormMapper extends BaseMapper<Dorm> {
    /**
     * 通过宿舍楼编号和宿舍编号查询宿舍信息
     * @param dorm
     * @return
     */
    Dorm findByDbidAndDid(Dorm dorm);

    /**
     * 根据宿舍id更新宿舍现住人数
     * @param dorm
     * @return
     */
    int updateOccupy(Dorm dorm);

    /**
     * 查找该宿舍楼所拥有的所有宿舍
     * @param db_id
     * @return
     */
    List<Dorm> findAllDorms(int db_id);

    /**
     * 查找出所有有剩余位置的男或女宿舍
     * @param gender
     * @return
     */
    List<Dorm> findEmptyDorm(String gender);

}
