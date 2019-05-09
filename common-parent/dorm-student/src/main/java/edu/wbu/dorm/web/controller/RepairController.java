package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.common.annotation.PermissionCheck;
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

    /**
     * 用户查看自己宿舍的报修记录
     * @param uid
     * @return
     */
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

    /**
     * 用户提交新的报修申请
     * @param content
     * @param uid
     * @return
     */
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

    /**
     * 管理员查看所有的报修申请
     * @param currentPageStr
     * @return
     */
    @PermissionCheck
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

    /**
     * 管理员同意派遣工作人员
     * @param uid
     * @param ridStr
     * @return
     */
    @PermissionCheck
    @RequestMapping("/send")
    public @ResponseBody ResultInfo send(String uid,String ridStr){
        ResultInfo info = new ResultInfo(false);
        Boolean admin = userService.isAdmin(uid);
        int rid = 0;
        if (ridStr!=null&&!ridStr.equals(""))
            rid = Integer.parseInt(ridStr);
        if (admin){
            int i = repairService.send(rid,1);
            if (i>0)
                info.setFlag(true);
        }
        return info;
    }

    /**
     * 用户认为该报修已完成
     * @param uid
     * @param ridStr
     * @return
     */
    @RequestMapping("/complete")
    public @ResponseBody ResultInfo complete(String uid,String ridStr){
        ResultInfo info = new ResultInfo(false);
        if (!userService.exists(uid))
            return info;
        int rid = 0;
        if (ridStr!=null&&!ridStr.equals("")){
            rid = Integer.parseInt(ridStr);
            int i = repairService.repairComplete(rid,2);
            if (i>0)
                info.setFlag(true);
        }
        return info;
    }

    @RequestMapping("/delete")
    public @ResponseBody ResultInfo delete(String uid,String ridStr){
        ResultInfo info = new ResultInfo(false);
        if (!userService.exists(uid))
            return info;
        int rid = 0;
        if (ridStr!=null&&!ridStr.equals("")){
            rid = Integer.parseInt(ridStr);
            int i = repairService.deleteRepair(rid);
            if (i>0)
                info.setFlag(true);
        }
        return info;
    }

    @RequestMapping("/findOne")
    public @ResponseBody ResultInfo findOne(String uid,String ridStr){
        ResultInfo info = new ResultInfo(false);
        if (!userService.exists(uid))
            return info;
        int rid = 0;
        if (ridStr!=null&&!ridStr.equals("")){
            rid = Integer.parseInt(ridStr);
            String content = repairService.findContent(rid);
            info.setData(content);
            info.setFlag(true);
        }
        return info;
    }
}
