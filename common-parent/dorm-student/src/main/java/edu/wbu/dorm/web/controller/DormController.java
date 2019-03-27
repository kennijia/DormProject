package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.Dorm;
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

    @RequestMapping("/findAll")
    public @ResponseBody List<Dorm> findAll(int db_id){
        return dormService.findAllDorms(db_id);
    }
}
