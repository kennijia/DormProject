package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.model.DormApplication;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.service.DormApplicationService;
import edu.wbu.dorm.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/da")
public class DormApplicationController {
    @Autowired
    private DormApplicationService dormApplicationService;
    @Autowired
    private DormService dormService;

    @RequestMapping("/findOld")
    public @ResponseBody List<DormApplication> findOld(String id){
        return dormApplicationService.findOld(id);
    }

    @RequestMapping("/findNew")
    public @ResponseBody List<DormApplication> findNew(String id){
        return dormApplicationService.findNew(id);
    }

    @RequestMapping("/add")
    public @ResponseBody ResultInfo add(String personId,int to_db_id,int to_dorm_id,String reason){
        ResultInfo info = new ResultInfo();
        //首先判断目标宿舍是否能住人
        Boolean add = dormService.isAdd(to_db_id, to_dorm_id);
        if (add){
            //能入住，将申请信息放入数据库中等待管理员审核
            dormApplicationService.insertNewApplication(new DormApplication(personId,reason,to_db_id,to_dorm_id));
            info.setFlag(true);
        }else {
            //不能入住，则返回false
            info.setFlag(false);
            info.setErrorMsg("该宿舍不满足入住条件，请重新选择。");
        }
        return info;
    }

    @RequestMapping("/delete")
    public @ResponseBody ResultInfo deleteOne(int id){
        int i = dormApplicationService.delete(id);
        ResultInfo info = new ResultInfo();
        if (i>0)
            info.setFlag(true);//代表删除成功
        else
            info.setFlag(false);

        return info;
    }
    @RequestMapping("/update")
    public @ResponseBody ResultInfo update(DormApplication dorm){
        ResultInfo info = new ResultInfo();
        int i = dormApplicationService.update(dorm);
        if (i>0)
            info.setFlag(true);//代表修改成功
        else
            info.setFlag(false);
        return info;
    }


}
