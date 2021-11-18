package com.heqing.seata2;

import com.heqing.seata2.model.po.PersonPO;
import com.heqing.seata2.service.IPersonService;
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
    private IPersonService personService;

    @Test
    public void testPersonCreate() {
        PersonPO po = new PersonPO();
        po.setName("client2");
        po.setBirthday(new Date());
        boolean result = personService.save(po);
        System.out.println("--> " + result);
    }

}
