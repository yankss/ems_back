package com.yzy.ems_back.controller;


import com.yzy.ems_back.emtity.User;
import com.yzy.ems_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

//    查询表中所有数据

//    通过Pageable进行数据分页返回到前端
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<User> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return userRepository.findAll(pageable);
    }

//    修改数据
    @PutMapping("/update")
    public String update(@RequestBody User user) {
        User result = userRepository.save(user);
        if (result != null) {
            System.out.println("token值为"+user.getToken());
            return "success";
        } else {
            System.out.println("失败了！！！！！！");
            return "error";
        }
    }

//    根据主键id查询结果
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }


//    添加token
    @PutMapping("/addToken")
    public String addToken(@RequestBody User user) {
        String token = UUID.randomUUID()+"";
        user.setToken(token);
        User result = userRepository.save(user);
        if (result != null) {
            System.out.println("token值为"+user.getToken());
            return "success";
        } else {
            System.out.println("失败了！！！！！！");
            return "error";
        }
    }




}
