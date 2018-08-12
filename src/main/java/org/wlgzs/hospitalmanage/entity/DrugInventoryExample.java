package org.wlgzs.hospitalmanage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrugInventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugInventoryExample() {
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

        public Criteria andStockNumberIsNull() {
            addCriterion("stock_number is null");
            return (Criteria) this;
        }

        public Criteria andStockNumberIsNotNull() {
            addCriterion("stock_number is not null");
            return (Criteria) this;
        }

        public Criteria andStockNumberEqualTo(Integer value) {
            addCriterion("stock_number =", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberNotEqualTo(Integer value) {
            addCriterion("stock_number <>", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberGreaterThan(Integer value) {
            addCriterion("stock_number >", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_number >=", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberLessThan(Integer value) {
            addCriterion("stock_number <", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberLessThanOrEqualTo(Integer value) {
            addCriterion("stock_number <=", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberIn(List<Integer> values) {
            addCriterion("stock_number in", values, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberNotIn(List<Integer> values) {
            addCriterion("stock_number not in", values, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberBetween(Integer value1, Integer value2) {
            addCriterion("stock_number between", value1, value2, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_number not between", value1, value2, "stockNumber");
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

        public Criteria andStorageAmountIsNull() {
            addCriterion("storage_amount is null");
            return (Criteria) this;
        }

        public Criteria andStorageAmountIsNotNull() {
            addCriterion("storage_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStorageAmountEqualTo(Integer value) {
            addCriterion("storage_amount =", value, "storageAmount");
            return (Criteria) this;
        }

        public Criteria andStorageAmountNotEqualTo(Integer value) {
            addCriterion("storage_amount <>", value, "storageAmount");
            return (Criteria) this;
        }

        public Criteria andStorageAmountGreaterThan(Integer value) {
            addCriterion("storage_amount >", value, "storageAmount");
            return (Criteria) this;
        }

        public Criteria andStorageAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("storage_amount >=", value, "storageAmount");
            return (Criteria) this;
        }

        public Criteria andStorageAmountLessThan(Integer value) {
            addCriterion("storage_amount <", value, "storageAmount");
            return (Criteria) this;
        }

        public Criteria andStorageAmountLessThanOrEqualTo(Integer value) {
            addCriterion("storage_amount <=", value, "storageAmount");
            return (Criteria) this;
        }

        public Criteria andStorageAmountIn(List<Integer> values) {
            addCriterion("storage_amount in", values, "storageAmount");
            return (Criteria) this;
        }

        public Criteria andStorageAmountNotIn(List<Integer> values) {
            addCriterion("storage_amount not in", values, "storageAmount");
            return (Criteria) this;
        }

        public Criteria andStorageAmountBetween(Integer value1, Integer value2) {
            addCriterion("storage_amount between", value1, value2, "storageAmount");
            return (Criteria) this;
        }

        public Criteria andStorageAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("storage_amount not between", value1, value2, "storageAmount");
            return (Criteria) this;
        }

        public Criteria andValidPeriodIsNull() {
            addCriterion("valid_period is null");
            return (Criteria) this;
        }

        public Criteria andValidPeriodIsNotNull() {
            addCriterion("valid_period is not null");
            return (Criteria) this;
        }

        public Criteria andValidPeriodEqualTo(Date value) {
            addCriterion("valid_period =", value, "validPeriod");
            return (Criteria) this;
        }

        public Criteria andValidPeriodNotEqualTo(Date value) {
            addCriterion("valid_period <>", value, "validPeriod");
            return (Criteria) this;
        }

        public Criteria andValidPeriodGreaterThan(Date value) {
            addCriterion("valid_period >", value, "validPeriod");
            return (Criteria) this;
        }

        public Criteria andValidPeriodGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_period >=", value, "validPeriod");
            return (Criteria) this;
        }

        public Criteria andValidPeriodLessThan(Date value) {
            addCriterion("valid_period <", value, "validPeriod");
            return (Criteria) this;
        }

        public Criteria andValidPeriodLessThanOrEqualTo(Date value) {
            addCriterion("valid_period <=", value, "validPeriod");
            return (Criteria) this;
        }

        public Criteria andValidPeriodIn(List<Date> values) {
            addCriterion("valid_period in", values, "validPeriod");
            return (Criteria) this;
        }

        public Criteria andValidPeriodNotIn(List<Date> values) {
            addCriterion("valid_period not in", values, "validPeriod");
            return (Criteria) this;
        }

        public Criteria andValidPeriodBetween(Date value1, Date value2) {
            addCriterion("valid_period between", value1, value2, "validPeriod");
            return (Criteria) this;
        }

        public Criteria andValidPeriodNotBetween(Date value1, Date value2) {
            addCriterion("valid_period not between", value1, value2, "validPeriod");
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