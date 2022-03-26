package com.yzy.ems_back.emtity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data
public class Purchaseform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    表单编号，申请人，部门，申请时间，用途描述，设备名称，设备编号，所需数量
    private Integer formId;
    private String applier;
    private String apartment;
    private Date applyTime;
    private String description;
    private String equipmentName;
    private int equipmentId;
    private int number;
    private int isStorage;
}
