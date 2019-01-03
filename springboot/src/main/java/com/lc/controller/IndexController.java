package com.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: CoderTnT
 * @date: 2018/8/29
 */
@Controller
public class IndexController
{
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
