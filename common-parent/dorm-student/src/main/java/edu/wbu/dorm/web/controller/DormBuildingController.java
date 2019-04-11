package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.DormBuilding;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.service.DormBuildingService;
import edu.wbu.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/db")
public class DormBuildingController {
    @Autowired
    private DormBuildingService dormBuildingService;
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public @ResponseBody List<DormBuilding> findAll(){
        return dormBuildingService.findAll();
    }

    @RequestMapping("/add")
    public @ResponseBody ResultInfo add(String location, String roomNumber, String builtuptime, int dbType){
        DormBuilding db = new DormBuilding();
        ResultInfo info = new ResultInfo(false);
        db.setLocation(location);
        int capacity = 100;//默认100间房
        try {
            if (roomNumber!=null&&!roomNumber.equals(""))
                capacity = Integer.parseInt(roomNumber);
            db.setCapacity(capacity);
            db.setBuiltuptime(builtuptime);
            db.setType(dbType);
        } catch (NumberFormatException e) {
            return info;
        }
        int i;
        i = dormBuildingService.insertNewBuilding(db);
        if (i>0)
            info.setFlag(true);
        return info;
    }


}
