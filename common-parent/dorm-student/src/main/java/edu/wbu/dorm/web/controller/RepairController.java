package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.PageBean;
import edu.wbu.dorm.model.Repair;
import edu.wbu.dorm.model.RepairExt;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.service.RepairService;
import edu.wbu.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;
    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public @ResponseBody ResultInfo find(String uid){
        ResultInfo info = new ResultInfo(false);
        List<Repair> repairs = repairService.findRepairs(uid);
        if (repairs!=null){
            info.setFlag(true);
            info.setData(repairs);
        }
        return info;
    }
    @RequestMapping("/add")
    public @ResponseBody ResultInfo add(String content,String uid){
        ResultInfo info = new ResultInfo(false);
        int i = repairService.insertNewRepair(uid,content);
        if (i>0)
            info.setFlag(true);
        else
            info.setFlag(false);
        return info;
    }

    @RequestMapping("/adminFind")
    public @ResponseBody ResultInfo adminFind(String currentPageStr){
        ResultInfo info = new ResultInfo(false);
        int currentPage = 1;
        if (currentPageStr!=null&&!currentPageStr.equals("")){
            currentPage = Integer.parseInt(currentPageStr);
        }
        PageBean<RepairExt> byPage = repairService.findByPage(currentPage);
        info.setFlag(true);
        info.setData(byPage);
        return info;
    }
}
