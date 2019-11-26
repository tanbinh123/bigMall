package com.mall.cloud.controller;

import com.mall.cloud.domain.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @RequestMapping("/{id}")
    public CommonResult getUser(@PathVariable String id){
        return restTemplate.getForObject(userServiceUrl+"/user/{1}",CommonResult.class,id);
    }
}
