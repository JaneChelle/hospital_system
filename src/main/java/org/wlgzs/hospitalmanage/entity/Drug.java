package org.wlgzs.hospitalmanage.entity;

import java.math.BigDecimal;

public class Drug {
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

    public Integer getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(Integer drugCode) {
        this.drugCode = drugCode;
    }

    public Integer getDrugCategory() {
        return drugCategory;
    }

    public void setDrugCategory(Integer drugCategory) {
        this.drugCategory = drugCategory;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode == null ? null : pinyinCode.trim();
    }

    public String getSpecificationContent() {
        return specificationContent;
    }

    public void setSpecificationContent(String specificationContent) {
        this.specificationContent = specificationContent == null ? null : specificationContent.trim();
    }

    public Integer getDrugUnit() {
        return drugUnit;
    }

    public void setDrugUnit(Integer drugUnit) {
        this.drugUnit = drugUnit;
    }

    public Integer getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(Integer dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber == null ? null : approvalNumber.trim();
    }

    public Integer getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(Integer safetyStock) {
        this.safetyStock = safetyStock;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getHealthcareCode() {
        return healthcareCode;
    }

    public void setHealthcareCode(String healthcareCode) {
        this.healthcareCode = healthcareCode == null ? null : healthcareCode.trim();
    }

    public String getHealthcareName() {
        return healthcareName;
    }

    public void setHealthcareName(String healthcareName) {
        this.healthcareName = healthcareName == null ? null : healthcareName.trim();
    }

    public byte[] getDrugName() {
        return drugName;
    }

    public void setDrugName(byte[] drugName) {
        this.drugName = drugName;
    }
}