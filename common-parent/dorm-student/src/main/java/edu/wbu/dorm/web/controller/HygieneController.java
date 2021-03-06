package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.common.annotation.PermissionCheck;
import edu.wbu.dorm.model.Hygiene;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.service.HygieneService;
import edu.wbu.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/hygiene")
public class HygieneController {
    @Autowired
    private HygieneService hygieneService;
    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public @ResponseBody ResultInfo find(String uid){
        ResultInfo info = new ResultInfo(false);
        int dorm_id = userService.findById(uid).getDorm_id();
        if (dorm_id==0)
            return info;
        List<Hygiene> hygienes = hygieneService.findByDormId(dorm_id);
        info.setData(hygienes);
        info.setFlag(true);
        return info;
    }

    /**
     * 管理员添加卫生情况
     * @param dorm_idStr
     * @param description
     * @param comments
     * @return
     */
    @PermissionCheck
    @RequestMapping("/insert")
    public @ResponseBody ResultInfo insert(String dorm_idStr,String description,String comments){
        ResultInfo info = new ResultInfo(false);
        if (dorm_idStr==null||dorm_idStr.equals(""))
            return info;
        int dorm_id = Integer.parseInt(dorm_idStr);
        int i = hygieneService.submitHygiene(dorm_id,description,comments);
        if (i>0){
            info.setFlag(true);
        }
        return info;
    }
}
