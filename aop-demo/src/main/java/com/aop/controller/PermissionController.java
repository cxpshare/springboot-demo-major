package com.aop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aop.annotation.PermissionAnnotation;
import com.aop.result.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 */

@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @PermissionAnnotation()
    public Result getGroupList(@RequestBody JSONObject request) {
        return new Result();
    }
}
