package com.hongwei.demo.service.impl;

import com.hongwei.demo.model.Constants;
import com.hongwei.demo.model.PayCryticCodes;
import com.hongwei.demo.model.User;
import com.hongwei.demo.service.IPayService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PayService implements IPayService {
    @Override
    public boolean transfer(Integer id, Integer targetId, Double money) {
        Map<Integer, User> users = Constants.getUsers();

        User user = users.get(id);
        User targetUser = users.get(targetId);
        User nUser = null;
        User nTargetUser = null;

        if(user.getBalance() <= 0 || money > user.getBalance()) throw new RuntimeException(PayCryticCodes.E0003.toString());

        nUser = new User(user.getName(), user.getBalance() - money);
        nTargetUser = new User(targetUser.getName(), targetUser.getBalance() + money);

        users.put(id, nUser);
        users.put(targetId, nTargetUser);

        boolean result = Math.random() < 0.45;

        if(!result) {
            // rollback
            users.put(id, user);
            users.put(targetId, targetUser);
            return false;
        }

        // commit
        Constants.setUsers(users);
        return true;
    }

}
