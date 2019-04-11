package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.model.DormExt;

import java.util.List;

public interface DormMapper extends BaseMapper<Dorm> {
    /**
     * 通过宿舍楼编号和宿舍编号查询宿舍信息
     * @param dorm
     * @return
     */
    Dorm findByDbidAndDnumber(Dorm dorm);

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

    /**
     * 查找每个宿舍楼的已住人宿舍数量
     * @return
     */
    List<DormExt> findNumberByDbId();

    /**
     * 添加新的宿舍
     * @param d
     * @return
     */
    int insertDorm(Dorm d);





}
