package com.team.finance.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Avenger
 * @describe: TODO
 * @create: 2017年12月20日 16:29
 **/
@Controller
@RequestMapping("/register")
public class registerController {
    @RequestMapping("/register")
    public String register(){

        return "/login/register";
    }
}
