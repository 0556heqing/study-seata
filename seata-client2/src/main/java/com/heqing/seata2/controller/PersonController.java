package com.heqing.seata2.controller;

import com.heqing.seata2.model.po.PersonPO;
import com.heqing.seata2.service.IPersonService;
import com.heqing.seata2.model.dto.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author heqing
 * @since 2021-07-28
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private static Logger log = LoggerFactory.getLogger(PersonController.class);

	@Autowired
    private IPersonService personService;

    /**
     * 获取全部数据
     */
    @RequestMapping("/all")
    @ResponseBody
    public ResponseInfo<?> findAll(){
        List<PersonPO> models = personService.list();
        return ResponseInfo.buildSuccess(models);
    }


    @GetMapping("cerate/{id}")
    public String cerate(@PathVariable("id") int id) {
        log.info("-----> cerate");
        personService.seata(id);
        return  "success";
    }
}

