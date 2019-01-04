package com.chen.weixin.controller;

import com.alibaba.fastjson.JSONObject;
import com.chen.weixin.util.AuthUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * 微信授权登录的回调控制器
 * <p>
 * @Author LeifChen
 * @Date 2018-12-26
 */
@Controller
@RequestMapping("/wx")
public class CallBackController {

    @GetMapping("/callBack")
    public String callBack(@RequestParam("code") String code, ModelMap map) throws IOException {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code"
                .replace("APPID", AuthUtils.APPID)
                .replace("SECRET", AuthUtils.APPSECRET)
                .replace("CODE", code);
        JSONObject jsonObject = AuthUtils.doGetJson(url);
        String accessToken = jsonObject.getString("access_token");
        String openid = jsonObject.getString("openid");

        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                "access_token=" + accessToken +
                "&openid=" + openid +
                "&lang=zh_CN";
        JSONObject userInfo = AuthUtils.doGetJson(infoUrl);
        System.out.println(userInfo);

        // 1.使用微信用户信息直接绑定，无需注册绑定
        map.addAttribute("user", userInfo);
        return "login";
    }
}
