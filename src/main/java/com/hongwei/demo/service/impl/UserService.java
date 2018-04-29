package com.hongwei.demo.service.impl;

import com.hongwei.demo.model.Constants;
import com.hongwei.demo.model.User;
import com.hongwei.demo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Override
    public User getUser(Integer id) {
        return Constants.getUsers().get(id);
    }
}
