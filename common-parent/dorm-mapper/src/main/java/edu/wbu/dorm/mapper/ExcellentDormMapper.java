package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.ExcellentDorm;

import java.util.List;

public interface ExcellentDormMapper extends BaseMapper<ExcellentDorm> {

    List<ExcellentDorm> findAll();

    int update(ExcellentDorm ed);
}
