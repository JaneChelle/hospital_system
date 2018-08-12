package org.wlgzs.hospitalmanage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StorageRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StorageRecordExample() {
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

        public Criteria andRecordNumberIsNull() {
            addCriterion("record_number is null");
            return (Criteria) this;
        }

        public Criteria andRecordNumberIsNotNull() {
            addCriterion("record_number is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNumberEqualTo(Integer value) {
            addCriterion("record_number =", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberNotEqualTo(Integer value) {
            addCriterion("record_number <>", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberGreaterThan(Integer value) {
            addCriterion("record_number >", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_number >=", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberLessThan(Integer value) {
            addCriterion("record_number <", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberLessThanOrEqualTo(Integer value) {
            addCriterion("record_number <=", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberIn(List<Integer> values) {
            addCriterion("record_number in", values, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberNotIn(List<Integer> values) {
            addCriterion("record_number not in", values, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberBetween(Integer value1, Integer value2) {
            addCriterion("record_number between", value1, value2, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("record_number not between", value1, value2, "recordNumber");
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

        public Criteria andOperatorCodeIsNull() {
            addCriterion("operator_code is null");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeIsNotNull() {
            addCriterion("operator_code is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeEqualTo(Integer value) {
            addCriterion("operator_code =", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeNotEqualTo(Integer value) {
            addCriterion("operator_code <>", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeGreaterThan(Integer value) {
            addCriterion("operator_code >", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_code >=", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeLessThan(Integer value) {
            addCriterion("operator_code <", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeLessThanOrEqualTo(Integer value) {
            addCriterion("operator_code <=", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeIn(List<Integer> values) {
            addCriterion("operator_code in", values, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeNotIn(List<Integer> values) {
            addCriterion("operator_code not in", values, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeBetween(Integer value1, Integer value2) {
            addCriterion("operator_code between", value1, value2, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_code not between", value1, value2, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andReceiptIsNull() {
            addCriterion("receipt is null");
            return (Criteria) this;
        }

        public Criteria andReceiptIsNotNull() {
            addCriterion("receipt is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptEqualTo(Integer value) {
            addCriterion("receipt =", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotEqualTo(Integer value) {
            addCriterion("receipt <>", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptGreaterThan(Integer value) {
            addCriterion("receipt >", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptGreaterThanOrEqualTo(Integer value) {
            addCriterion("receipt >=", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptLessThan(Integer value) {
            addCriterion("receipt <", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptLessThanOrEqualTo(Integer value) {
            addCriterion("receipt <=", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptIn(List<Integer> values) {
            addCriterion("receipt in", values, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotIn(List<Integer> values) {
            addCriterion("receipt not in", values, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptBetween(Integer value1, Integer value2) {
            addCriterion("receipt between", value1, value2, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotBetween(Integer value1, Integer value2) {
            addCriterion("receipt not between", value1, value2, "receipt");
            return (Criteria) this;
        }

        public Criteria andInboundDateIsNull() {
            addCriterion("inbound_date is null");
            return (Criteria) this;
        }

        public Criteria andInboundDateIsNotNull() {
            addCriterion("inbound_date is not null");
            return (Criteria) this;
        }

        public Criteria andInboundDateEqualTo(Date value) {
            addCriterion("inbound_date =", value, "inboundDate");
            return (Criteria) this;
        }

        public Criteria andInboundDateNotEqualTo(Date value) {
            addCriterion("inbound_date <>", value, "inboundDate");
            return (Criteria) this;
        }

        public Criteria andInboundDateGreaterThan(Date value) {
            addCriterion("inbound_date >", value, "inboundDate");
            return (Criteria) this;
        }

        public Criteria andInboundDateGreaterThanOrEqualTo(Date value) {
            addCriterion("inbound_date >=", value, "inboundDate");
            return (Criteria) this;
        }

        public Criteria andInboundDateLessThan(Date value) {
            addCriterion("inbound_date <", value, "inboundDate");
            return (Criteria) this;
        }

        public Criteria andInboundDateLessThanOrEqualTo(Date value) {
            addCriterion("inbound_date <=", value, "inboundDate");
            return (Criteria) this;
        }

        public Criteria andInboundDateIn(List<Date> values) {
            addCriterion("inbound_date in", values, "inboundDate");
            return (Criteria) this;
        }

        public Criteria andInboundDateNotIn(List<Date> values) {
            addCriterion("inbound_date not in", values, "inboundDate");
            return (Criteria) this;
        }

        public Criteria andInboundDateBetween(Date value1, Date value2) {
            addCriterion("inbound_date between", value1, value2, "inboundDate");
            return (Criteria) this;
        }

        public Criteria andInboundDateNotBetween(Date value1, Date value2) {
            addCriterion("inbound_date not between", value1, value2, "inboundDate");
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