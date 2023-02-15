package com.springMVCLearn.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author DJS
 * Date create 12:49 2023/2/8
 * Modified By DJS
 **/
public class MapperUtils {
    private static final String resource = "mybatis-config.xml";
    private static InputStream resourceStream;
    private static final SqlSessionFactory sqlSessionFactory;
    private static final SqlSession sqlSession;

    static {
        try {
            resourceStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    private MapperUtils() {}

    public static <T> Object getMapper(Class<T> c) {
        if (sqlSession != null)
            return sqlSession.getMapper(c);
        else
            return null;
    }
}
