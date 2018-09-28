package org.wlgzs.hospitalmanage.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author:胡亚星
 * @createTime 2018-09-27 15:50
 * @description:
 **/
@Data
@Table(name = "tb_bill_note")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class BillNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer bill_id;                //账单id

    @Column(name = "patient_id")
    private Integer patient_id;             //患者id

    @Column(name = "patient_name")
    private String patient_name;            //患者名字

    @Column(name = "price")
    private BigDecimal price;                  //价格

    @Column(name = "bill_time")
    private Date bill_time;              //账单时间

    public BillNote(Integer patient_id, String patient_name, BigDecimal price, Date bill_time) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.price = price;
        this.bill_time = bill_time;
    }
}
