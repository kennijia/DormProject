package edu.wbu.dorm.service;

import edu.wbu.dorm.model.User;
import edu.wbu.dorm.service.base.BaseService;

import java.math.BigDecimal;
import java.util.Map;

public interface UserService extends BaseService<User> {
    /**
     * 登录
     * @param uid
     * @param password
     * @return
     */
    Boolean login(String uid,String password);

    /**
     * 统计人群比例
     * @return
     */
    Map<String, Double> countPersonProportion();

    /**
     * 验证该用户是否是管理员
     * @param uid
     * @param role
     * @return
     */
    Boolean isAdmin(String uid,int role);
}
