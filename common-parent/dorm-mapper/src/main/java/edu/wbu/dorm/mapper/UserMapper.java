package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据u中属性来统计对应人数
     * @param u
     * @return
     */
    int countPerson(User u);

    /**
     * 查找出所有未分配宿舍的男或女学生
     * @return
     */
    List<User> findFemaleOrMale(User u);

    /**
     * 为该生分配宿舍
     * @return
     */
    int updateDormId(User u);

    /**
     * 修改头像
     * @param u
     * @return
     */
    int updateImg(User u);

    List<User> findByRoleAndGenderAndDormId(User u);

    /**
     * 插入新用户
     * @param u
     * @return
     */
    int insertUser(User u);


}
