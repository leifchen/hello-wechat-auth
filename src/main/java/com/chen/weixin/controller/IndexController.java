package com.chen.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * <p>
 * @Author LeifChen
 * @Date 2018-12-26
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(){
        return "index";
    }
}
