package com.aop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aop.annotation.PermissionAnnotation;
import com.aop.result.Result;
import com.aop.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 服务实现
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    // todo 用这个注解修饰的方法（也可以修饰类），将被PermissionAdvice切入处理
    @PermissionAnnotation()
    @Override
    public Result getGroupList(@RequestBody JSONObject request) {
        System.out.println("原始请求信息：" + request);
        return new Result();
    }
}
