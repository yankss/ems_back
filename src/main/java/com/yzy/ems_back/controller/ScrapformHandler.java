package com.yzy.ems_back.controller;


import com.yzy.ems_back.emtity.Scrapform;
import com.yzy.ems_back.repository.ScrapformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scrapform")
public class ScrapformHandler {

    @Autowired
    private ScrapformRepository scrapformRepository;

//    查询数据
//    @GetMapping("/findAll")
//    public List<Scrapform> findAll() {
//        return scrapformRepository.findAll();
//    }


    @GetMapping("/findAll/{page}/{size}")
    public Page<Scrapform> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return scrapformRepository.findAll(pageable);
    }


    //    增加数据
//    加入@RequestBody是将json对象转为java对象
    @PostMapping("/save")
    public String save(@RequestBody Scrapform scrapform) {
        Scrapform result = scrapformRepository.save(scrapform);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

//    根据主键id查询结果
    @GetMapping("/findById/{id}")
    public Scrapform findById(@PathVariable("id") Integer id) {
        return scrapformRepository.findById(id).get();
    }

//    修改数据
    @PutMapping("/update")
    public String update(@RequestBody Scrapform scrapform) {
        Scrapform result = scrapformRepository.save(scrapform);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

//    根据id删除数据
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        scrapformRepository.deleteById(id);
    }


}
