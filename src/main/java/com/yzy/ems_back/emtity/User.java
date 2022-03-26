package com.yzy.ems_back.emtity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

//用户实体类

// 类名与数据库表名对应
@Entity
@Data
public class User {
//    用户id 用户名 密码 权限
//    利用hibernate绑定数据库表时，需要通过@Id来绑定
    @Id
    private Integer id;
    private String username;
    private String password;
    private int useRight;
    private String identity;
    private String apartment;
    private String token;
}
