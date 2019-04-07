package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.model.User;
import edu.wbu.dorm.service.UserService;
import edu.wbu.dorm.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
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
            User retUser = new User(user.getId(),user.getRole(),user.getPermission());
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

    @RequestMapping("/distribution")
    public @ResponseBody ResultInfo distribution(String uid){
        ResultInfo info = new ResultInfo(false);
        Boolean b = userService.isAdmin(uid);
        Map<String, Integer> m = null;
        if (b){
            m = userService.distributionOfDorm();
            //当宿舍不够时m中的值至少有一个不为0
            if (m.get("maleStu")==0&&m.get("femaleStu")==0&&m.get("maleSta")==0&&m.get("femaleSta")==0){
                info.setFlag(true);
            }
        }
        info.setData(m);
        return info;
    }

    @RequestMapping("/img")
    public @ResponseBody ResultInfo changeImg(String uid, MultipartFile newHeadImg, HttpServletRequest req){
        ResultInfo info = new ResultInfo(false);
        if (newHeadImg==null)
            return info;
        ServletContext sc = req.getServletContext();
        String path = sc.getRealPath("image\\headpic");
        String url = userService.changeImg(uid,path,newHeadImg);
        if (url==null)
            return info;
        info.setFlag(true);
        info.setData(url);
        return info;
    }

    @RequestMapping("/count")
    public @ResponseBody ResultInfo count(String uid){
        ResultInfo info = new ResultInfo(false);
        Boolean b = userService.isAdmin(uid);
        if (b){
            Map<String, Integer> count = userService.count();
            info.setData(count);
            info.setFlag(true);
        }
        return info;
    }

    @RequestMapping("/queryDetail")
    public @ResponseBody ResultInfo queryDetail(String uid,String behaviorId){
        ResultInfo info = new ResultInfo(false);
        int behavior = 0;
        if (behaviorId!=null&&!behaviorId.equals("")){
            behavior = Integer.parseInt(behaviorId);
        }else
            return info;
        Boolean b = userService.isAdmin(uid);
        List<User> list = null;
        if (b){
            list = userService.findNoDistributionPerson(behavior);
            info.setFlag(true);
            info.setData(list);
        }
        return info;
    }
}
