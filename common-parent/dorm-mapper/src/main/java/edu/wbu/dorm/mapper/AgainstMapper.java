package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.Against;

import java.util.List;

public interface AgainstMapper extends BaseMapper<Against> {

    List<Against> findByDormId(int dorm_id);
}
