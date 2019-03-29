package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.Hygiene;

import java.util.List;

public interface HygieneMapper extends BaseMapper<Hygiene> {

    List<Hygiene> findByDormId(int dorm_id);

    int insert(Hygiene h);
}
