package com.chen.weixin.controller;

import com.chen.weixin.util.AuthUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 微信授权登录控制器
 * <p>
 * @Author LeifChen
 * @Date 2018-12-26
 */
@Controller
@RequestMapping("/wx")
public class LoginController {

    @GetMapping("/login")
    public String login() throws UnsupportedEncodingException {
        String backUrl = "http://leifchen.51vip.biz/WxAuth/wx/callBack";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect"
                .replace("APPID", AuthUtils.APPID)
                .replace("REDIRECT_URI", URLEncoder.encode(backUrl, "UTF-8"))
                .replace("SCOPE", "snsapi_userinfo");
        return "redirect:" + url;
    }
}
