package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.Announcement;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.service.AnnouncementService;
import edu.wbu.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/anou")
public class AnnouncementController {
    @Autowired
    private AnnouncementService anouService;
    @Autowired
    private UserService userService;

    @RequestMapping("/findSix")
    public @ResponseBody ResultInfo findTopFive(){
        ResultInfo info = new ResultInfo();
        info.setData(anouService.findTopSixByTime());
        info.setFlag(true);
        return info;
    }
    @RequestMapping("/findOne")
    public @ResponseBody ResultInfo findOne(int anouId){
        ResultInfo info = new ResultInfo();
        Announcement byId = anouService.findById(anouId);
        info.setFlag(true);
        info.setData(byId);
        return info;
    }

    @RequestMapping("/delete")
    public @ResponseBody ResultInfo delete(int anouId,String uid,int role){
        ResultInfo info = new ResultInfo(false);
        int i = anouService.deleteOne(anouId,uid,role);
        if (i>0)
            info.setFlag(true);
        return info;
    }

    @RequestMapping("/update")
    public @ResponseBody ResultInfo update(int anouId,String anouTitle,String anouContent,String uid,int role){
        ResultInfo info = new ResultInfo(false);
        int i = anouService.updateOne(anouId,anouTitle,anouContent,uid,role);
        if (i>0)
            info.setFlag(true);
        return info;
    }

}
