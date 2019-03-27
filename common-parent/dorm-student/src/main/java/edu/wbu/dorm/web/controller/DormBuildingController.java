package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.DormBuilding;
import edu.wbu.dorm.service.DormBuildingService;
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

    @RequestMapping("/findAll")
    public @ResponseBody List<DormBuilding> findAll(){
        return dormBuildingService.findAll();
    }

    @RequestMapping("/add")
    public @ResponseBody int add(DormBuilding db){
        return dormBuildingService.insertNewBuilding(db);
    }
}
