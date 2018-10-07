package org.wlgzs.hospitalmanage.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_patient")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_number")
    private Integer patient_number;         //患者编号

    @Column(name = "patient_name")
    private String patient_name;            //患者名字

    @Column(name = "pinyin_code")
    private String pinyin_code;             //拼音码

    @Column(name = "patient_gender")
    private String patient_gender;

    @Column(name = "patient_age")
    private Integer patient_age;

    @Column(name = "patient_phone")
    private String patient_phone;

    @Column(name = "home_address")
    private String home_address;

    @Column(name = "is_money")
    private int is_money=0;       //是否欠钱(1是欠钱)

    @Column(name = "owe_money")
    private BigDecimal owe_money=new BigDecimal("0");       //欠钱

}