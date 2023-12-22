package cn.mybatis.test;

import cn.mybatis.binding.MapperProxyFactory;
import cn.mybatis.test.dao.IUserDao;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {

    @Test
    public void test_MapperProxyFactory(){
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();

        sqlSession.put("cn.mybatis.test.dao.IUserDao.queryUserName","模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("cn.mybatis.test.dao.IUserDao.queryUserAge","模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");

        IUserDao userDao = factory.newInstance(sqlSession);

        String res = userDao.queryUserName("10001");

        System.out.println(res);

    }

}
