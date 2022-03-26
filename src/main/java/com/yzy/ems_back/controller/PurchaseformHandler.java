package com.yzy.ems_back.controller;


import com.yzy.ems_back.emtity.Purchaseform;
import com.yzy.ems_back.repository.PurchaseformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchaseform")
public class PurchaseformHandler {

    @Autowired
    private PurchaseformRepository purchaseformRepository;

    //    查询数据
//    @GetMapping("/findAll")
//    public List<Purchaseform> findAll() {
//        return purchaseformRepository.findAll();
//    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Purchaseform> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return purchaseformRepository.findAll(pageable);
    }


//    增加数据
//    加入@RequestBody是将json对象转为java对象
    @PostMapping("/save")
    public String save(@RequestBody Purchaseform purchaseform) {
        Purchaseform result = purchaseformRepository.save(purchaseform);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

//    根据主键id查询结果
    @GetMapping("/findById/{id}")
    public Purchaseform findById(@PathVariable("id") Integer id) {
        return purchaseformRepository.findById(id).get();
    }

//    修改数据
    @PutMapping("/update")
    public String update(@RequestBody Purchaseform purchaseform) {
        Purchaseform result = purchaseformRepository.save(purchaseform);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

//    根据id删除数据
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        purchaseformRepository.deleteById(id);
    }
}
