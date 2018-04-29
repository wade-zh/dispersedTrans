package com.hongwei.demo.controller;


import com.hongwei.demo.model.PayCryticCodes;
import com.hongwei.demo.model.PayResMsg;
import com.hongwei.demo.model.User;
import com.hongwei.demo.service.IPayService;
import com.hongwei.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * 业务控制器
 * 通过模拟转账业务场景，故意引发事务问题，假设当前处于SOA系统中，想办法解决这个问题
 */
@RestController
@RequestMapping("/biz")
public class BizController {
    @Autowired
    private IPayService payService;
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/transfer/{id}/{tid}/{money}")
    public PayResMsg transfer(@PathVariable Integer id,
                              @PathVariable Integer tid,
                              @PathVariable Double money) {
        boolean transfer = false;
        try {
            transfer = payService.transfer(id, tid, money);
        }catch (Exception e){
            if(!(e instanceof RuntimeException)) e.printStackTrace();
            return new PayResMsg(PayCryticCodes.valueOf(e.getMessage()), "This is a unsuccessful operation, sorry.");
        }
        if (!transfer) return new PayResMsg(PayCryticCodes.E0002, "This is a unsuccessful operation, sorry.");
        return new PayResMsg(PayCryticCodes.E0000, "Successful");
    }

    @GetMapping(value = "/query/{id}")
    public User query(@PathVariable Integer id) {
        return userService.getUser(id);
    }
}
