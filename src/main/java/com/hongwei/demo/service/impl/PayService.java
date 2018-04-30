package com.hongwei.demo.service.impl;

import com.hongwei.demo.dao.IPayDao;
import com.hongwei.demo.model.Constants;
import com.hongwei.demo.model.PayCryticCodes;
import com.hongwei.demo.model.User;
import com.hongwei.demo.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PayService implements IPayService {

    private final IPayDao payDao;

    @Autowired
    public PayService(IPayDao payDao) {
        this.payDao = payDao;
    }

    @Override
    public boolean transfer(Integer id, Integer targetId, Double money) {
        Map<Integer, User> users = Constants.getUsers();

        User user = users.get(id);
        User targetUser = users.get(targetId);
        User nUser = new User(user.getName(), user.getBalance());
        User nTargetUser = new User(user.getName(), user.getBalance());

        if(user.getBalance() <= 0 || money > user.getBalance()) throw new RuntimeException(PayCryticCodes.E0003.toString());


        try {
            payDao.reduceMoney(nUser,money);
            payDao.addMoney(nTargetUser,money);
            // commit
            users.put(id, nUser);
            users.put(targetId, nTargetUser);
            Constants.setUsers(users);
            return true;
        } catch (Exception e) {
            // rollback
            users.put(id, user);
            users.put(targetId, targetUser);
            throw e;
        }
    }

}
