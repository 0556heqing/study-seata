package com.heqing.seata2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heqing.seata2.model.po.PersonPO;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author heqing
 * @since 2021-07-28
 */
public interface IPersonService extends IService<PersonPO> {

    void seata(int id);
}
