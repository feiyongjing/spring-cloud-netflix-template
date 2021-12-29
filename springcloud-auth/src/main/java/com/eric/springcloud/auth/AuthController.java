package com.eric.springcloud.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {
    @GetMapping("/auth")
    @ResponseBody
    public String senderMessage() {
        System.out.println("认证成功");
        return "认证成功";
    }
}
