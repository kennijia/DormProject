package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.DormBuilding;
import edu.wbu.dorm.model.DormExt;

import java.util.List;

public interface DormBuildingMapper extends BaseMapper<DormBuilding> {
    /**
     * 查询数据库中已有宿舍楼信息
     * @return
     */
    List<DormBuilding> findAll();

    /**
     * 添加新的宿舍楼信息
     * @param db
     * @return
     */
    int insert(DormBuilding db);

    /**
     * 查找某类型的有空余位置的宿舍
     * @return
     */
    List<DormBuilding> findEmptyDorm(int type);

    /**
     * 更新各个宿舍楼的已住人的宿舍数量
     * @param dormExt
     * @return
     */
    int updateOccupy(DormExt dormExt);
}
