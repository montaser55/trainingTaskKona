package com.example.demo.dao;

import com.example.demo.entity.User;

public class UserDao {

    public String createQueryForAllUser() {
        String str = "select u from User u";
        return str;
    }

    public String createQueryForIdUser(int id) {
        String str = "select u from User u where u.id=:id";
        return str;
    }


    public String createQueryForDeleteUser(int id) {
        String str = "DELETE from User u where u.id=:id";
        return str;
    }
}
