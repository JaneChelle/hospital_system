package org.wlgzs.hospitalmanage.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDrugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionDrugExample() {
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

        public Criteria andDetailIdIsNull() {
            addCriterion("detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Integer value) {
            addCriterion("detail_id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Integer value) {
            addCriterion("detail_id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Integer value) {
            addCriterion("detail_id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Integer value) {
            addCriterion("detail_id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("detail_id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Integer> values) {
            addCriterion("detail_id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Integer> values) {
            addCriterion("detail_id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("detail_id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_id not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIsNull() {
            addCriterion("prescription_id is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIsNotNull() {
            addCriterion("prescription_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdEqualTo(Integer value) {
            addCriterion("prescription_id =", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotEqualTo(Integer value) {
            addCriterion("prescription_id <>", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdGreaterThan(Integer value) {
            addCriterion("prescription_id >", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prescription_id >=", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLessThan(Integer value) {
            addCriterion("prescription_id <", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLessThanOrEqualTo(Integer value) {
            addCriterion("prescription_id <=", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIn(List<Integer> values) {
            addCriterion("prescription_id in", values, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotIn(List<Integer> values) {
            addCriterion("prescription_id not in", values, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdBetween(Integer value1, Integer value2) {
            addCriterion("prescription_id between", value1, value2, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prescription_id not between", value1, value2, "prescriptionId");
            return (Criteria) this;
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andPriceOneIsNull() {
            addCriterion("price_one is null");
            return (Criteria) this;
        }

        public Criteria andPriceOneIsNotNull() {
            addCriterion("price_one is not null");
            return (Criteria) this;
        }

        public Criteria andPriceOneEqualTo(BigDecimal value) {
            addCriterion("price_one =", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneNotEqualTo(BigDecimal value) {
            addCriterion("price_one <>", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneGreaterThan(BigDecimal value) {
            addCriterion("price_one >", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_one >=", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneLessThan(BigDecimal value) {
            addCriterion("price_one <", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_one <=", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneIn(List<BigDecimal> values) {
            addCriterion("price_one in", values, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneNotIn(List<BigDecimal> values) {
            addCriterion("price_one not in", values, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_one between", value1, value2, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_one not between", value1, value2, "priceOne");
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