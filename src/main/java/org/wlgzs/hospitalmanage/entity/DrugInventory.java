package org.wlgzs.hospitalmanage.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Entity
@Table(name = "tb_drug_inventory")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DrugInventory {
    private Integer stock_number;  // 库存编号

    private Integer drug_code;     // 药品编码

    private String  drug_name;     //药品名字

    private BigDecimal storage_amount;  // 库存量

    private Date valid_period;       //有效期

    private int   is_safety_stock;    //是否安全库存

    private String  pinyin_code;     //药品拼音码


    public DrugInventory(){

    }

    public DrugInventory(Integer drug_code,String drug_name,String pinyin_code, BigDecimal storage_amount, Date valid_period,int is_safety_stock) {
        this.drug_code = drug_code;
        this.storage_amount = storage_amount;
        this.valid_period = valid_period;
        this.drug_name = drug_name;
        this.is_safety_stock = is_safety_stock;
        this.pinyin_code=pinyin_code;
    }
}