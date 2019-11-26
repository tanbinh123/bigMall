package com.mall.cloud.service;

import com.mall.cloud.domain.User;
public interface UserService {
    void create(User user);

    User getUser(Long id);
}
