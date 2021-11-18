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

    /**
     * 测试分布式事务
     * @param id
     * 注意 ：在需要进行分布式事务时一定要加上 @GlobalTransactional，否则事务无效
     * 参考资料：https://zhuanlan.zhihu.com/p/103120151
     */
    @GlobalTransactional
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
