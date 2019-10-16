package com.qklt.mnbsb.controller;

import com.qklt.mnbsb.domain.LoginData;
import com.qklt.mnbsb.domain.User;
import com.qklt.mnbsb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService ls) {
        this.loginService = ls;
    }

    @PostMapping(value = "/user/login")
    public String checkAccount(@Validated LoginData ld, BindingResult br,
                               RedirectAttributes attr,
                               HttpSession httpSession) {

        if(br.hasErrors()) {
            attr.addFlashAttribute("msg",
                    br.getFieldError().getDefaultMessage());
            return "redirect:/html/login";
        }

        User user = loginService.checkAccount(ld);
        if(user != null) {
            httpSession.setAttribute("user", user);
            return "redirect:/html/home";
        } else {
            attr.addFlashAttribute("msg", "用户名或密码错误");
            return "redirect:/html/login";
        }
        
    }

}
