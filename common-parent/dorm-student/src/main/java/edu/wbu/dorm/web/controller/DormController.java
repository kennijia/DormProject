package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.common.annotation.PermissionCheck;
import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dorm")
public class DormController {
    @Autowired
    private DormService dormService;

    /**
     * 获取某栋宿舍楼中的所有宿舍
     * @param db_id
     * @return
     */
    @RequestMapping("/findAll")
    public @ResponseBody List<Dorm> findAll(int db_id){
        return dormService.findAllDorms(db_id);
    }

    @RequestMapping("/findOne")
    public @ResponseBody ResultInfo findOne(int dorm_id){
        ResultInfo info = new ResultInfo(false);
        if (dorm_id==0)
            return info;
        info.setFlag(true);
        info.setData(dormService.findById(dorm_id));
        return info;
    }

    /**
     *  管理员添加宿舍
     * @param dbId
     * @param dormNumber
     * @param roomCapacity
     * @return
     */
    @PermissionCheck
    @RequestMapping("/add")
    public @ResponseBody ResultInfo add(String dbId,String dormNumber,String roomCapacity){
        ResultInfo info = new ResultInfo(false);
        if (dbId==null||dbId.equals("")||dormNumber==null||dormNumber.equals("")||roomCapacity==null||roomCapacity.equals(""))
            return info;
        int i = 0;
        try {
            i = dormService.addDorm(Integer.parseInt(dbId),Integer.parseInt(dormNumber),Integer.parseInt(roomCapacity));
        } catch (NumberFormatException e) {
            return info;
        }
        if (i>0)
            info.setFlag(true);
        return info;
    }
}
