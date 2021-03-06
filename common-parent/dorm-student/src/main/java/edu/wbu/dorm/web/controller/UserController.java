package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.common.annotation.PermissionCheck;
import edu.wbu.dorm.common.utils.JwtUtil;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.model.User;
import edu.wbu.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
            //session.setAttribute("onlineUser",retUser);
            info.setFlag(true);
            info.setData(retUser);
            String access_token = JwtUtil.createToken(id,user.getRole(),user.getPermission());
            res.setHeader("Authorization",access_token);
        }
        return info;
    }

    @RequestMapping("/find")
    public @ResponseBody User find(String uid){
       return userService.findById(uid);
    }

    @RequestMapping("/proportion")
    public @ResponseBody ResultInfo proportion(){
        ResultInfo info = new ResultInfo();
        Map<String, Integer> proportion = userService.countPersonProportion();
        info.setFlag(true);
        info.setData(proportion);
        return info;
    }

    @PermissionCheck
    @RequestMapping("/distribution")
    public @ResponseBody ResultInfo distribution(String uid){
        ResultInfo info = new ResultInfo(false);
        Boolean b = userService.isAdmin(uid);
        Map<String, Integer> m = null;
        if (b){
            m = userService.distributionOfDorm();
            //??????????????????m??????????????????????????????0
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
        String path = sc.getRealPath("image/headpic");
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

    @RequestMapping(value = "/uploadExcel",method = RequestMethod.POST)
    public @ResponseBody ResultInfo uploadExcel(String uid,MultipartFile excelFile){
        ResultInfo info = new ResultInfo(false);
        Boolean b = userService.isAdmin(uid);
        if (b){
            Boolean a = userService.uploadExcel(excelFile);
            System.out.println(a);
            info.setFlag(a);
        }
        return info;
    }
}
