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
@Table(name = "prescription_drug")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PrescriptionDrug implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Integer detail_id;              //编号

    @Column(name = "prescription_id")
    private Integer prescription_id;        //处方编号

    @Column(name = "drug_code")
    private Integer drug_code;              //药品编号

    @Column(name = "number")
    private Integer number;                 //数量

    @Column(name = "price_one")
    private BigDecimal price_one;           //价格
}