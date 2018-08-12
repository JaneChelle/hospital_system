package org.wlgzs.hospitalmanage.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckExample() {
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

        public Criteria andCheckIdIsNull() {
            addCriterion("check_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNotNull() {
            addCriterion("check_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckIdEqualTo(Integer value) {
            addCriterion("check_id =", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotEqualTo(Integer value) {
            addCriterion("check_id <>", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThan(Integer value) {
            addCriterion("check_id >", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_id >=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThan(Integer value) {
            addCriterion("check_id <", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThanOrEqualTo(Integer value) {
            addCriterion("check_id <=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdIn(List<Integer> values) {
            addCriterion("check_id in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotIn(List<Integer> values) {
            addCriterion("check_id not in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdBetween(Integer value1, Integer value2) {
            addCriterion("check_id between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotBetween(Integer value1, Integer value2) {
            addCriterion("check_id not between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckNameIsNull() {
            addCriterion("check_name is null");
            return (Criteria) this;
        }

        public Criteria andCheckNameIsNotNull() {
            addCriterion("check_name is not null");
            return (Criteria) this;
        }

        public Criteria andCheckNameEqualTo(String value) {
            addCriterion("check_name =", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotEqualTo(String value) {
            addCriterion("check_name <>", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameGreaterThan(String value) {
            addCriterion("check_name >", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameGreaterThanOrEqualTo(String value) {
            addCriterion("check_name >=", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLessThan(String value) {
            addCriterion("check_name <", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLessThanOrEqualTo(String value) {
            addCriterion("check_name <=", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLike(String value) {
            addCriterion("check_name like", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotLike(String value) {
            addCriterion("check_name not like", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameIn(List<String> values) {
            addCriterion("check_name in", values, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotIn(List<String> values) {
            addCriterion("check_name not in", values, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameBetween(String value1, String value2) {
            addCriterion("check_name between", value1, value2, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotBetween(String value1, String value2) {
            addCriterion("check_name not between", value1, value2, "checkName");
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

        public Criteria andCheckPriceIsNull() {
            addCriterion("check_price is null");
            return (Criteria) this;
        }

        public Criteria andCheckPriceIsNotNull() {
            addCriterion("check_price is not null");
            return (Criteria) this;
        }

        public Criteria andCheckPriceEqualTo(BigDecimal value) {
            addCriterion("check_price =", value, "checkPrice");
            return (Criteria) this;
        }

        public Criteria andCheckPriceNotEqualTo(BigDecimal value) {
            addCriterion("check_price <>", value, "checkPrice");
            return (Criteria) this;
        }

        public Criteria andCheckPriceGreaterThan(BigDecimal value) {
            addCriterion("check_price >", value, "checkPrice");
            return (Criteria) this;
        }

        public Criteria andCheckPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("check_price >=", value, "checkPrice");
            return (Criteria) this;
        }

        public Criteria andCheckPriceLessThan(BigDecimal value) {
            addCriterion("check_price <", value, "checkPrice");
            return (Criteria) this;
        }

        public Criteria andCheckPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("check_price <=", value, "checkPrice");
            return (Criteria) this;
        }

        public Criteria andCheckPriceIn(List<BigDecimal> values) {
            addCriterion("check_price in", values, "checkPrice");
            return (Criteria) this;
        }

        public Criteria andCheckPriceNotIn(List<BigDecimal> values) {
            addCriterion("check_price not in", values, "checkPrice");
            return (Criteria) this;
        }

        public Criteria andCheckPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_price between", value1, value2, "checkPrice");
            return (Criteria) this;
        }

        public Criteria andCheckPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_price not between", value1, value2, "checkPrice");
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