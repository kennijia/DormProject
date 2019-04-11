package edu.wbu.dorm.web.controller;

import edu.wbu.dorm.model.ExcellentDorm;
import edu.wbu.dorm.model.ResultInfo;
import edu.wbu.dorm.service.DormService;
import edu.wbu.dorm.service.ExcellentDormService;
import edu.wbu.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/eDorm")
public class ExcellentDormController {
    @Autowired
    private ExcellentDormService eDormService;
    @Autowired
    private UserService userService;
    @Autowired
    private DormService dormService;

    @RequestMapping("/findAll")
    public @ResponseBody List<ExcellentDorm> findAll(){
        return eDormService.findAll();
    }

    @RequestMapping("/add")
    public @ResponseBody ResultInfo add(String uid, int edId, int ed_dormId, List<MultipartFile> ed_imgs, MultipartFile ed_introduce, HttpServletRequest req){
        ResultInfo info = new ResultInfo(false);
        Boolean b = userService.isAdmin(uid);
        int i ;
        if (ed_imgs.size()!=3||ed_introduce.getOriginalFilename().lastIndexOf("txt")>0)
            return info;
        if (b){
            String savePath = req.getServletContext().getRealPath("image/excellentDormImg");
            i = eDormService.ed(edId,ed_dormId,ed_imgs,ed_introduce,savePath);
            if (i>0)
                info.setFlag(true);
        }
        return info;
    }
}
