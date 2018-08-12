package org.wlgzs.hospitalmanage.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DrugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDrugCodeIsNull() {
            addCriterion("drug_code is null");
            return (Criteria) this;
        }

        public Criteria andDrugCodeIsNotNull() {
            addCriterion("drug_code is not null");
            return (Criteria) this;
        }

        public Criteria andDrugCodeEqualTo(Integer value) {
            addCriterion("drug_code =", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeNotEqualTo(Integer value) {
            addCriterion("drug_code <>", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeGreaterThan(Integer value) {
            addCriterion("drug_code >", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("drug_code >=", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeLessThan(Integer value) {
            addCriterion("drug_code <", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeLessThanOrEqualTo(Integer value) {
            addCriterion("drug_code <=", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeIn(List<Integer> values) {
            addCriterion("drug_code in", values, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeNotIn(List<Integer> values) {
            addCriterion("drug_code not in", values, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeBetween(Integer value1, Integer value2) {
            addCriterion("drug_code between", value1, value2, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("drug_code not between", value1, value2, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryIsNull() {
            addCriterion("drug_category is null");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryIsNotNull() {
            addCriterion("drug_category is not null");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryEqualTo(Integer value) {
            addCriterion("drug_category =", value, "drugCategory");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryNotEqualTo(Integer value) {
            addCriterion("drug_category <>", value, "drugCategory");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryGreaterThan(Integer value) {
            addCriterion("drug_category >", value, "drugCategory");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("drug_category >=", value, "drugCategory");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryLessThan(Integer value) {
            addCriterion("drug_category <", value, "drugCategory");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("drug_category <=", value, "drugCategory");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryIn(List<Integer> values) {
            addCriterion("drug_category in", values, "drugCategory");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryNotIn(List<Integer> values) {
            addCriterion("drug_category not in", values, "drugCategory");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryBetween(Integer value1, Integer value2) {
            addCriterion("drug_category between", value1, value2, "drugCategory");
            return (Criteria) this;
        }

        public Criteria andDrugCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("drug_category not between", value1, value2, "drugCategory");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeIsNull() {
            addCriterion("pinyin_code is null");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeIsNotNull() {
            addCriterion("pinyin_code is not null");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeEqualTo(String value) {
            addCriterion("pinyin_code =", value, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeNotEqualTo(String value) {
            addCriterion("pinyin_code <>", value, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeGreaterThan(String value) {
            addCriterion("pinyin_code >", value, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pinyin_code >=", value, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeLessThan(String value) {
            addCriterion("pinyin_code <", value, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeLessThanOrEqualTo(String value) {
            addCriterion("pinyin_code <=", value, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeLike(String value) {
            addCriterion("pinyin_code like", value, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeNotLike(String value) {
            addCriterion("pinyin_code not like", value, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeIn(List<String> values) {
            addCriterion("pinyin_code in", values, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeNotIn(List<String> values) {
            addCriterion("pinyin_code not in", values, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeBetween(String value1, String value2) {
            addCriterion("pinyin_code between", value1, value2, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andPinyinCodeNotBetween(String value1, String value2) {
            addCriterion("pinyin_code not between", value1, value2, "pinyinCode");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentIsNull() {
            addCriterion("specification_content is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentIsNotNull() {
            addCriterion("specification_content is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentEqualTo(String value) {
            addCriterion("specification_content =", value, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentNotEqualTo(String value) {
            addCriterion("specification_content <>", value, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentGreaterThan(String value) {
            addCriterion("specification_content >", value, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentGreaterThanOrEqualTo(String value) {
            addCriterion("specification_content >=", value, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentLessThan(String value) {
            addCriterion("specification_content <", value, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentLessThanOrEqualTo(String value) {
            addCriterion("specification_content <=", value, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentLike(String value) {
            addCriterion("specification_content like", value, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentNotLike(String value) {
            addCriterion("specification_content not like", value, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentIn(List<String> values) {
            addCriterion("specification_content in", values, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentNotIn(List<String> values) {
            addCriterion("specification_content not in", values, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentBetween(String value1, String value2) {
            addCriterion("specification_content between", value1, value2, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andSpecificationContentNotBetween(String value1, String value2) {
            addCriterion("specification_content not between", value1, value2, "specificationContent");
            return (Criteria) this;
        }

        public Criteria andDrugUnitIsNull() {
            addCriterion("drug_unit is null");
            return (Criteria) this;
        }

        public Criteria andDrugUnitIsNotNull() {
            addCriterion("drug_unit is not null");
            return (Criteria) this;
        }

        public Criteria andDrugUnitEqualTo(Integer value) {
            addCriterion("drug_unit =", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitNotEqualTo(Integer value) {
            addCriterion("drug_unit <>", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitGreaterThan(Integer value) {
            addCriterion("drug_unit >", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("drug_unit >=", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitLessThan(Integer value) {
            addCriterion("drug_unit <", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitLessThanOrEqualTo(Integer value) {
            addCriterion("drug_unit <=", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitIn(List<Integer> values) {
            addCriterion("drug_unit in", values, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitNotIn(List<Integer> values) {
            addCriterion("drug_unit not in", values, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitBetween(Integer value1, Integer value2) {
            addCriterion("drug_unit between", value1, value2, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("drug_unit not between", value1, value2, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDosageFormIsNull() {
            addCriterion("dosage_form is null");
            return (Criteria) this;
        }

        public Criteria andDosageFormIsNotNull() {
            addCriterion("dosage_form is not null");
            return (Criteria) this;
        }

        public Criteria andDosageFormEqualTo(Integer value) {
            addCriterion("dosage_form =", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotEqualTo(Integer value) {
            addCriterion("dosage_form <>", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormGreaterThan(Integer value) {
            addCriterion("dosage_form >", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormGreaterThanOrEqualTo(Integer value) {
            addCriterion("dosage_form >=", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormLessThan(Integer value) {
            addCriterion("dosage_form <", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormLessThanOrEqualTo(Integer value) {
            addCriterion("dosage_form <=", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormIn(List<Integer> values) {
            addCriterion("dosage_form in", values, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotIn(List<Integer> values) {
            addCriterion("dosage_form not in", values, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormBetween(Integer value1, Integer value2) {
            addCriterion("dosage_form between", value1, value2, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotBetween(Integer value1, Integer value2) {
            addCriterion("dosage_form not between", value1, value2, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIsNull() {
            addCriterion("approval_number is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIsNotNull() {
            addCriterion("approval_number is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberEqualTo(String value) {
            addCriterion("approval_number =", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotEqualTo(String value) {
            addCriterion("approval_number <>", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberGreaterThan(String value) {
            addCriterion("approval_number >", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberGreaterThanOrEqualTo(String value) {
            addCriterion("approval_number >=", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLessThan(String value) {
            addCriterion("approval_number <", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLessThanOrEqualTo(String value) {
            addCriterion("approval_number <=", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLike(String value) {
            addCriterion("approval_number like", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotLike(String value) {
            addCriterion("approval_number not like", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIn(List<String> values) {
            addCriterion("approval_number in", values, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotIn(List<String> values) {
            addCriterion("approval_number not in", values, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberBetween(String value1, String value2) {
            addCriterion("approval_number between", value1, value2, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotBetween(String value1, String value2) {
            addCriterion("approval_number not between", value1, value2, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIsNull() {
            addCriterion("safety_stock is null");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIsNotNull() {
            addCriterion("safety_stock is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyStockEqualTo(Integer value) {
            addCriterion("safety_stock =", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotEqualTo(Integer value) {
            addCriterion("safety_stock <>", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockGreaterThan(Integer value) {
            addCriterion("safety_stock >", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("safety_stock >=", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockLessThan(Integer value) {
            addCriterion("safety_stock <", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockLessThanOrEqualTo(Integer value) {
            addCriterion("safety_stock <=", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIn(List<Integer> values) {
            addCriterion("safety_stock in", values, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotIn(List<Integer> values) {
            addCriterion("safety_stock not in", values, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockBetween(Integer value1, Integer value2) {
            addCriterion("safety_stock between", value1, value2, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotBetween(Integer value1, Integer value2) {
            addCriterion("safety_stock not between", value1, value2, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeIsNull() {
            addCriterion("healthcare_code is null");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeIsNotNull() {
            addCriterion("healthcare_code is not null");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeEqualTo(String value) {
            addCriterion("healthcare_code =", value, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeNotEqualTo(String value) {
            addCriterion("healthcare_code <>", value, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeGreaterThan(String value) {
            addCriterion("healthcare_code >", value, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeGreaterThanOrEqualTo(String value) {
            addCriterion("healthcare_code >=", value, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeLessThan(String value) {
            addCriterion("healthcare_code <", value, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeLessThanOrEqualTo(String value) {
            addCriterion("healthcare_code <=", value, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeLike(String value) {
            addCriterion("healthcare_code like", value, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeNotLike(String value) {
            addCriterion("healthcare_code not like", value, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeIn(List<String> values) {
            addCriterion("healthcare_code in", values, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeNotIn(List<String> values) {
            addCriterion("healthcare_code not in", values, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeBetween(String value1, String value2) {
            addCriterion("healthcare_code between", value1, value2, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareCodeNotBetween(String value1, String value2) {
            addCriterion("healthcare_code not between", value1, value2, "healthcareCode");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameIsNull() {
            addCriterion("healthcare_name is null");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameIsNotNull() {
            addCriterion("healthcare_name is not null");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameEqualTo(String value) {
            addCriterion("healthcare_name =", value, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameNotEqualTo(String value) {
            addCriterion("healthcare_name <>", value, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameGreaterThan(String value) {
            addCriterion("healthcare_name >", value, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameGreaterThanOrEqualTo(String value) {
            addCriterion("healthcare_name >=", value, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameLessThan(String value) {
            addCriterion("healthcare_name <", value, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameLessThanOrEqualTo(String value) {
            addCriterion("healthcare_name <=", value, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameLike(String value) {
            addCriterion("healthcare_name like", value, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameNotLike(String value) {
            addCriterion("healthcare_name not like", value, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameIn(List<String> values) {
            addCriterion("healthcare_name in", values, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameNotIn(List<String> values) {
            addCriterion("healthcare_name not in", values, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameBetween(String value1, String value2) {
            addCriterion("healthcare_name between", value1, value2, "healthcareName");
            return (Criteria) this;
        }

        public Criteria andHealthcareNameNotBetween(String value1, String value2) {
            addCriterion("healthcare_name not between", value1, value2, "healthcareName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}