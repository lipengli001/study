package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User get (String id) {
        return userMapper.get(id);
    }

}
