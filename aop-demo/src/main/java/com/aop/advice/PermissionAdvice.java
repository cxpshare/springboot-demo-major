package com.aop.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 一个切面类
 */

// 声明这是一个切面类
@Aspect
// 声明该类交由spring管理
@Component
// 控制切面类的执行顺序 值越小，切面类越先执行
@Order(1)
public class PermissionAdvice {
    // 定义一个切面
    @Pointcut("@annotation(com.aop.annotation.PermissionAnnotation)")
    private void permissionCheck() {
    }

    // 环绕通知
    @Around("permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===================第一个切面===================：" + System.currentTimeMillis());

        //获取请求参数，详见接口类
        Object[] objects = joinPoint.getArgs();
        // 获取入参中的id
        Long id = ((JSONObject) objects[0]).getLong("id");
        // 获取入参中的name
        String name = ((JSONObject) objects[0]).getString("name");
        System.out.println("id1->>>>>>>>>>>>>>>>>>>>>>" + id);
        System.out.println("name1->>>>>>>>>>>>>>>>>>>>>>" + name);

        // id小于0则抛出非法id的异常
        if (id < 0) {
            return JSON.parseObject("{\"message\":\"非法 id\",\"code\":403}");
        }
        return joinPoint.proceed();
    }
}
