package com.woyou.controller;

import com.woyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",produces="application/json")
    public User  user(HttpServletRequest request){
        if(null == request.getAttribute("name")){
            System.out.println(" request is null ");
            request.setAttribute("name","shishishi request");
        }
        if(null == request.getSession().getAttribute("name")){
            System.out.println(" session is null ");
            request.getSession().setAttribute("name","shishishi session");
        }
        User user = new User("tao",20);
        return user;
    }

    class User{
        String name ;
        int age ;
        User(String name , int age){
            this.name= name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
