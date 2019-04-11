package edu.wbu.dorm.service;

import edu.wbu.dorm.model.User;
import edu.wbu.dorm.service.base.BaseService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
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
    Map<String, Integer> countPersonProportion();

    /**
     * 验证该用户是否是管理员
     * @param uid
     * @return
     */
    Boolean isAdmin(String uid);

    /**
     * 判断数据中是否存在该用户
     * @param uid
     * @return
     */
    Boolean exists(String uid);

    /**
     * 为新生们分配宿舍
     */
    Map<String ,Integer> distributionOfDorm();

    /**
     * 修改用户头像
     * @param uid
     * @param path
     * @param headImg
     * @return 头像的项目路径
     */
    String changeImg(String uid,String path, MultipartFile headImg);

    /**
     * 统计未安排住宿的人数
     * @return
     */
    Map<String,Integer> count();

    /**
     * 查找有哪些未安排住宿的人
     * @param behavior
     * @return
     */
    List<User> findNoDistributionPerson(int behavior);

    Boolean uploadExcel(MultipartFile file);

}
