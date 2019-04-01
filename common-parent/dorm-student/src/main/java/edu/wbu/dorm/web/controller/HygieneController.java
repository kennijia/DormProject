package edu.wbu.dorm.web.controller;

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
}
