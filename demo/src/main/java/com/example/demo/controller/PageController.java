package com.example.demo.controller;

import com.example.demo.bean.BaseResponse;
import com.example.demo.bean.Page;
import com.example.demo.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * 页面控制层
 */
@CrossOrigin (origins = "*")
@RestController
@RequestMapping ("/page")
public class PageController {

    @Autowired
    private PageService pageService;

    @PostMapping ("/savePageInfo")
    BaseResponse<Page> savePageInfo (@RequestBody Page page) {
        BaseResponse<Page> baseResponse = new BaseResponse<>(true);
        Page info = pageService.savePageInfo(page);
        baseResponse.setData(info);
        return baseResponse;
    }

    @PutMapping ("/editPageInfo")
    BaseResponse<Page> editPageInfo (@RequestBody Page page) {
        BaseResponse<Page> baseResponse = new BaseResponse<>(true);
        Page info = pageService.editPageInfo(page);
        baseResponse.setData(info);
        return baseResponse;
    }

    @DeleteMapping ("/delPageInfoById")
    BaseResponse<Void> delPageInfoById (@PathParam ("id") String id) {
        BaseResponse<Void> baseResponse = new BaseResponse<>(true);
        pageService.delPageInfoById(id);
        return baseResponse;
    }

    @GetMapping ("/getPageInfoById")
    BaseResponse<Page> getPageInfoById (@PathParam ("id") String id) {
        BaseResponse<Page> baseResponse = new BaseResponse<>(true);
        Page info = pageService.getPageInfoById(id);
        baseResponse.setData(info);
        return baseResponse;
    }

    public static void main (String[] args) {
        List<String> list = new ArrayList<>();
        synchronized (list) {
            list.add("abc");
        }
    }

}
