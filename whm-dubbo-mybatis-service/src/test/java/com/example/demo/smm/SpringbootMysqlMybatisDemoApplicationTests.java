package com.example.demo.smm;

import com.example.demo.smm.mapper.dao.UserInfoDao;
import com.example.demo.smm.mapper.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMysqlMybatisDemoApplicationTests {
    @Autowired
    UserInfoDao userInfoDao;

    @Test
    void contextLoads() {
        UserInfo userInfoById = userInfoDao.getUserInfoById(1L);
        System.out.println(userInfoById);
    }

}
