package org.wlgzs.hospitalmanage.entity;

import java.util.ArrayList;
import java.util.List;

public class DrugAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugAttributeExample() {
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

        public Criteria andAttributeNumberIsNull() {
            addCriterion("attribute_number is null");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberIsNotNull() {
            addCriterion("attribute_number is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberEqualTo(Integer value) {
            addCriterion("attribute_number =", value, "attributeNumber");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberNotEqualTo(Integer value) {
            addCriterion("attribute_number <>", value, "attributeNumber");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberGreaterThan(Integer value) {
            addCriterion("attribute_number >", value, "attributeNumber");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("attribute_number >=", value, "attributeNumber");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberLessThan(Integer value) {
            addCriterion("attribute_number <", value, "attributeNumber");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberLessThanOrEqualTo(Integer value) {
            addCriterion("attribute_number <=", value, "attributeNumber");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberIn(List<Integer> values) {
            addCriterion("attribute_number in", values, "attributeNumber");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberNotIn(List<Integer> values) {
            addCriterion("attribute_number not in", values, "attributeNumber");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberBetween(Integer value1, Integer value2) {
            addCriterion("attribute_number between", value1, value2, "attributeNumber");
            return (Criteria) this;
        }

        public Criteria andAttributeNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("attribute_number not between", value1, value2, "attributeNumber");
            return (Criteria) this;
        }

        public Criteria andAttributeNameIsNull() {
            addCriterion("attribute_name is null");
            return (Criteria) this;
        }

        public Criteria andAttributeNameIsNotNull() {
            addCriterion("attribute_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEqualTo(String value) {
            addCriterion("attribute_name =", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameNotEqualTo(String value) {
            addCriterion("attribute_name <>", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameGreaterThan(String value) {
            addCriterion("attribute_name >", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameGreaterThanOrEqualTo(String value) {
            addCriterion("attribute_name >=", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameLessThan(String value) {
            addCriterion("attribute_name <", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameLessThanOrEqualTo(String value) {
            addCriterion("attribute_name <=", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameLike(String value) {
            addCriterion("attribute_name like", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameNotLike(String value) {
            addCriterion("attribute_name not like", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameIn(List<String> values) {
            addCriterion("attribute_name in", values, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameNotIn(List<String> values) {
            addCriterion("attribute_name not in", values, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameBetween(String value1, String value2) {
            addCriterion("attribute_name between", value1, value2, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameNotBetween(String value1, String value2) {
            addCriterion("attribute_name not between", value1, value2, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionIsNull() {
            addCriterion("attribute_distinction is null");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionIsNotNull() {
            addCriterion("attribute_distinction is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionEqualTo(Integer value) {
            addCriterion("attribute_distinction =", value, "attributeDistinction");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionNotEqualTo(Integer value) {
            addCriterion("attribute_distinction <>", value, "attributeDistinction");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionGreaterThan(Integer value) {
            addCriterion("attribute_distinction >", value, "attributeDistinction");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionGreaterThanOrEqualTo(Integer value) {
            addCriterion("attribute_distinction >=", value, "attributeDistinction");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionLessThan(Integer value) {
            addCriterion("attribute_distinction <", value, "attributeDistinction");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionLessThanOrEqualTo(Integer value) {
            addCriterion("attribute_distinction <=", value, "attributeDistinction");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionIn(List<Integer> values) {
            addCriterion("attribute_distinction in", values, "attributeDistinction");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionNotIn(List<Integer> values) {
            addCriterion("attribute_distinction not in", values, "attributeDistinction");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionBetween(Integer value1, Integer value2) {
            addCriterion("attribute_distinction between", value1, value2, "attributeDistinction");
            return (Criteria) this;
        }

        public Criteria andAttributeDistinctionNotBetween(Integer value1, Integer value2) {
            addCriterion("attribute_distinction not between", value1, value2, "attributeDistinction");
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