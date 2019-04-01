package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.Repair;
import edu.wbu.dorm.model.RepairExt;

import java.util.List;

public interface RepairMapper extends BaseMapper<Repair> {

    List<Repair> findByDormId(int dorm_id);

    int insert(Repair repair);

    int countAll();

    List<RepairExt> findByPage(int selectedRow);
}
