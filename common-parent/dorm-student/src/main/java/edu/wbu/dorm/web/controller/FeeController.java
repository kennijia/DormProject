package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.service.DormService;
import edu.wbu.dorm.service.FeeService;
import edu.wbu.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fee")
public class FeeController {
    @Autowired
    private FeeService feeService;
    @Autowired
    private UserService userService;
    @Autowired
    private DormService dormService;

    @RequestMapping("/find")
    public @ResponseBody ResultInfo find(String uid){
        ResultInfo info = new ResultInfo(false);
        if (!dormService.isOutside(uid)){
            //如果住在校内，则发送相关数据
            int dorm_id = userService.findById(uid).getDorm_id();
            int feeId = dormService.findById(dorm_id).getFee_id();
            info.setData(feeService.findById(feeId));
            info.setFlag(true);
        }
        return info;
    }
}
