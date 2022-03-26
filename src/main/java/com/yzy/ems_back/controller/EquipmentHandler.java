package com.yzy.ems_back.controller;


import com.yzy.ems_back.emtity.Equipment;
import com.yzy.ems_back.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentHandler {

    @Autowired
    private EquipmentRepository equipmentRepository;

//    查询数据
//    @GetMapping("/findAll")
//    public List<Equipment> findAll() {
//        return equipmentRepository.findAll();
//    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Equipment> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return equipmentRepository.findAll(pageable);
    }


//    增加数据
//    加入@RequestBody是将json对象转为java对象
    @PostMapping("/save")
    public String save(@RequestBody Equipment equipment) {
        Equipment result = equipmentRepository.save(equipment);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

//    根据id查询结果
    @GetMapping("/findById/apartment/{id}")
    public Equipment findById(@PathVariable("id") Integer id, @PathVariable("apartment") String apartment) {
        return equipmentRepository.findById(id).get();
    }

//    修改维修申请按钮的开关
    @PutMapping("update/maintainApply")
    public String maintainApply(@RequestBody Equipment equipment) {
        Equipment result = equipmentRepository.save(equipment);
        if (result != null) {
            return "success";
        } else {
            return "false";
        }
    }


//    修改数据
    @PutMapping("/update/{id}")
    public String update(@RequestBody Equipment equipment, @PathVariable("id") Integer id) {
        System.out.println(equipment);
        Equipment result ;
        Equipment sqlEquipment;
        int totalNumber = 0;
//        首先查看数据库有没有对应的id设备
//        如果有则进行计算
//        如果没有就直接生成一条新的数据
        List<Equipment> all = equipmentRepository.findAll();
        for (Equipment e: all) {
            if (e.getEquipmentId().equals(id) == false) {
                result = equipmentRepository.save(equipment);
            }
        }
        if (equipmentRepository.findById(id).get() == null) {
            sqlEquipment = equipmentRepository.save(equipment);
        } else {
            sqlEquipment = equipmentRepository.findById(id).get();
        }


        if (sqlEquipment.getEquipmentId().equals(equipment.getEquipmentId()) && sqlEquipment.getApartment().equals(equipment.getApartment())) {
            System.out.println("进入if语句了吗");
            totalNumber = sqlEquipment.getNumber() + equipment.getNumber();
            equipment.setNumber(totalNumber);
            result = equipmentRepository.save(equipment);
        } else {
            result = equipmentRepository.save(equipment);
        }

        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

//    根据id删除数据
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        equipmentRepository.deleteById(id);
    }

//    根据id查找数据
    @GetMapping("/findById/{id}")
    public Equipment findById(@PathVariable("id") Integer id) {
        return equipmentRepository.findById(id).get();
    }
}
