package org.wlgzs.hospitalmanage.entity;

import java.math.BigDecimal;

public class Treatment {
    private Integer treatmentId;

    private String treatmentName;

    private String pinyinCode;

    private BigDecimal treatmentPrice;

    public Integer getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName == null ? null : treatmentName.trim();
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode == null ? null : pinyinCode.trim();
    }

    public BigDecimal getTreatmentPrice() {
        return treatmentPrice;
    }

    public void setTreatmentPrice(BigDecimal treatmentPrice) {
        this.treatmentPrice = treatmentPrice;
    }
}