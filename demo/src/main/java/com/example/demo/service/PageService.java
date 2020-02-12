package com.example.demo.service;

import com.example.demo.bean.Page;
import com.example.demo.dao.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class PageService {

    @Autowired
    private PageMapper pageMapper;

    public Page savePageInfo (Page page) {
        pageMapper.insert(page);
        return page;
    }

    public Page editPageInfo (Page page) {
        pageMapper.update(page);
        return page;
    }

    public void delPageInfoById (String id) {
        pageMapper.deleteById(id);
    }

    public Page getPageInfoById (String id) {
        return pageMapper.getById(id);
    }

}
