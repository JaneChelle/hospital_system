package org.wlgzs.hospitalmanage.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private BigDecimal storage_amount;  // 库存量

    private Date valid_period;       // 有效期
    public DrugInventory(){

    }

    public DrugInventory(Integer drug_code, BigDecimal storage_amount, Date valid_period) {
        this.drug_code = drug_code;
        this.storage_amount = storage_amount;
        this.valid_period = valid_period;
    }
}