package org.wlgzs.hospitalmanage.entity;

import java.util.Date;

public class DrugInventory {
    private Integer stockNumber;

    private Integer drugCode;

    private Integer storageAmount;

    private Date validPeriod;

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Integer getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(Integer drugCode) {
        this.drugCode = drugCode;
    }

    public Integer getStorageAmount() {
        return storageAmount;
    }

    public void setStorageAmount(Integer storageAmount) {
        this.storageAmount = storageAmount;
    }

    public Date getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(Date validPeriod) {
        this.validPeriod = validPeriod;
    }
}