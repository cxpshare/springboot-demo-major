package com.aop.result;

import lombok.Data;

/**
 * 返回对象
 */
@Data
public class Result{
    // 状态码
    public int code = 200;
    // 信息
    public String message = "成功";
}
