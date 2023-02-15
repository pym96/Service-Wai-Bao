package com.springMVCLearn.mapper;

import com.springMVCLearn.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectAllByCondition(User user);
    List<User> selectAllByCondition(@Param("username") String username,
                                    @Param("password") String password);
    List<User> selectUserByUsername(@Param("username") String username);
}
