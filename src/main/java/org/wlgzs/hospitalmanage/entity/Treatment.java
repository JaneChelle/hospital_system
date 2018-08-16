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
@Table(name = "tb_treatment")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Treatment implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    private Integer treatment_id;           //治疗编号

    @Column(name = "treatment_name")
    private String treatment_name;          //治疗名称

    @Column(name = "pinyin_code")
    private String pinyin_code;             //拼音码

    @Column(name = "treatment_price")
    private BigDecimal treatment_price;     //价格
}