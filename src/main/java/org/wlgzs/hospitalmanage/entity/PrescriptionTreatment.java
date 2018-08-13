package org.wlgzs.hospitalmanage.entity;

import java.math.BigDecimal;

public class PrescriptionTreatment {
    private Integer detailId;

    private Integer prescriptionId;

    private Integer treatmentId;

    private Integer number;

    private BigDecimal priceOne;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPriceOne() {
        return priceOne;
    }

    public void setPriceOne(BigDecimal priceOne) {
        this.priceOne = priceOne;
    }
}