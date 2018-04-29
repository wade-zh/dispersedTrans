package com.hongwei.demo.service;

public interface IPayService {
    boolean transfer(Integer id, Integer targetId, Double money);
}
