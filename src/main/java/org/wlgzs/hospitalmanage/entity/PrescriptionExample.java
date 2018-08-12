package org.wlgzs.hospitalmanage.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionExample() {
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

        public Criteria andPrescriptionNameIsNull() {
            addCriterion("prescription_name is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameIsNotNull() {
            addCriterion("prescription_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameEqualTo(String value) {
            addCriterion("prescription_name =", value, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameNotEqualTo(String value) {
            addCriterion("prescription_name <>", value, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameGreaterThan(String value) {
            addCriterion("prescription_name >", value, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameGreaterThanOrEqualTo(String value) {
            addCriterion("prescription_name >=", value, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameLessThan(String value) {
            addCriterion("prescription_name <", value, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameLessThanOrEqualTo(String value) {
            addCriterion("prescription_name <=", value, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameLike(String value) {
            addCriterion("prescription_name like", value, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameNotLike(String value) {
            addCriterion("prescription_name not like", value, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameIn(List<String> values) {
            addCriterion("prescription_name in", values, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameNotIn(List<String> values) {
            addCriterion("prescription_name not in", values, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameBetween(String value1, String value2) {
            addCriterion("prescription_name between", value1, value2, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNameNotBetween(String value1, String value2) {
            addCriterion("prescription_name not between", value1, value2, "prescriptionName");
            return (Criteria) this;
        }

        public Criteria andIsDrugIsNull() {
            addCriterion("is_drug is null");
            return (Criteria) this;
        }

        public Criteria andIsDrugIsNotNull() {
            addCriterion("is_drug is not null");
            return (Criteria) this;
        }

        public Criteria andIsDrugEqualTo(Integer value) {
            addCriterion("is_drug =", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugNotEqualTo(Integer value) {
            addCriterion("is_drug <>", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugGreaterThan(Integer value) {
            addCriterion("is_drug >", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_drug >=", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugLessThan(Integer value) {
            addCriterion("is_drug <", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugLessThanOrEqualTo(Integer value) {
            addCriterion("is_drug <=", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugIn(List<Integer> values) {
            addCriterion("is_drug in", values, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugNotIn(List<Integer> values) {
            addCriterion("is_drug not in", values, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugBetween(Integer value1, Integer value2) {
            addCriterion("is_drug between", value1, value2, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugNotBetween(Integer value1, Integer value2) {
            addCriterion("is_drug not between", value1, value2, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNull() {
            addCriterion("is_check is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNotNull() {
            addCriterion("is_check is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckEqualTo(Integer value) {
            addCriterion("is_check =", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotEqualTo(Integer value) {
            addCriterion("is_check <>", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThan(Integer value) {
            addCriterion("is_check >", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_check >=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThan(Integer value) {
            addCriterion("is_check <", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThanOrEqualTo(Integer value) {
            addCriterion("is_check <=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckIn(List<Integer> values) {
            addCriterion("is_check in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotIn(List<Integer> values) {
            addCriterion("is_check not in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckBetween(Integer value1, Integer value2) {
            addCriterion("is_check between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("is_check not between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentIsNull() {
            addCriterion("is_treatment is null");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentIsNotNull() {
            addCriterion("is_treatment is not null");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentEqualTo(Integer value) {
            addCriterion("is_treatment =", value, "isTreatment");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentNotEqualTo(Integer value) {
            addCriterion("is_treatment <>", value, "isTreatment");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentGreaterThan(Integer value) {
            addCriterion("is_treatment >", value, "isTreatment");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_treatment >=", value, "isTreatment");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentLessThan(Integer value) {
            addCriterion("is_treatment <", value, "isTreatment");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentLessThanOrEqualTo(Integer value) {
            addCriterion("is_treatment <=", value, "isTreatment");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentIn(List<Integer> values) {
            addCriterion("is_treatment in", values, "isTreatment");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentNotIn(List<Integer> values) {
            addCriterion("is_treatment not in", values, "isTreatment");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentBetween(Integer value1, Integer value2) {
            addCriterion("is_treatment between", value1, value2, "isTreatment");
            return (Criteria) this;
        }

        public Criteria andIsTreatmentNotBetween(Integer value1, Integer value2) {
            addCriterion("is_treatment not between", value1, value2, "isTreatment");
            return (Criteria) this;
        }

        public Criteria andPriceAllIsNull() {
            addCriterion("price_all is null");
            return (Criteria) this;
        }

        public Criteria andPriceAllIsNotNull() {
            addCriterion("price_all is not null");
            return (Criteria) this;
        }

        public Criteria andPriceAllEqualTo(BigDecimal value) {
            addCriterion("price_all =", value, "priceAll");
            return (Criteria) this;
        }

        public Criteria andPriceAllNotEqualTo(BigDecimal value) {
            addCriterion("price_all <>", value, "priceAll");
            return (Criteria) this;
        }

        public Criteria andPriceAllGreaterThan(BigDecimal value) {
            addCriterion("price_all >", value, "priceAll");
            return (Criteria) this;
        }

        public Criteria andPriceAllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_all >=", value, "priceAll");
            return (Criteria) this;
        }

        public Criteria andPriceAllLessThan(BigDecimal value) {
            addCriterion("price_all <", value, "priceAll");
            return (Criteria) this;
        }

        public Criteria andPriceAllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_all <=", value, "priceAll");
            return (Criteria) this;
        }

        public Criteria andPriceAllIn(List<BigDecimal> values) {
            addCriterion("price_all in", values, "priceAll");
            return (Criteria) this;
        }

        public Criteria andPriceAllNotIn(List<BigDecimal> values) {
            addCriterion("price_all not in", values, "priceAll");
            return (Criteria) this;
        }

        public Criteria andPriceAllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_all between", value1, value2, "priceAll");
            return (Criteria) this;
        }

        public Criteria andPriceAllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_all not between", value1, value2, "priceAll");
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