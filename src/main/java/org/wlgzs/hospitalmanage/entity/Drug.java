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
    private Integer drugCode;

    private Integer drugCategory;

    private String pinyinCode;

    private String specificationContent;

    private Integer drugUnit;

    private Integer dosageForm;

    private String manufacturer;

    private String approvalNumber;

    private Integer safetyStock;

    private BigDecimal unitPrice;

    private String healthcareCode;

    private String healthcareName;

    private byte[] drugName;

}