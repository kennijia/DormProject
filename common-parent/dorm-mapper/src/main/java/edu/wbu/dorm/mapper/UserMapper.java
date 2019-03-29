package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.User;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据u中属性来统计对应人数
     * @param u
     * @return
     */
    int countPerson(User u);

}
