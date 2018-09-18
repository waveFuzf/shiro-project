package com.example.shiroproject.controller;


import com.example.shiroproject.Dao.GradeMapper;
import com.example.shiroproject.Dao.UserMapper;
import com.example.shiroproject.Entity.Grade;
import com.example.shiroproject.Entity.User;
import com.example.shiroproject.Util.ResponseUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private GradeMapper gm;
    @Autowired
    private UserMapper um;
    @Autowired
    private ResponseUtil util;
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

//
//    @GetMapping("/myuser")
//    public String finduserbygrade() {
//
//        if (redisTemplate.opsForHash().get("user", "name").equals("fuzf")) {
//            return "******" + redisTemplate.opsForHash().entries("user");
//        }else {
//            User newu=um.selectByName("fuzf");
//            Map map=A.objectToMap(newu);
////            map.forEach((k,v)->System.out.println("Key:" + k + "|Value:" + v));
//            redisTemplate.opsForHash().putAll("user",map);
//            System.out.println(newu);
//            return  "******" + redisTemplate.opsForHash().entries("user");
//        }
//    }
    @GetMapping("getAll")
    public List<User> getAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
      Example e=new Example(User.class);
      e.createCriteria().getAllCriteria();
      List<User> user=um.selectByExample(e);
      System.out.println(httpServletRequest.getSession().getId());
      util.setHeader(httpServletRequest,httpServletResponse);
      return user;
}
    @PostMapping("select")
    public List<User> select(@Param("name")String name,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        Example e=new Example(User.class);
        e.createCriteria().andEqualTo("name",name);
        List<User> user=um.selectByExample(e);
        util.setHeader(httpServletRequest,httpServletResponse);
        return user;
    }

    @GetMapping("mady")
    public JSONArray Mady(){
        Example e=new Example(User.class);
        e.createCriteria().andEqualTo("id","1");
        List<User> user=um.selectByExample(e);
        return JSONArray.fromObject(user);
    }
    @GetMapping("madd")
    public List<User> Madd(){
        Example e=new Example(User.class);
        e.createCriteria().andEqualTo("id","1");
        List<User> user=um.selectByExample(e);
        return user;
    }
    @PostMapping("mady")
    public String Mady2(){
        Example e=new Example(User.class);
        e.createCriteria().andEqualTo("id","1");
        List<User> l=um.selectByExample(e);
        return l.get(0).getName();
    }
    @GetMapping("fuzf")
    public List<User> fuzf(){
        List<User> u=um.getEmmm();
        return u;
    }

    @GetMapping("fuzf2")
    public List<Grade> fuzf2(){
        List<Grade> g=gm.selecttttt(1);
       System.out.println(g.toString());
        return g;
    }
    @GetMapping("lisp")
    public String wuwuwu(){
        User uu=new User("lisp","Jiangsu","19990201");
        um.insert(uu);

        return "lisp";
    }

    @GetMapping("/itemsPage")
    public List<User> itemsPage(int page,int size){
        Page<User> pageInfo = PageHelper.startPage(page, size);
        List<User> users = um.findAll();
        return pageInfo;
        }
//    @PostMapping("/save")
//    public User saveu(){
//        User newu=um.selectByName("mady");
//        Map map=A.objectToMap(newu);
////            map.forEach((k,v)->System.out.println("Key:" + k + "|Value:" + v));
//        redisTemplate.opsForHash().putAll("user",map);
//        return newu;
//    }
//    @GetMapping("/save")
//    public User saveuu(){
//        User newu=um.selectByName("mady");
//        Map map=A.objectToMap(newu);
////            map.forEach((k,v)->System.out.println("Key:" + k + "|Value:" + v));
//        redisTemplate.opsForHash().putAll("user",map);
//        return newu;
//    }
}
