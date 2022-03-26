package com.yzy.ems_back.repository;

import com.yzy.ems_back.emtity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

//    遍历数据
    @Test
    void findAll() {
        System.out.println(userRepository.findAll());
    }


    @Test
    void update() {
        User user = new User();
        user.setId(2);
        user.setUseRight(1);
        User save = userRepository.save(user);
        System.out.println(save);
    }
}