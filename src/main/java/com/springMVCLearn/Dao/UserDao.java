package com.springMVCLearn.Dao;

import com.springMVCLearn.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> selectUserByUsername(String username);
}
