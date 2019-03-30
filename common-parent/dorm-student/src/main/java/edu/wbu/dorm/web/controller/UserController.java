package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.model.User;
import edu.wbu.dorm.service.UserService;
import edu.wbu.dorm.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public @ResponseBody ResultInfo login(String id, String password, HttpServletResponse res, HttpSession session){
        ResultInfo info = new ResultInfo();
        info.setFlag(false);
        Boolean login;
        login = userService.login(id, password);
        if (login){
            User user = userService.findById(id);
            User retUser = new User(user.getId(),user.getRole());
            session.setAttribute("onlineUser",retUser);
            info.setFlag(true);
            info.setData(retUser);
            String access_token = JwtUtil.createToken(id,user.getRole());
            System.out.println(access_token);
            res.setHeader("Authorization",access_token);
        }
        return info;
    }

    @RequestMapping("/logout")
    public @ResponseBody void logout(HttpSession session){
        session.invalidate();
        return;
    }

    @RequestMapping("/find")
    public @ResponseBody User find(String uid){
       return userService.findById(uid);
    }

    @RequestMapping("/proportion")
    public @ResponseBody ResultInfo proportion(){
        ResultInfo info = new ResultInfo();
        Map<String, Double> proportion = userService.countPersonProportion();
        info.setFlag(true);
        info.setData(proportion);
        return info;
    }
}
