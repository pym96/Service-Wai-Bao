package com.springMVCLearn.service;

import com.springMVCLearn.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectUserByUserName(String username);
}
