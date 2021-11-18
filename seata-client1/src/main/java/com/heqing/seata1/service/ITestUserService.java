package com.heqing.seata1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heqing.seata1.model.po.TestUserPO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
public interface ITestUserService extends IService<TestUserPO> {

    void seata(int id);
}
