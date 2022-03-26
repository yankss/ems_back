package com.yzy.ems_back.emtity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Equipment {
//    定义字段的时候，需要跟数据表中的字段对应，
//    数据库表中的字段名不能出现大写，所以要进行分割线的分割，
//    在java中对应的就用驼峰命名法去做匹配才能找到相对于的字段列
    @Id
//    当我向表中插入数据涉及到自增字段的时候，需要添加以下注解
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipmentId;
    private String equipmentName;
    private int useTime;
    private String safeState;
    private String apartment;
    private int number;
    private int messageFlage;
    private int mtaFlage;
    private int serviceFlage;
}
