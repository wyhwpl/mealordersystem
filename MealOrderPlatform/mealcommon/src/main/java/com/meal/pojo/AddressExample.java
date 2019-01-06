package com.meal.pojo;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andAddridIsNull() {
            addCriterion("addrid is null");
            return (Criteria) this;
        }

        public Criteria andAddridIsNotNull() {
            addCriterion("addrid is not null");
            return (Criteria) this;
        }

        public Criteria andAddridEqualTo(String value) {
            addCriterion("addrid =", value, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridNotEqualTo(String value) {
            addCriterion("addrid <>", value, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridGreaterThan(String value) {
            addCriterion("addrid >", value, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridGreaterThanOrEqualTo(String value) {
            addCriterion("addrid >=", value, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridLessThan(String value) {
            addCriterion("addrid <", value, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridLessThanOrEqualTo(String value) {
            addCriterion("addrid <=", value, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridLike(String value) {
            addCriterion("addrid like", value, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridNotLike(String value) {
            addCriterion("addrid not like", value, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridIn(List<String> values) {
            addCriterion("addrid in", values, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridNotIn(List<String> values) {
            addCriterion("addrid not in", values, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridBetween(String value1, String value2) {
            addCriterion("addrid between", value1, value2, "addrid");
            return (Criteria) this;
        }

        public Criteria andAddridNotBetween(String value1, String value2) {
            addCriterion("addrid not between", value1, value2, "addrid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andAddrdescIsNull() {
            addCriterion("addrdesc is null");
            return (Criteria) this;
        }

        public Criteria andAddrdescIsNotNull() {
            addCriterion("addrdesc is not null");
            return (Criteria) this;
        }

        public Criteria andAddrdescEqualTo(String value) {
            addCriterion("addrdesc =", value, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescNotEqualTo(String value) {
            addCriterion("addrdesc <>", value, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescGreaterThan(String value) {
            addCriterion("addrdesc >", value, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescGreaterThanOrEqualTo(String value) {
            addCriterion("addrdesc >=", value, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescLessThan(String value) {
            addCriterion("addrdesc <", value, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescLessThanOrEqualTo(String value) {
            addCriterion("addrdesc <=", value, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescLike(String value) {
            addCriterion("addrdesc like", value, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescNotLike(String value) {
            addCriterion("addrdesc not like", value, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescIn(List<String> values) {
            addCriterion("addrdesc in", values, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescNotIn(List<String> values) {
            addCriterion("addrdesc not in", values, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescBetween(String value1, String value2) {
            addCriterion("addrdesc between", value1, value2, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andAddrdescNotBetween(String value1, String value2) {
            addCriterion("addrdesc not between", value1, value2, "addrdesc");
            return (Criteria) this;
        }

        public Criteria andRecentuseIsNull() {
            addCriterion("recentuse is null");
            return (Criteria) this;
        }

        public Criteria andRecentuseIsNotNull() {
            addCriterion("recentuse is not null");
            return (Criteria) this;
        }

        public Criteria andRecentuseEqualTo(Integer value) {
            addCriterion("recentuse =", value, "recentuse");
            return (Criteria) this;
        }

        public Criteria andRecentuseNotEqualTo(Integer value) {
            addCriterion("recentuse <>", value, "recentuse");
            return (Criteria) this;
        }

        public Criteria andRecentuseGreaterThan(Integer value) {
            addCriterion("recentuse >", value, "recentuse");
            return (Criteria) this;
        }

        public Criteria andRecentuseGreaterThanOrEqualTo(Integer value) {
            addCriterion("recentuse >=", value, "recentuse");
            return (Criteria) this;
        }

        public Criteria andRecentuseLessThan(Integer value) {
            addCriterion("recentuse <", value, "recentuse");
            return (Criteria) this;
        }

        public Criteria andRecentuseLessThanOrEqualTo(Integer value) {
            addCriterion("recentuse <=", value, "recentuse");
            return (Criteria) this;
        }

        public Criteria andRecentuseIn(List<Integer> values) {
            addCriterion("recentuse in", values, "recentuse");
            return (Criteria) this;
        }

        public Criteria andRecentuseNotIn(List<Integer> values) {
            addCriterion("recentuse not in", values, "recentuse");
            return (Criteria) this;
        }

        public Criteria andRecentuseBetween(Integer value1, Integer value2) {
            addCriterion("recentuse between", value1, value2, "recentuse");
            return (Criteria) this;
        }

        public Criteria andRecentuseNotBetween(Integer value1, Integer value2) {
            addCriterion("recentuse not between", value1, value2, "recentuse");
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