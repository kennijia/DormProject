package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.Announcement;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.model.WangEditorImg;
import edu.wbu.dorm.service.AnnouncementService;
import edu.wbu.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/anou")
public class AnnouncementController {
    @Autowired
    private AnnouncementService anouService;
    @Autowired
    private UserService userService;

    @RequestMapping("/findSix")
    public @ResponseBody
    ResultInfo findTopSix() {
        ResultInfo info = new ResultInfo();
        info.setData(anouService.findTopSixByTime());
        info.setFlag(true);
        return info;
    }

    @RequestMapping("/findOne")
    public @ResponseBody
    ResultInfo findOne(int anouId) {
        ResultInfo info = new ResultInfo();
        Announcement byId = anouService.findById(anouId);
        info.setFlag(true);
        info.setData(byId);
        return info;
    }

    @RequestMapping("/delete")
    public @ResponseBody
    ResultInfo delete(int anouId, String uid, int role) {
        ResultInfo info = new ResultInfo(false);
        Boolean b = userService.isAdmin(uid);
        if (b){
            int i = anouService.deleteOne(anouId, uid, role);
            if (i > 0)
                info.setFlag(true);
        }
        return info;
    }

    @RequestMapping("/update")
    public @ResponseBody
    ResultInfo update(int anouId, String anouTitle, String anouContent, String uid, int role) {
        ResultInfo info = new ResultInfo(false);
        Boolean b = userService.isAdmin(uid);
        if (b){
            int i = anouService.updateOne(anouId, anouTitle, anouContent, uid, role);
            if (i > 0)
                info.setFlag(true);
        }
        return info;
    }

    @RequestMapping("/imgUpload")
    public @ResponseBody WangEditorImg imgUpload(List<MultipartFile> anouImg, HttpServletRequest req) {
        String imgUploadPath = req.getServletContext().getRealPath("/uploadImg");
        String[] data = anouService.imgUpload(anouImg, imgUploadPath);
        WangEditorImg wei = new WangEditorImg(0, data);
        for (String s:data){
            System.out.println(s);
        }
        if (data == null) {
            wei.setErrno(1);
        }
        return wei;
    }

    @RequestMapping("/publish")
    public @ResponseBody ResultInfo  publish(HttpServletRequest req,String uid,String title,String html) {
        Boolean b = userService.isAdmin(uid);
        ResultInfo info = new ResultInfo(false);
        if (b){
            ServletContext sc = req.getServletContext();
            String anouPath = sc.getRealPath("anou");
            String anouModelPath = sc.getRealPath("anouModelHtml/htmlModel.html");
            Boolean flag = anouService.publish(uid,title,html,anouPath,anouModelPath);
            info.setFlag(flag);
        }
        return info;
    }
}
