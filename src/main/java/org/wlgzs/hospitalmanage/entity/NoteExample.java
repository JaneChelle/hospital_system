package org.wlgzs.hospitalmanage.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoteExample() {
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

        public Criteria andNoteIdIsNull() {
            addCriterion("note_id is null");
            return (Criteria) this;
        }

        public Criteria andNoteIdIsNotNull() {
            addCriterion("note_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoteIdEqualTo(Integer value) {
            addCriterion("note_id =", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdNotEqualTo(Integer value) {
            addCriterion("note_id <>", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdGreaterThan(Integer value) {
            addCriterion("note_id >", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_id >=", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdLessThan(Integer value) {
            addCriterion("note_id <", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdLessThanOrEqualTo(Integer value) {
            addCriterion("note_id <=", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdIn(List<Integer> values) {
            addCriterion("note_id in", values, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdNotIn(List<Integer> values) {
            addCriterion("note_id not in", values, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdBetween(Integer value1, Integer value2) {
            addCriterion("note_id between", value1, value2, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("note_id not between", value1, value2, "noteId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Integer value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Integer value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Integer value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Integer value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Integer value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Integer> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Integer> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Integer value1, Integer value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNull() {
            addCriterion("disease_id is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNotNull() {
            addCriterion("disease_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdEqualTo(Integer value) {
            addCriterion("disease_id =", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotEqualTo(Integer value) {
            addCriterion("disease_id <>", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThan(Integer value) {
            addCriterion("disease_id >", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disease_id >=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThan(Integer value) {
            addCriterion("disease_id <", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("disease_id <=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIn(List<Integer> values) {
            addCriterion("disease_id in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotIn(List<Integer> values) {
            addCriterion("disease_id not in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdBetween(Integer value1, Integer value2) {
            addCriterion("disease_id between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disease_id not between", value1, value2, "diseaseId");
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

        public Criteria andPriceEndIsNull() {
            addCriterion("price_end is null");
            return (Criteria) this;
        }

        public Criteria andPriceEndIsNotNull() {
            addCriterion("price_end is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEndEqualTo(BigDecimal value) {
            addCriterion("price_end =", value, "priceEnd");
            return (Criteria) this;
        }

        public Criteria andPriceEndNotEqualTo(BigDecimal value) {
            addCriterion("price_end <>", value, "priceEnd");
            return (Criteria) this;
        }

        public Criteria andPriceEndGreaterThan(BigDecimal value) {
            addCriterion("price_end >", value, "priceEnd");
            return (Criteria) this;
        }

        public Criteria andPriceEndGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_end >=", value, "priceEnd");
            return (Criteria) this;
        }

        public Criteria andPriceEndLessThan(BigDecimal value) {
            addCriterion("price_end <", value, "priceEnd");
            return (Criteria) this;
        }

        public Criteria andPriceEndLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_end <=", value, "priceEnd");
            return (Criteria) this;
        }

        public Criteria andPriceEndIn(List<BigDecimal> values) {
            addCriterion("price_end in", values, "priceEnd");
            return (Criteria) this;
        }

        public Criteria andPriceEndNotIn(List<BigDecimal> values) {
            addCriterion("price_end not in", values, "priceEnd");
            return (Criteria) this;
        }

        public Criteria andPriceEndBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_end between", value1, value2, "priceEnd");
            return (Criteria) this;
        }

        public Criteria andPriceEndNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_end not between", value1, value2, "priceEnd");
            return (Criteria) this;
        }

        public Criteria andNoteTimeIsNull() {
            addCriterion("note_time is null");
            return (Criteria) this;
        }

        public Criteria andNoteTimeIsNotNull() {
            addCriterion("note_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoteTimeEqualTo(Date value) {
            addCriterion("note_time =", value, "noteTime");
            return (Criteria) this;
        }

        public Criteria andNoteTimeNotEqualTo(Date value) {
            addCriterion("note_time <>", value, "noteTime");
            return (Criteria) this;
        }

        public Criteria andNoteTimeGreaterThan(Date value) {
            addCriterion("note_time >", value, "noteTime");
            return (Criteria) this;
        }

        public Criteria andNoteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("note_time >=", value, "noteTime");
            return (Criteria) this;
        }

        public Criteria andNoteTimeLessThan(Date value) {
            addCriterion("note_time <", value, "noteTime");
            return (Criteria) this;
        }

        public Criteria andNoteTimeLessThanOrEqualTo(Date value) {
            addCriterion("note_time <=", value, "noteTime");
            return (Criteria) this;
        }

        public Criteria andNoteTimeIn(List<Date> values) {
            addCriterion("note_time in", values, "noteTime");
            return (Criteria) this;
        }

        public Criteria andNoteTimeNotIn(List<Date> values) {
            addCriterion("note_time not in", values, "noteTime");
            return (Criteria) this;
        }

        public Criteria andNoteTimeBetween(Date value1, Date value2) {
            addCriterion("note_time between", value1, value2, "noteTime");
            return (Criteria) this;
        }

        public Criteria andNoteTimeNotBetween(Date value1, Date value2) {
            addCriterion("note_time not between", value1, value2, "noteTime");
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