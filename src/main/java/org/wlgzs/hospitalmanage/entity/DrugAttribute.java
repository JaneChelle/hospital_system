package org.wlgzs.hospitalmanage.entity;

public class DrugAttribute {
    private Integer attributeNumber;

    private String attributeName;

    private Integer attributeDistinction;

    public Integer getAttributeNumber() {
        return attributeNumber;
    }

    public void setAttributeNumber(Integer attributeNumber) {
        this.attributeNumber = attributeNumber;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName == null ? null : attributeName.trim();
    }

    public Integer getAttributeDistinction() {
        return attributeDistinction;
    }

    public void setAttributeDistinction(Integer attributeDistinction) {
        this.attributeDistinction = attributeDistinction;
    }
}