package edu.wbu.dorm.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        //1.控制器方法执行前执行
        System.out.println("preHandle");
        StringBuffer reqURL = req.getRequestURL();
        System.out.println(req.getHeader("Authorization"));
        if (reqURL.indexOf("login.do")>0||reqURL.indexOf("proportion.do")>0)
            return true;//请求登录，放行
        HttpSession session = req.getSession();
        if (session.getAttribute("onlineUser")!=null)
            return true;//已登录，放行
        return false;
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
