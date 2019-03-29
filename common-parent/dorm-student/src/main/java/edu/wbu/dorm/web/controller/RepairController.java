package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.Repair;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.service.RepairService;
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

    @RequestMapping("/find")
    public @ResponseBody ResultInfo find(int dorm_id){
        ResultInfo info = new ResultInfo();
        List<Repair> repairs = repairService.findByDormId(dorm_id);
        info.setData(repairs);
        info.setFlag(true);
        return info;
    }
    @RequestMapping("/add")
    public @ResponseBody ResultInfo add(String content,int dorm_id){
        ResultInfo info = new ResultInfo();
        int i = repairService.insertNewRepair(dorm_id,content);
        if (i>0)
            info.setFlag(true);
        else
            info.setFlag(false);
        return info;
    }
}
