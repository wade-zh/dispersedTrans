package com.hongwei.demo.dao.impl;

import com.hongwei.demo.dao.IPayDao;
import com.hongwei.demo.model.PayCryticCodes;
import com.hongwei.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class PayDao implements IPayDao {
    @Override
    public boolean addMoney(User user, Double money) {
        user.setBalance(user.getBalance() + money);
        boolean result = Math.random() < 0.45;
        if (result) throw new RuntimeException(PayCryticCodes.E0004.toString());
        return false;
    }

    @Override
    public boolean reduceMoney(User user, Double money) {
        user.setBalance(user.getBalance() - money);
        boolean result = Math.random() < 0.45;
        if (result) throw new RuntimeException(PayCryticCodes.E0004.toString());
        return false;
    }
}
