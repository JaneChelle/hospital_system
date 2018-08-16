package org.wlgzs.hospitalmanage.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_prescription")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Prescription implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    private Integer prescription_id;     //处方编号

    @Column(name = "pinyin_code")
    private String pinyin_code;          //拼音码

    @Column(name = "prescription_name")
    private String prescription_name;    //处方名称

    @Column(name = "is_drug")
    private Integer is_drug = 0;             //是否有药品

    @Column(name = "is_check")
    private Integer is_check = 0;            //是否有检查

    @Column(name = "is_treatment")
    private Integer is_treatment = 0;        //是否有治疗

    @Column(name = "price_all")
    private BigDecimal price_all;        //总价
}