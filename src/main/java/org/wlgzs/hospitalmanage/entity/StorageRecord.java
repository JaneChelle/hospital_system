package org.wlgzs.hospitalmanage.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Data
@Entity
@Table(name = "tb_storage_record")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class StorageRecord {
    private Integer record_number;  // 记录编号

    private Integer drug_code;      // 药品编码

    private String operator_code;  // 操作员编码

    private Integer receipt;       // 入库量

    private Date inbound_date;      // 入库日期

    private Date valid_period;      // 有效期

    private String drug_name;     //药品名字

    private String pinyin_code;  //药品拼音码

    public StorageRecord() {

    }
    public StorageRecord(Integer drug_code, String drug_name, String pinyin_code, String operator_code, Integer receipt, Date inbound_date, Date valid_period) {
        this.drug_code = drug_code;
        this.operator_code = operator_code;
        this.receipt = receipt;
        this.drug_name= drug_name;
        this.inbound_date = inbound_date;
        this.valid_period = valid_period;
        this.pinyin_code=pinyin_code;
    }
}