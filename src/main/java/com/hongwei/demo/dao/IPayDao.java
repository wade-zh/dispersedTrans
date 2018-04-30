package com.hongwei.demo.dao;

import com.hongwei.demo.model.User;

public interface IPayDao {
    boolean addMoney(User user, Double money);
    boolean reduceMoney(User user, Double money);
}
