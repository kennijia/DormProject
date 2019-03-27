package edu.wbu.dorm.service;

import edu.wbu.dorm.model.DormBuilding;
import edu.wbu.dorm.service.base.BaseService;

import java.util.List;

public interface DormBuildingService extends BaseService<DormBuilding> {
    /**
     * 查询所有宿舍楼信息
     * @return
     */
    List<DormBuilding> findAll();

    /**
     * 加入新的宿舍楼
     * @param dormBuilding
     * @return
     */
    int insertNewBuilding(DormBuilding dormBuilding);
}
