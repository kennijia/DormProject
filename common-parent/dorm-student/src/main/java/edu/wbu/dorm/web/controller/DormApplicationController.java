package edu.wbu.dorm.web.controller;


import edu.wbu.dorm.common.annotation.PermissionCheck;
import edu.wbu.dorm.model.DormApplication;
import edu.wbu.dorm.model.DormApplicationExt;
import edu.wbu.dorm.model.PageBean;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.service.DormApplicationService;
import edu.wbu.dorm.service.DormService;
import edu.wbu.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/da")
public class DormApplicationController {
    @Autowired
    private DormApplicationService dormApplicationService;
    @Autowired
    private DormService dormService;
    @Autowired
    private UserService userService;

    @RequestMapping("/findOld")
    public @ResponseBody List<DormApplication> findOld(String id){
        return dormApplicationService.findOld(id);
    }

    @RequestMapping("/findNew")
    public @ResponseBody List<DormApplication> findNew(String id){
        return dormApplicationService.findNew(id);
    }

    @RequestMapping("/add")
    public @ResponseBody ResultInfo add(String uid,int to_db_id,int to_dorm_number,String reason){
        ResultInfo info = new ResultInfo(false);
        int i = dormApplicationService.insertNewApplication(uid,to_db_id,to_dorm_number,reason);
        if (i>0){
            info.setFlag(true);
        }else {
            info.setErrorMsg("您不满足入住条件或目标宿舍不满足入住条件，请重新选择。");
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

    @RequestMapping("/find")
    public @ResponseBody ResultInfo find(String currentPageStr){
        ResultInfo info = new ResultInfo(false);
        int currentPage = 1;
        if (currentPageStr!=null)
            currentPage = Integer.parseInt(currentPageStr);
        PageBean<DormApplicationExt> byPage = dormApplicationService.findByPage(currentPage);
        info.setData(byPage);
        info.setFlag(true);
        return info;
    }

    @RequestMapping("/findById")
    public @ResponseBody ResultInfo findById(String daIdStr){
        ResultInfo info = new ResultInfo(false);
        int daId = 0;
        if (daIdStr!=null&&!daIdStr.equals("")){
            daId = Integer.parseInt(daIdStr);
            DormApplication byId = dormApplicationService.findById(daId);
            DormApplication da = new DormApplication();
            da.setReason(byId.getReason());
            info.setData(da);
            info.setFlag(true);
        }
        return info;
    }

    /**
     * 管理员拒绝该申请
     * @param uid
     * @param daIdStr
     * @return
     */
    @PermissionCheck
    @RequestMapping("/refuse")
    public @ResponseBody ResultInfo refuse(String uid,String daIdStr){
        ResultInfo info = new ResultInfo(false);
        int daId = 0;
        if (daIdStr!=null&&!daIdStr.equals(""))
            daId = Integer.parseInt(daIdStr);
        //是管理员
        int i = dormApplicationService.updateStatus(daId, 1);
        if (i>0){
            info.setFlag(true);
        }
        return info;
    }

    /**
     *   管理员同意该申请
     * @param uid
     * @param daIdStr
     * @return
     */
    @PermissionCheck
    @RequestMapping("/agree")
    public @ResponseBody ResultInfo agree(String uid,String daIdStr){
        ResultInfo info = new ResultInfo(false);
        Boolean admin = userService.isAdmin(uid);
        int daId = 0;
        if (daIdStr!=null&&!daIdStr.equals(""))
            daId = Integer.parseInt(daIdStr);
        //if (admin){
            //是管理员
            int i = dormApplicationService.updateStatus(daId, 2);
            if (i>0){
                info.setFlag(true);
            }
        //}
        return info;
    }
}
