package com.mall.cloud.controller;

import com.mall.cloud.domain.CommonResult;
import com.mall.cloud.domain.User;
import com.mall.cloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public CommonResult create(@RequestBody User user){
        log.info("/user/create");
        userService.create(user);
        return new CommonResult("操作成功",200);
    }

    @GetMapping("/{id}")
    private CommonResult getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        log.info("根据用户id获取用户信息结果为："+user);
        return new  CommonResult<>(user);
    }
}
