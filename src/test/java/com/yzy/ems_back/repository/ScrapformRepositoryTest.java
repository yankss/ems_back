package com.yzy.ems_back.repository;

import com.yzy.ems_back.emtity.Scrapform;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScrapformRepositoryTest {

    @Autowired
    private ScrapformRepository scrapformRepository;

//    遍历数据
    @Test
    void findAll() {
        System.out.println(scrapformRepository.findAll());
    }



}