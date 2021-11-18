package com.heqing.seata2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heqing.seata2.mapper.PersonMapper;
import com.heqing.seata2.model.po.PersonPO;
import com.heqing.seata2.service.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author heqing
 * @since 2021-07-28
 */
@Service("personService")
public class PersonServiceImpl extends ServiceImpl<PersonMapper, PersonPO> implements IPersonService {

    private static Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Transactional
    @Override
    public void seata( int id) {

        PersonPO po = new PersonPO();
        po.setName("person");
        po.setBirthday(new Date());
        boolean result = save(po);

        if(id == 0) {
            throw new RuntimeException("不想成功") ;
        }
    }
}
