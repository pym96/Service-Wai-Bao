package com.springMVCLearn.service.impl;

import com.springMVCLearn.Dao.UserDao;
import com.springMVCLearn.pojo.User;
import com.springMVCLearn.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DJS
 * Date create 14:06 2023/2/7
 * Modified By DJS
 **/

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> selectUserByUserName(String username) {
        return userDao.selectUserByUsername(username);
    }
}
