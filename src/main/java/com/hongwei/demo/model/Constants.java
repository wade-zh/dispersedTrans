package com.hongwei.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    private static Map<Integer, User> users;

    public static Map<Integer, User> getUsers() {
        if(users == null) users = new HashMap<>();
        if(users.size() == 0) {
            users.put(10001, new User("Sarah", 1000D));
            users.put(10002, new User("Zip", 1000D));
        }
        return users;
    }

    public static void setUsers(Map<Integer, User> users){
        users = users;
    }

}
