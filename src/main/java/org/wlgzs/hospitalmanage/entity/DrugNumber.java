package org.wlgzs.hospitalmanage.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author:胡亚星
 * @createTime 2018-08-30 17:59
 * @description: 结果
 **/
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DrugNumber {

    private Integer drug_code;      //药品编号

    private BigDecimal number;         //总价

    private String drug_name;       //药品编号

}
