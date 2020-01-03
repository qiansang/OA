package com.bonc.oa.wanda.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CustomerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andIdeaIdIsNull() {
            addCriterion("idea_id is null");
            return (Criteria) this;
        }

        public Criteria andIdeaIdIsNotNull() {
            addCriterion("idea_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdeaIdEqualTo(Integer value) {
            addCriterion("idea_id =", value, "ideaId");
            return (Criteria) this;
        }

        public Criteria andIdeaIdNotEqualTo(Integer value) {
            addCriterion("idea_id <>", value, "ideaId");
            return (Criteria) this;
        }

        public Criteria andIdeaIdGreaterThan(Integer value) {
            addCriterion("idea_id >", value, "ideaId");
            return (Criteria) this;
        }

        public Criteria andIdeaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("idea_id >=", value, "ideaId");
            return (Criteria) this;
        }

        public Criteria andIdeaIdLessThan(Integer value) {
            addCriterion("idea_id <", value, "ideaId");
            return (Criteria) this;
        }

        public Criteria andIdeaIdLessThanOrEqualTo(Integer value) {
            addCriterion("idea_id <=", value, "ideaId");
            return (Criteria) this;
        }

        public Criteria andIdeaIdIn(List<Integer> values) {
            addCriterion("idea_id in", values, "ideaId");
            return (Criteria) this;
        }

        public Criteria andIdeaIdNotIn(List<Integer> values) {
            addCriterion("idea_id not in", values, "ideaId");
            return (Criteria) this;
        }

        public Criteria andIdeaIdBetween(Integer value1, Integer value2) {
            addCriterion("idea_id between", value1, value2, "ideaId");
            return (Criteria) this;
        }

        public Criteria andIdeaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("idea_id not between", value1, value2, "ideaId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Integer value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Integer value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Integer value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Integer value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Integer> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Integer> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNull() {
            addCriterion("title_id is null");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNotNull() {
            addCriterion("title_id is not null");
            return (Criteria) this;
        }

        public Criteria andTitleIdEqualTo(Integer value) {
            addCriterion("title_id =", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotEqualTo(Integer value) {
            addCriterion("title_id <>", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThan(Integer value) {
            addCriterion("title_id >", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("title_id >=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThan(Integer value) {
            addCriterion("title_id <", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThanOrEqualTo(Integer value) {
            addCriterion("title_id <=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdIn(List<Integer> values) {
            addCriterion("title_id in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotIn(List<Integer> values) {
            addCriterion("title_id not in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdBetween(Integer value1, Integer value2) {
            addCriterion("title_id between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("title_id not between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andProfessionIdIsNull() {
            addCriterion("profession_id is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIdIsNotNull() {
            addCriterion("profession_id is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionIdEqualTo(Integer value) {
            addCriterion("profession_id =", value, "professionId");
            return (Criteria) this;
        }

        public Criteria andProfessionIdNotEqualTo(Integer value) {
            addCriterion("profession_id <>", value, "professionId");
            return (Criteria) this;
        }

        public Criteria andProfessionIdGreaterThan(Integer value) {
            addCriterion("profession_id >", value, "professionId");
            return (Criteria) this;
        }

        public Criteria andProfessionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("profession_id >=", value, "professionId");
            return (Criteria) this;
        }

        public Criteria andProfessionIdLessThan(Integer value) {
            addCriterion("profession_id <", value, "professionId");
            return (Criteria) this;
        }

        public Criteria andProfessionIdLessThanOrEqualTo(Integer value) {
            addCriterion("profession_id <=", value, "professionId");
            return (Criteria) this;
        }

        public Criteria andProfessionIdIn(List<Integer> values) {
            addCriterion("profession_id in", values, "professionId");
            return (Criteria) this;
        }

        public Criteria andProfessionIdNotIn(List<Integer> values) {
            addCriterion("profession_id not in", values, "professionId");
            return (Criteria) this;
        }

        public Criteria andProfessionIdBetween(Integer value1, Integer value2) {
            addCriterion("profession_id between", value1, value2, "professionId");
            return (Criteria) this;
        }

        public Criteria andProfessionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("profession_id not between", value1, value2, "professionId");
            return (Criteria) this;
        }

        public Criteria andRegisterIsNull() {
            addCriterion("register is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIsNotNull() {
            addCriterion("register is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterEqualTo(String value) {
            addCriterion("register =", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotEqualTo(String value) {
            addCriterion("register <>", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterGreaterThan(String value) {
            addCriterion("register >", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterGreaterThanOrEqualTo(String value) {
            addCriterion("register >=", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterLessThan(String value) {
            addCriterion("register <", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterLessThanOrEqualTo(String value) {
            addCriterion("register <=", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterLike(String value) {
            addCriterion("register like", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotLike(String value) {
            addCriterion("register not like", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterIn(List<String> values) {
            addCriterion("register in", values, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotIn(List<String> values) {
            addCriterion("register not in", values, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterBetween(String value1, String value2) {
            addCriterion("register between", value1, value2, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotBetween(String value1, String value2) {
            addCriterion("register not between", value1, value2, "register");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNull() {
            addCriterion("customer_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNotNull() {
            addCriterion("customer_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneEqualTo(String value) {
            addCriterion("customer_phone =", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotEqualTo(String value) {
            addCriterion("customer_phone <>", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThan(String value) {
            addCriterion("customer_phone >", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("customer_phone >=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThan(String value) {
            addCriterion("customer_phone <", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThanOrEqualTo(String value) {
            addCriterion("customer_phone <=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLike(String value) {
            addCriterion("customer_phone like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotLike(String value) {
            addCriterion("customer_phone not like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIn(List<String> values) {
            addCriterion("customer_phone in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotIn(List<String> values) {
            addCriterion("customer_phone not in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneBetween(String value1, String value2) {
            addCriterion("customer_phone between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotBetween(String value1, String value2) {
            addCriterion("customer_phone not between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCalIsNull() {
            addCriterion("customer_cal is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCalIsNotNull() {
            addCriterion("customer_cal is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCalEqualTo(String value) {
            addCriterion("customer_cal =", value, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalNotEqualTo(String value) {
            addCriterion("customer_cal <>", value, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalGreaterThan(String value) {
            addCriterion("customer_cal >", value, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalGreaterThanOrEqualTo(String value) {
            addCriterion("customer_cal >=", value, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalLessThan(String value) {
            addCriterion("customer_cal <", value, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalLessThanOrEqualTo(String value) {
            addCriterion("customer_cal <=", value, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalLike(String value) {
            addCriterion("customer_cal like", value, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalNotLike(String value) {
            addCriterion("customer_cal not like", value, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalIn(List<String> values) {
            addCriterion("customer_cal in", values, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalNotIn(List<String> values) {
            addCriterion("customer_cal not in", values, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalBetween(String value1, String value2) {
            addCriterion("customer_cal between", value1, value2, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerCalNotBetween(String value1, String value2) {
            addCriterion("customer_cal not between", value1, value2, "customerCal");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailIsNull() {
            addCriterion("customer_email is null");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailIsNotNull() {
            addCriterion("customer_email is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailEqualTo(String value) {
            addCriterion("customer_email =", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotEqualTo(String value) {
            addCriterion("customer_email <>", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailGreaterThan(String value) {
            addCriterion("customer_email >", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("customer_email >=", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailLessThan(String value) {
            addCriterion("customer_email <", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailLessThanOrEqualTo(String value) {
            addCriterion("customer_email <=", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailLike(String value) {
            addCriterion("customer_email like", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotLike(String value) {
            addCriterion("customer_email not like", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailIn(List<String> values) {
            addCriterion("customer_email in", values, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotIn(List<String> values) {
            addCriterion("customer_email not in", values, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailBetween(String value1, String value2) {
            addCriterion("customer_email between", value1, value2, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotBetween(String value1, String value2) {
            addCriterion("customer_email not between", value1, value2, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIsNull() {
            addCriterion("customer_qq is null");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIsNotNull() {
            addCriterion("customer_qq is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerQqEqualTo(String value) {
            addCriterion("customer_qq =", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotEqualTo(String value) {
            addCriterion("customer_qq <>", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqGreaterThan(String value) {
            addCriterion("customer_qq >", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqGreaterThanOrEqualTo(String value) {
            addCriterion("customer_qq >=", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLessThan(String value) {
            addCriterion("customer_qq <", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLessThanOrEqualTo(String value) {
            addCriterion("customer_qq <=", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLike(String value) {
            addCriterion("customer_qq like", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotLike(String value) {
            addCriterion("customer_qq not like", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIn(List<String> values) {
            addCriterion("customer_qq in", values, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotIn(List<String> values) {
            addCriterion("customer_qq not in", values, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqBetween(String value1, String value2) {
            addCriterion("customer_qq between", value1, value2, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotBetween(String value1, String value2) {
            addCriterion("customer_qq not between", value1, value2, "customerQq");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalIsNull() {
            addCriterion("company_legal is null");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalIsNotNull() {
            addCriterion("company_legal is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalEqualTo(String value) {
            addCriterion("company_legal =", value, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalNotEqualTo(String value) {
            addCriterion("company_legal <>", value, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalGreaterThan(String value) {
            addCriterion("company_legal >", value, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalGreaterThanOrEqualTo(String value) {
            addCriterion("company_legal >=", value, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalLessThan(String value) {
            addCriterion("company_legal <", value, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalLessThanOrEqualTo(String value) {
            addCriterion("company_legal <=", value, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalLike(String value) {
            addCriterion("company_legal like", value, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalNotLike(String value) {
            addCriterion("company_legal not like", value, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalIn(List<String> values) {
            addCriterion("company_legal in", values, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalNotIn(List<String> values) {
            addCriterion("company_legal not in", values, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalBetween(String value1, String value2) {
            addCriterion("company_legal between", value1, value2, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalNotBetween(String value1, String value2) {
            addCriterion("company_legal not between", value1, value2, "companyLegal");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyIsNull() {
            addCriterion("company_money is null");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyIsNotNull() {
            addCriterion("company_money is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyEqualTo(String value) {
            addCriterion("company_money =", value, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyNotEqualTo(String value) {
            addCriterion("company_money <>", value, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyGreaterThan(String value) {
            addCriterion("company_money >", value, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("company_money >=", value, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyLessThan(String value) {
            addCriterion("company_money <", value, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyLessThanOrEqualTo(String value) {
            addCriterion("company_money <=", value, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyLike(String value) {
            addCriterion("company_money like", value, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyNotLike(String value) {
            addCriterion("company_money not like", value, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyIn(List<String> values) {
            addCriterion("company_money in", values, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyNotIn(List<String> values) {
            addCriterion("company_money not in", values, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyBetween(String value1, String value2) {
            addCriterion("company_money between", value1, value2, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyMoneyNotBetween(String value1, String value2) {
            addCriterion("company_money not between", value1, value2, "companyMoney");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressIsNull() {
            addCriterion("company_regist_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressIsNotNull() {
            addCriterion("company_regist_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressEqualTo(String value) {
            addCriterion("company_regist_address =", value, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressNotEqualTo(String value) {
            addCriterion("company_regist_address <>", value, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressGreaterThan(String value) {
            addCriterion("company_regist_address >", value, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_regist_address >=", value, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressLessThan(String value) {
            addCriterion("company_regist_address <", value, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressLessThanOrEqualTo(String value) {
            addCriterion("company_regist_address <=", value, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressLike(String value) {
            addCriterion("company_regist_address like", value, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressNotLike(String value) {
            addCriterion("company_regist_address not like", value, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressIn(List<String> values) {
            addCriterion("company_regist_address in", values, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressNotIn(List<String> values) {
            addCriterion("company_regist_address not in", values, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressBetween(String value1, String value2) {
            addCriterion("company_regist_address between", value1, value2, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyRegistAddressNotBetween(String value1, String value2) {
            addCriterion("company_regist_address not between", value1, value2, "companyRegistAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("company_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("company_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("company_address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("company_address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("company_address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("company_address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("company_address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("company_address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("company_address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("company_address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("company_address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("company_address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("company_address not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyDateIsNull() {
            addCriterion("company_date is null");
            return (Criteria) this;
        }

        public Criteria andCompanyDateIsNotNull() {
            addCriterion("company_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyDateEqualTo(Date value) {
            addCriterion("company_date =", value, "companyDate");
            return (Criteria) this;
        }

        public Criteria andCompanyDateNotEqualTo(Date value) {
            addCriterion("company_date <>", value, "companyDate");
            return (Criteria) this;
        }

        public Criteria andCompanyDateGreaterThan(Date value) {
            addCriterion("company_date >", value, "companyDate");
            return (Criteria) this;
        }

        public Criteria andCompanyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("company_date >=", value, "companyDate");
            return (Criteria) this;
        }

        public Criteria andCompanyDateLessThan(Date value) {
            addCriterion("company_date <", value, "companyDate");
            return (Criteria) this;
        }

        public Criteria andCompanyDateLessThanOrEqualTo(Date value) {
            addCriterion("company_date <=", value, "companyDate");
            return (Criteria) this;
        }

        public Criteria andCompanyDateIn(List<Date> values) {
            addCriterion("company_date in", values, "companyDate");
            return (Criteria) this;
        }

        public Criteria andCompanyDateNotIn(List<Date> values) {
            addCriterion("company_date not in", values, "companyDate");
            return (Criteria) this;
        }

        public Criteria andCompanyDateBetween(Date value1, Date value2) {
            addCriterion("company_date between", value1, value2, "companyDate");
            return (Criteria) this;
        }

        public Criteria andCompanyDateNotBetween(Date value1, Date value2) {
            addCriterion("company_date not between", value1, value2, "companyDate");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayIsNull() {
            addCriterion("company_signday is null");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayIsNotNull() {
            addCriterion("company_signday is not null");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayEqualTo(Date value) {
            addCriterionForJDBCDate("company_signday =", value, "companySignday");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayNotEqualTo(Date value) {
            addCriterionForJDBCDate("company_signday <>", value, "companySignday");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayGreaterThan(Date value) {
            addCriterionForJDBCDate("company_signday >", value, "companySignday");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("company_signday >=", value, "companySignday");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayLessThan(Date value) {
            addCriterionForJDBCDate("company_signday <", value, "companySignday");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("company_signday <=", value, "companySignday");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayIn(List<Date> values) {
            addCriterionForJDBCDate("company_signday in", values, "companySignday");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayNotIn(List<Date> values) {
            addCriterionForJDBCDate("company_signday not in", values, "companySignday");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("company_signday between", value1, value2, "companySignday");
            return (Criteria) this;
        }

        public Criteria andCompanySigndayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("company_signday not between", value1, value2, "companySignday");
            return (Criteria) this;
        }

        public Criteria andSafeIdIsNull() {
            addCriterion("safe_id is null");
            return (Criteria) this;
        }

        public Criteria andSafeIdIsNotNull() {
            addCriterion("safe_id is not null");
            return (Criteria) this;
        }

        public Criteria andSafeIdEqualTo(Integer value) {
            addCriterion("safe_id =", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdNotEqualTo(Integer value) {
            addCriterion("safe_id <>", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdGreaterThan(Integer value) {
            addCriterion("safe_id >", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("safe_id >=", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdLessThan(Integer value) {
            addCriterion("safe_id <", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdLessThanOrEqualTo(Integer value) {
            addCriterion("safe_id <=", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdIn(List<Integer> values) {
            addCriterion("safe_id in", values, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdNotIn(List<Integer> values) {
            addCriterion("safe_id not in", values, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdBetween(Integer value1, Integer value2) {
            addCriterion("safe_id between", value1, value2, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("safe_id not between", value1, value2, "safeId");
            return (Criteria) this;
        }

        public Criteria andSuccessDataIsNull() {
            addCriterion("success_data is null");
            return (Criteria) this;
        }

        public Criteria andSuccessDataIsNotNull() {
            addCriterion("success_data is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessDataEqualTo(Date value) {
            addCriterionForJDBCDate("success_data =", value, "successData");
            return (Criteria) this;
        }

        public Criteria andSuccessDataNotEqualTo(Date value) {
            addCriterionForJDBCDate("success_data <>", value, "successData");
            return (Criteria) this;
        }

        public Criteria andSuccessDataGreaterThan(Date value) {
            addCriterionForJDBCDate("success_data >", value, "successData");
            return (Criteria) this;
        }

        public Criteria andSuccessDataGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("success_data >=", value, "successData");
            return (Criteria) this;
        }

        public Criteria andSuccessDataLessThan(Date value) {
            addCriterionForJDBCDate("success_data <", value, "successData");
            return (Criteria) this;
        }

        public Criteria andSuccessDataLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("success_data <=", value, "successData");
            return (Criteria) this;
        }

        public Criteria andSuccessDataIn(List<Date> values) {
            addCriterionForJDBCDate("success_data in", values, "successData");
            return (Criteria) this;
        }

        public Criteria andSuccessDataNotIn(List<Date> values) {
            addCriterionForJDBCDate("success_data not in", values, "successData");
            return (Criteria) this;
        }

        public Criteria andSuccessDataBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("success_data between", value1, value2, "successData");
            return (Criteria) this;
        }

        public Criteria andSuccessDataNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("success_data not between", value1, value2, "successData");
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