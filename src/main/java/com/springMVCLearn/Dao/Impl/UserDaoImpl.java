package com.springMVCLearn.Dao.Impl;

import com.springMVCLearn.Dao.UserDao;
import com.springMVCLearn.mapper.UserMapper;
import com.springMVCLearn.pojo.User;
import com.springMVCLearn.utils.MapperUtils;

import java.util.List;

/**
 * @author DJS
 * Date create 0:39 2023/2/8
 * Modified By DJS
 **/
public class UserDaoImpl implements UserDao {

    UserMapper userMapper;

    public UserDaoImpl() {
        userMapper = (UserMapper) MapperUtils.getMapper(UserMapper.class);
    }

    @Override
    public List<User> selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
