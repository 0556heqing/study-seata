package com.heqing.seata1;

import com.heqing.seata1.model.po.TestUserPO;
import com.heqing.seata1.service.ITestUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author heqing
 * @date 2021/7/20 19:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private ITestUserService testUserService;

    @Test
    public void testPersonCreate() {
        TestUserPO po = new TestUserPO();
        po.setName("client1");
        po.setBirthday(new Date());
        boolean result = testUserService.save(po);
        System.out.println("--> " + result);
    }

}
