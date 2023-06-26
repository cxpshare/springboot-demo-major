package aop;

import com.alibaba.fastjson.JSONObject;
import com.aop.AopDemoApplication;
import com.aop.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AopDemoApplication.class)
public class AopTest {
    @Autowired
    private PermissionService permissionService;

    @Test
    public void PermissionTest() {
        // 构造入参
        JSONObject request = new JSONObject();
        request.put("id", 2);
        request.put("name", "hangman");
        System.out.println(permissionService.getGroupList(request));
    }
}
