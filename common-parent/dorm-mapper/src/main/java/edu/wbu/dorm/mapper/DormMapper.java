package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.Dorm;

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

}
