package edu.wbu.dorm.mapper;

import edu.wbu.dorm.model.DormBuilding;

import java.util.List;

public interface DormBuildingMapper {
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
}
