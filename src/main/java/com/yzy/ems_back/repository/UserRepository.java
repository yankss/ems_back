package com.yzy.ems_back.repository;

import com.yzy.ems_back.emtity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//泛型里面第一个参数是实体类的类型， 第二个参数是主键的类型
public interface UserRepository extends JpaRepository<User, Integer> {
}
