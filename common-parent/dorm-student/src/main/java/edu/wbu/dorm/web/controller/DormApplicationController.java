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
    public @ResponseBody ResultInfo add(String personId,int to_db_id,int to_dorm_id,String reason, HttpSession session){
        //如果用户登录了，则开始业务操作
        Object onlineUser = session.getAttribute("user");
        System.out.println(onlineUser);
        ResultInfo info = new ResultInfo();
        if (onlineUser!=null){
            //首先判断目标宿舍是否满人，满人则提交失败
            Dorm d = new Dorm(to_db_id,to_dorm_id);
            Dorm dorm = dormService.findOccupy(d);
            DormApplication da = new DormApplication();
            da.setPid(personId);
            da.setTo_db_id(to_db_id);
            da.setTo_dorm_id(to_dorm_id);
            da.setReason(reason);
            if (dorm.getOccupy()<dorm.getCapacity()){
                //没有满人，那么将申请信息放入表中等待管理员审核
                dormApplicationService.insertNewApplication(da);
                info.setFlag(true);
            }else {
                //目标宿舍满人，驳回提交申请并返回false
                info.setFlag(false);
                info.setErrorMsg("目标宿舍满人了哦，请重新选择。");
            }
        }else{
            //用户未登录，则提示登录
            info.setFlag(false);
        }
        return info;
    }
    @RequestMapping("/findOne")
    public @ResponseBody DormApplication findOne(int id){
        return dormApplicationService.findOne(id);
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
