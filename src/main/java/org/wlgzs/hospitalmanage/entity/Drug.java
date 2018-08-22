package org.wlgzs.hospitalmanage.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_drug")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "drug_code")
    private Integer drug_code;              //药品编码

    @Column(name = "drug_category")          // 药品类别
    private Integer drug_category;

    @Column(name = "pinyin_code")            // 拼音码
    private String pinyin_code;

    @Column(name = "specification_content")  //规格含量
    private String specification_content;

    @Column(name = "drug_unit")            //单位
    private Integer drug_unit;

    @Column(name = "dosage_form")          //剂型
    private Integer dosage_form;

    @Column(name = "manufacturer")         //厂家
    private String manufacturer;

    @Column(name = "approval_number")      // 批准文号
    private String approval_number;

    @Column(name = "safety_stock")         // 安全库存
    private BigDecimal safety_stock;

    @Column(name = "unit_price")           //单位价格
    private BigDecimal unit_price;

    @Column(name = "healthcare_code")      //医保编码
    private String healthcare_code;

    @Column(name = "healthcare_name")      //医保名称
    private String healthcare_name;

    @Column(name = "drug_name")            //药品名称
    private String drug_name;

}