package com.example.demo.dao;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface UserMapper {

    User get (String id);

}
