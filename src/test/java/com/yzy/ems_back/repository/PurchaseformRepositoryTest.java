package com.yzy.ems_back.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PurchaseformRepositoryTest {

    @Autowired
    private PurchaseformRepository purchaseFormRepository;


//    遍历数据
    @Test
    void findAll() {
        System.out.println(purchaseFormRepository.findAll());
    }
}