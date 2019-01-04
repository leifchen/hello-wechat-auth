# hello-wechat-auth

通过微信提供的接口[网页服务--网页授权--网页授权获取用户基本信息](https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842)
，实现微信的授权登录。

## 1. 介绍

本项目基于 Spring Boot + Thymeleaf ，依赖包通过 Gradle 进行统一管理。

## 2. 调试

### 2.1 微信Web开发助手

到[官网](https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455784140)下载工具，直接使用 localhost 进行调试，与普通的 PC 调试无区别。

### 2.2 手机微信端

需要内网穿透技术，即映射内网端口到公网，可以使用 ngrok 或花生壳。

## 参考

1. [微信授权登录](https://www.imooc.com/learn/713)
