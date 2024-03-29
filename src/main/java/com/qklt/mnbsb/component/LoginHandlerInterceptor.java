package com.qklt.mnbsb.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if(user == null) {
            request.setAttribute("msg", "您尚未登录，请先登录");
            request.getRequestDispatcher("/html/login")
                    .forward(request, response);
            return false;
        } else {
            return true;
        }

    }
}
