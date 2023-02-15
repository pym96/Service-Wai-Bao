package com.test;

import com.springMVCLearn.mapper.UserMapper;
import com.springMVCLearn.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author DJS
 * Date create 0:40 2023/2/8
 * Modified By DJS
 **/
public class testMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取sqlSession对象
        // 可以设置自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("zhangsan");
        user.setPsd("1234");
        final List<User> users = mapper.selectAllByCondition(user);
        System.out.println(users);
        final List<User> users1 = mapper.selectAllByCondition("zhangsan", "123");
        System.out.println(users1);
    }
}
