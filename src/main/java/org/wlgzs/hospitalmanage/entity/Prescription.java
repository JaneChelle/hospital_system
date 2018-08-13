package org.wlgzs.hospitalmanage.entity;

import java.math.BigDecimal;

public class Prescription {
    private Integer prescriptionId;

    private String pinyinCode;

    private String prescriptionName;

    private Integer isDrug;

    private Integer isCheck;

    private Integer isTreatment;

    private BigDecimal priceAll;

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode == null ? null : pinyinCode.trim();
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName == null ? null : prescriptionName.trim();
    }

    public Integer getIsDrug() {
        return isDrug;
    }

    public void setIsDrug(Integer isDrug) {
        this.isDrug = isDrug;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getIsTreatment() {
        return isTreatment;
    }

    public void setIsTreatment(Integer isTreatment) {
        this.isTreatment = isTreatment;
    }

    public BigDecimal getPriceAll() {
        return priceAll;
    }

    public void setPriceAll(BigDecimal priceAll) {
        this.priceAll = priceAll;
    }
}