package com.heqing.seata1.controller;

import com.heqing.seata1.service.ITestUserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
@RestController
@RequestMapping("/study")
public class TestUserController {

    private static Logger log = LoggerFactory.getLogger(TestUserController.class);

    @Autowired
    private ITestUserService testUserService;

    @GlobalTransactional
    @GetMapping("seata/{id}")
    public String seata(@PathVariable("id") int id) {
        testUserService.seata(id);
        return  "hello seata";
    }
}

