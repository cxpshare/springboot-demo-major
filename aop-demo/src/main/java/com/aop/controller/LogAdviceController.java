package com.aop.controller;

import com.aop.result.Result;
import org.springframework.web.bind.annotation.*;

/**
 * 测试日志切面 前端控制器
 */

@RestController
@RequestMapping(value = "/aop/log")
public class LogAdviceController {

    @GetMapping(value = "/getTest")
    public Result getTest(){
        System.out.println("GET请求执行中");
        return new Result();
    }

    @PostMapping(value = "/postTest")
    public Result postTest(Object obj){
        System.out.println("POST请求执行中");
        return new Result();
    }

}
