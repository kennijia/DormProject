package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.User;
import edu.wbu.dorm.service.UserService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    public Boolean login(String uid, String password) {
        User u = userMapper.findById(uid);
        if (u==null)
            //没有该用户
            return false;
        if (password.equals(u.getPassword()))
            //找到用户且密码正确
            return true;
        else
            //找到用户但密码错误
            return false;
    }

    @Override
    public Map<String, Double> countPersonProportion() {
        Map<String,Double> map = new HashMap<String,Double>();
        User u = new User();
        u.setGender("男");
        u.setRole(0);
        double countMale = (double)userMapper.countPerson(u);
        u.setGender("女");
        double countFemale = (double)userMapper.countPerson(u);
        Double maleProportion = new BigDecimal(countMale/(countMale+countFemale)*100).setScale(1,BigDecimal.ROUND_UP).doubleValue();
        Double femaleProportion = 100.0 - maleProportion;
        map.put("male",maleProportion);
        map.put("female",femaleProportion);
        return map;
    }

    /**
     * 查找用户信息
     * @param id
     * @return
     */
    public User findById(String id) {
        User user = userMapper.findById(id);
        user.setPassword("");
        return user;

    }

    public User findById(int id) {
        return null;
    }
}
