package com.example.shiroproject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.shiroproject.Dao")
@ComponentScan
public class ShiroProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroProjectApplication.class, args);
//        String cmd = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://localhost:8080/fuzf";
//        Runtime run = Runtime.getRuntime();
//        try{
//            run.exec(cmd);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
