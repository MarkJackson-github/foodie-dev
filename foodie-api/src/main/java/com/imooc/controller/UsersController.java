package com.imooc.controller;

import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private StuService stuService;

    @GetMapping("/getStu")
    public Object getStu(String id){
        return stuService.getUsers(id);
    }

    @GetMapping("/test")
    public Object test(){
        return "test ok";
    }
}
