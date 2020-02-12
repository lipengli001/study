package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping ("/get/{id}")
    User savePageInfo (@PathVariable("id") String id) {
        return userService.get(id);
    }

    public static void main (String[] args) {
        //倒计数锁存器
        CountDownLatch cdl = new CountDownLatch(20);
        cdl.countDown();
    }

}
