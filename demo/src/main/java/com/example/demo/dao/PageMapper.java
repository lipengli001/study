package com.example.demo.dao;

import com.example.demo.bean.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper {

    int insert (Page page);

    int update (Page page);

    int deleteById (String id);

    Page getById (String id);

}
