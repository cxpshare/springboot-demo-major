package com.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 * @Aspect 声明切面
 * @Component 该类交由spring管理
 *
 * 结论：
 *  1.@Before注解下的方法会在切点处方法执行前运行
 *  2.@After注解下的方法会在切点处方法执行后运行
 *  3.@Around注解，切点前比@Before早执行，切点后比@After晚执行
 */
@Aspect
@Component
public class LogAdvice {
    // 定义一个切点：所有被GetMapping注解修饰的方法会织入advice
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointcut(){

    }
    // Before表示logAdvice将在目标方法执行前执行
    @Before("logAdvicePointcut()")
    public void logBefore(){
        // 这里只是一个示例，你可以写任何处理逻辑
        System.out.println("get请求之前，advice触发了");
    }

    // After表示logAdvice将在目标方法执行后执行
    @After("logAdvicePointcut()")
    public void logAfter(){
        // 这里只是一个示例，你可以写任何处理逻辑
        System.out.println("get请求之后，advice触发了");
    }

    //环绕通知，在方法执行前有提示，在方法执行后有提示
    @Around("logAdvicePointcut()")
    public Object logAround(ProceedingJoinPoint point) throws Throwable{
        System.out.println("在get方法执行之前，around执行了");
        Object obj = point.proceed();
        System.out.println("在get方法执行之后，around执行了");
        return obj;
    }
}
