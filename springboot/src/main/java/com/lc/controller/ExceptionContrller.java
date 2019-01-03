package com.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by CoderTnT on 2018/8/24.
 */
@Controller
public class ExceptionContrller
{
    @GetMapping(value = {"/testErrorCode"})
    public String testErrorCode(){
        int i=1/0;
        return "index";
    }
}
