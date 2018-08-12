package org.wlgzs.hospitalmanage.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TreatmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TreatmentExample() {
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

        public Criteria andTreatmentIdIsNull() {
            addCriterion("treatment_id is null");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdIsNotNull() {
            addCriterion("treatment_id is not null");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdEqualTo(Integer value) {
            addCriterion("treatment_id =", value, "treatmentId");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdNotEqualTo(Integer value) {
            addCriterion("treatment_id <>", value, "treatmentId");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdGreaterThan(Integer value) {
            addCriterion("treatment_id >", value, "treatmentId");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("treatment_id >=", value, "treatmentId");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdLessThan(Integer value) {
            addCriterion("treatment_id <", value, "treatmentId");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("treatment_id <=", value, "treatmentId");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdIn(List<Integer> values) {
            addCriterion("treatment_id in", values, "treatmentId");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdNotIn(List<Integer> values) {
            addCriterion("treatment_id not in", values, "treatmentId");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdBetween(Integer value1, Integer value2) {
            addCriterion("treatment_id between", value1, value2, "treatmentId");
            return (Criteria) this;
        }

        public Criteria andTreatmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("treatment_id not between", value1, value2, "treatmentId");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameIsNull() {
            addCriterion("treatment_name is null");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameIsNotNull() {
            addCriterion("treatment_name is not null");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameEqualTo(String value) {
            addCriterion("treatment_name =", value, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameNotEqualTo(String value) {
            addCriterion("treatment_name <>", value, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameGreaterThan(String value) {
            addCriterion("treatment_name >", value, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("treatment_name >=", value, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameLessThan(String value) {
            addCriterion("treatment_name <", value, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameLessThanOrEqualTo(String value) {
            addCriterion("treatment_name <=", value, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameLike(String value) {
            addCriterion("treatment_name like", value, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameNotLike(String value) {
            addCriterion("treatment_name not like", value, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameIn(List<String> values) {
            addCriterion("treatment_name in", values, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameNotIn(List<String> values) {
            addCriterion("treatment_name not in", values, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameBetween(String value1, String value2) {
            addCriterion("treatment_name between", value1, value2, "treatmentName");
            return (Criteria) this;
        }

        public Criteria andTreatmentNameNotBetween(String value1, String value2) {
            addCriterion("treatment_name not between", value1, value2, "treatmentName");
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

        public Criteria andTreatmentPriceIsNull() {
            addCriterion("treatment_price is null");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceIsNotNull() {
            addCriterion("treatment_price is not null");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceEqualTo(BigDecimal value) {
            addCriterion("treatment_price =", value, "treatmentPrice");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceNotEqualTo(BigDecimal value) {
            addCriterion("treatment_price <>", value, "treatmentPrice");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceGreaterThan(BigDecimal value) {
            addCriterion("treatment_price >", value, "treatmentPrice");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("treatment_price >=", value, "treatmentPrice");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceLessThan(BigDecimal value) {
            addCriterion("treatment_price <", value, "treatmentPrice");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("treatment_price <=", value, "treatmentPrice");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceIn(List<BigDecimal> values) {
            addCriterion("treatment_price in", values, "treatmentPrice");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceNotIn(List<BigDecimal> values) {
            addCriterion("treatment_price not in", values, "treatmentPrice");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("treatment_price between", value1, value2, "treatmentPrice");
            return (Criteria) this;
        }

        public Criteria andTreatmentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("treatment_price not between", value1, value2, "treatmentPrice");
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