package edu.wbu.dorm.web.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wbu.dorm.common.annotation.PermissionCheck;
import edu.wbu.dorm.common.utils.JwtUtil;
import edu.wbu.dorm.model.ResultInfo;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        //1.控制器方法执行前执行
        //System.out.println("preHandle");
        StringBuffer reqURL = req.getRequestURL();
        req.setCharacterEncoding("utf-8");
        if (reqURL.indexOf("login.do")>=0||reqURL.indexOf("proportion.do")>=0||reqURL.indexOf("findSix.do")>=0||reqURL.indexOf("eDorm/findAll.do")>0||reqURL.indexOf("dorm/findOne.do")>0)
            return true;//这些请求无需验证，放行
        String access_token = req.getHeader("Authorization");
        ResultInfo info = new ResultInfo(false);
        ObjectMapper obj = new ObjectMapper();
        String resJson = obj.writeValueAsString(info);
        res.setContentType("application/json;charset=utf-8");
        if (access_token!=null&&!access_token.equals("")){
            Map<String, Claim> tokenMap = null;
            try {
                tokenMap = JwtUtil.verifyToken(access_token);
            } catch (Exception e) {
                //jwt解析出错，拒绝请求
                res.getWriter().write(resJson);
                return false;
            }
            String uid = tokenMap.get("uid").asString();
            int role = tokenMap.get("role").asInt();
            int permission = tokenMap.get("permission").asInt();
            Date exp = tokenMap.get("exp").asDate();
            long now = System.currentTimeMillis();
            long exp1 = exp.getTime();
            if (exp1<now){
                res.getWriter().write(resJson);
                return false;//到了过期时间
            }
            HandlerMethod method = (HandlerMethod)handler;
            //String className = method.getBeanType().getName();获取本次请求的controller的全类名
            PermissionCheck annotation = method.getMethod().getAnnotation(PermissionCheck.class);
            if (annotation!=null){
                int p = annotation.permission();
                if (permission!=p){
                    res.getWriter().write(resJson);
                    return false;
                }
            }
            return true;
        }else{
            System.out.println("Authorization为空，验证不通过。");
            res.getWriter().write(resJson);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //2.控制器方法执行后，视图渲染前执行
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //3.返回视图后执行，主要进行资源清理工作
    }
}
