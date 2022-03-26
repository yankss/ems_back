package com.yzy.ems_back;

import com.yzy.ems_back.emtity.Equipment;
import com.yzy.ems_back.repository.EquipmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmsBackApplicationTests {

    @Autowired
    private EquipmentRepository repository;

    @Test
    void contextLoads() {
    }


//    插入数据
    @Test
    void save() {
        Equipment equipment = new Equipment();
        equipment.setEquipmentName("苹果平板电脑");
        equipment.setUseTime(0);
        equipment.setSafeState("新买的");

        Equipment save = repository.save(equipment);
        System.out.println(save);
    }

//    根据id查数据
    @Test
    void findById() {
        Equipment equipment = repository.findById(1).get();
        System.out.println(equipment);
    }


//    修改数据
    @Test
    void update() {
        Equipment equipment = new Equipment();
        equipment.setEquipmentId(1);
        equipment.setEquipmentName("测试设备");
        Equipment save = repository.save(equipment);
        System.out.println(save);
    }

//    删除数据
    @Test
    void delete() {
        repository.deleteById(1);
    }




}
