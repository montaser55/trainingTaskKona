package com.example.demo.dao;

import com.example.demo.entity.User;

public class UserDao {

    public String createQueryForAllUser() {
        String str = "select * from User u";
        return str;
    }

    public String createQueryForIdUser(int id) {
        String str = "select * from user where id=?1";
        return str;
    }


    public String createQueryForDeleteUser(int id) {
        String str = "DELETE from user where id=?1";
        return str;
    }
}
