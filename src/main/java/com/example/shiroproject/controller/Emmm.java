package com.example.shiroproject.controller;

import com.example.shiroproject.Re.Result;
import com.example.shiroproject.Re.ResultGenerator;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/emmm")
public class Emmm {
    @RequestMapping("/emmm")
    public Result index(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(401);
//        Cookie cookie= new Cookie("JSESSOPMOD",httpServletRequest.getSession().getId());
//        cookie.setSecure(true);
//        httpServletResponse.addCookie(cookie);
//        httpServletResponse.setHeader("Set-Cookie","JSESSIONID="+httpServletRequest.getSession().getId());
        httpServletResponse.setHeader("WWW-Authenticate","Basic realm='localhost:8080/doLogin'");
        return ResultGenerator.genFailResult("");
    }
}
