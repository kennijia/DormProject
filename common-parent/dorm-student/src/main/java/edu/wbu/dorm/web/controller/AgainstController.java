package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.Against;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.model.User;
import edu.wbu.dorm.service.AgainstService;
import edu.wbu.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/against")
public class AgainstController {
    @Autowired
    private AgainstService againstService;
    @Autowired
    private UserService userService;


    @RequestMapping("/find")
    public @ResponseBody ResultInfo find(String uid){
        ResultInfo info = new ResultInfo(false);
        User user = userService.findById(uid);
        List<Against> againsts = againstService.findByDormId(user.getDorm_id());
        info.setData(againsts);
        info.setFlag(true);
        return info;
    }

    @RequestMapping("/insert")
    public @ResponseBody ResultInfo insert(String dorm_idStr,String description,String punishment){
        ResultInfo info = new ResultInfo(false);
        if (dorm_idStr==null&&dorm_idStr.equals(""))
            return info;
        int dorm_id = Integer.parseInt(dorm_idStr);
        int i = againstService.submitAgainst(dorm_id,description,punishment);
        if (i>0)
            info.setFlag(true);
        return info;
    }
}
