package com.aop.service;

import com.alibaba.fastjson.JSONObject;
import com.aop.result.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 服务接口
 */
@Service
public interface PermissionService {
    Result getGroupList(@RequestBody JSONObject request);
}
