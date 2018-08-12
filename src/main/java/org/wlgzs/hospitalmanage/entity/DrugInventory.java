package org.wlgzs.hospitalmanage.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "drug_inventory")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DrugInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockNumber;

    private Integer drugCode;

    private Integer storageAmount;

    private Date validPeriod;

}