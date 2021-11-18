package com.heqing.seata1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heqing.seata1.mapper.TestUserMapper;
import com.heqing.seata1.model.po.TestUserPO;
import com.heqing.seata1.service.ITestUserService;
import com.heqing.seata1.util.HttpGetUtil;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
@Service("testUserService")
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUserPO> implements ITestUserService {

    private static Logger log = LoggerFactory.getLogger(TestUserServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @GlobalTransactional(name="study-seata")
    @Override
    public void seata(int id) {

        TestUserPO po = new TestUserPO();
        po.setName("testuser");
        save(po);

        // nacos 调用远程服务
        restTemplate.getForObject("http://study-seata-client2/person/cerate/"+id, String.class);

        // 注意：使用这种调用发时将不起作用。seata配置使用的nacos
//        HttpGetUtil.sendRequest("http://localhost:8002/person/cerate/"+id);
    }
}
