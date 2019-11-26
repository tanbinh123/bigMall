package com.mall.cloud.service.impl;

import com.mall.cloud.domain.User;
import com.mall.cloud.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService {
    private List<User> list = new ArrayList<>();
    @Override
    public void create(User user) {
        list.add(user);
    }

    @Override
    public User getUser(Long id) {
        List<User> orderList =  list.stream().filter(userItem -> userItem.getId().equals(id)).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(orderList)){
            return orderList.get(0);
        }
        return null;
    }

    @PostConstruct
    private void init(){
        list.add(new User(1L,"hua","123"));
        list.add(new User(2L,"xu","345"));
    }

}
