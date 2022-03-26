package com.yzy.ems_back.emtity;




import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Scrapform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer formId;
    private String applier;
    private String equipmentName;
    private int equipmentId;
    private String apartment;
    private Date applyTime;
    private String description;
}
