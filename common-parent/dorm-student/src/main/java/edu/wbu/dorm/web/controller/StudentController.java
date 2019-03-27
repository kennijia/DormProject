package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.model.Student;
import edu.wbu.dorm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/login")
    public @ResponseBody ResultInfo login(String id, String password, HttpSession session){
        System.out.println("学生登录。。。。。。。。");
        ResultInfo info = new ResultInfo();
        Student s= studentService.login(id, password);
        if (s==null){
            info.setFlag(false);
            info.setErrorMsg("学号或密码输入错误.");
            return info;//前端接受false表示登录失败
        }else {
            System.out.println(s);
            s.setPassword("");
            session.setAttribute("user",s);
            info.setFlag(true);
            info.setData(s);
            return info;//前端接受true表示登录成功，在前端跳转至用户资料页面
        }
    }

    @RequestMapping("/find")
    public @ResponseBody Student find(HttpSession session){
        Student onlineUser = (Student) session.getAttribute("user");
        if (onlineUser==null){
            return null;
        }
        onlineUser = studentService.findById(onlineUser.getId());
        onlineUser.setPassword("");
        return onlineUser;
    }

    @RequestMapping("/logout")
    public @ResponseBody void logout(HttpSession session){
        //System.out.println(session.getId());
        Student onlineUser = (Student) session.getAttribute("user");
        //System.out.println(onlineUser);
        session.invalidate();
        return;
    }
}
