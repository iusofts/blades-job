package com.iusofts.blades.job.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleJobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitSize = -1;

    public ScheduleJobExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitSize(int limitSize) {
        this.limitSize=limitSize;
    }

    public int getLimitSize() {
        return limitSize;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSysCodeIsNull() {
            addCriterion("sys_code is null");
            return (Criteria) this;
        }

        public Criteria andSysCodeIsNotNull() {
            addCriterion("sys_code is not null");
            return (Criteria) this;
        }

        public Criteria andSysCodeEqualTo(String value) {
            addCriterion("sys_code =", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotEqualTo(String value) {
            addCriterion("sys_code <>", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeGreaterThan(String value) {
            addCriterion("sys_code >", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_code >=", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLessThan(String value) {
            addCriterion("sys_code <", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLessThanOrEqualTo(String value) {
            addCriterion("sys_code <=", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLike(String value) {
            addCriterion("sys_code like", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotLike(String value) {
            addCriterion("sys_code not like", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeIn(List<String> values) {
            addCriterion("sys_code in", values, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotIn(List<String> values) {
            addCriterion("sys_code not in", values, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeBetween(String value1, String value2) {
            addCriterion("sys_code between", value1, value2, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotBetween(String value1, String value2) {
            addCriterion("sys_code not between", value1, value2, "sysCode");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNull() {
            addCriterion("job_type is null");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNotNull() {
            addCriterion("job_type is not null");
            return (Criteria) this;
        }

        public Criteria andJobTypeEqualTo(Integer value) {
            addCriterion("job_type =", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotEqualTo(Integer value) {
            addCriterion("job_type <>", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThan(Integer value) {
            addCriterion("job_type >", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_type >=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThan(Integer value) {
            addCriterion("job_type <", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThanOrEqualTo(Integer value) {
            addCriterion("job_type <=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeIn(List<Integer> values) {
            addCriterion("job_type in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotIn(List<Integer> values) {
            addCriterion("job_type not in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeBetween(Integer value1, Integer value2) {
            addCriterion("job_type between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("job_type not between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andAliasNameIsNull() {
            addCriterion("alias_name is null");
            return (Criteria) this;
        }

        public Criteria andAliasNameIsNotNull() {
            addCriterion("alias_name is not null");
            return (Criteria) this;
        }

        public Criteria andAliasNameEqualTo(String value) {
            addCriterion("alias_name =", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotEqualTo(String value) {
            addCriterion("alias_name <>", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameGreaterThan(String value) {
            addCriterion("alias_name >", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameGreaterThanOrEqualTo(String value) {
            addCriterion("alias_name >=", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLessThan(String value) {
            addCriterion("alias_name <", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLessThanOrEqualTo(String value) {
            addCriterion("alias_name <=", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLike(String value) {
            addCriterion("alias_name like", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotLike(String value) {
            addCriterion("alias_name not like", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameIn(List<String> values) {
            addCriterion("alias_name in", values, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotIn(List<String> values) {
            addCriterion("alias_name not in", values, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameBetween(String value1, String value2) {
            addCriterion("alias_name between", value1, value2, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotBetween(String value1, String value2) {
            addCriterion("alias_name not between", value1, value2, "aliasName");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNull() {
            addCriterion("job_group is null");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNotNull() {
            addCriterion("job_group is not null");
            return (Criteria) this;
        }

        public Criteria andJobGroupEqualTo(String value) {
            addCriterion("job_group =", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotEqualTo(String value) {
            addCriterion("job_group <>", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThan(String value) {
            addCriterion("job_group >", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThanOrEqualTo(String value) {
            addCriterion("job_group >=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThan(String value) {
            addCriterion("job_group <", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThanOrEqualTo(String value) {
            addCriterion("job_group <=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLike(String value) {
            addCriterion("job_group like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotLike(String value) {
            addCriterion("job_group not like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupIn(List<String> values) {
            addCriterion("job_group in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotIn(List<String> values) {
            addCriterion("job_group not in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupBetween(String value1, String value2) {
            addCriterion("job_group between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotBetween(String value1, String value2) {
            addCriterion("job_group not between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobTriggerIsNull() {
            addCriterion("job_trigger is null");
            return (Criteria) this;
        }

        public Criteria andJobTriggerIsNotNull() {
            addCriterion("job_trigger is not null");
            return (Criteria) this;
        }

        public Criteria andJobTriggerEqualTo(String value) {
            addCriterion("job_trigger =", value, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerNotEqualTo(String value) {
            addCriterion("job_trigger <>", value, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerGreaterThan(String value) {
            addCriterion("job_trigger >", value, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerGreaterThanOrEqualTo(String value) {
            addCriterion("job_trigger >=", value, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerLessThan(String value) {
            addCriterion("job_trigger <", value, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerLessThanOrEqualTo(String value) {
            addCriterion("job_trigger <=", value, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerLike(String value) {
            addCriterion("job_trigger like", value, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerNotLike(String value) {
            addCriterion("job_trigger not like", value, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerIn(List<String> values) {
            addCriterion("job_trigger in", values, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerNotIn(List<String> values) {
            addCriterion("job_trigger not in", values, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerBetween(String value1, String value2) {
            addCriterion("job_trigger between", value1, value2, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andJobTriggerNotBetween(String value1, String value2) {
            addCriterion("job_trigger not between", value1, value2, "jobTrigger");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNull() {
            addCriterion("cron_expression is null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNotNull() {
            addCriterion("cron_expression is not null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionEqualTo(String value) {
            addCriterion("cron_expression =", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotEqualTo(String value) {
            addCriterion("cron_expression <>", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThan(String value) {
            addCriterion("cron_expression >", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThanOrEqualTo(String value) {
            addCriterion("cron_expression >=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThan(String value) {
            addCriterion("cron_expression <", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThanOrEqualTo(String value) {
            addCriterion("cron_expression <=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLike(String value) {
            addCriterion("cron_expression like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotLike(String value) {
            addCriterion("cron_expression not like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIn(List<String> values) {
            addCriterion("cron_expression in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotIn(List<String> values) {
            addCriterion("cron_expression not in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionBetween(String value1, String value2) {
            addCriterion("cron_expression between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotBetween(String value1, String value2) {
            addCriterion("cron_expression not between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIsNull() {
            addCriterion("execute_time is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIsNotNull() {
            addCriterion("execute_time is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeEqualTo(Date value) {
            addCriterion("execute_time =", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotEqualTo(Date value) {
            addCriterion("execute_time <>", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeGreaterThan(Date value) {
            addCriterion("execute_time >", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("execute_time >=", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeLessThan(Date value) {
            addCriterion("execute_time <", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeLessThanOrEqualTo(Date value) {
            addCriterion("execute_time <=", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIn(List<Date> values) {
            addCriterion("execute_time in", values, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotIn(List<Date> values) {
            addCriterion("execute_time not in", values, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeBetween(Date value1, Date value2) {
            addCriterion("execute_time between", value1, value2, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotBetween(Date value1, Date value2) {
            addCriterion("execute_time not between", value1, value2, "executeTime");
            return (Criteria) this;
        }

        public Criteria andIsSyncIsNull() {
            addCriterion("is_sync is null");
            return (Criteria) this;
        }

        public Criteria andIsSyncIsNotNull() {
            addCriterion("is_sync is not null");
            return (Criteria) this;
        }

        public Criteria andIsSyncEqualTo(Integer value) {
            addCriterion("is_sync =", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotEqualTo(Integer value) {
            addCriterion("is_sync <>", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncGreaterThan(Integer value) {
            addCriterion("is_sync >", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sync >=", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncLessThan(Integer value) {
            addCriterion("is_sync <", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncLessThanOrEqualTo(Integer value) {
            addCriterion("is_sync <=", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncIn(List<Integer> values) {
            addCriterion("is_sync in", values, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotIn(List<Integer> values) {
            addCriterion("is_sync not in", values, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncBetween(Integer value1, Integer value2) {
            addCriterion("is_sync between", value1, value2, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sync not between", value1, value2, "isSync");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andRequestParamIsNull() {
            addCriterion("request_param is null");
            return (Criteria) this;
        }

        public Criteria andRequestParamIsNotNull() {
            addCriterion("request_param is not null");
            return (Criteria) this;
        }

        public Criteria andRequestParamEqualTo(String value) {
            addCriterion("request_param =", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotEqualTo(String value) {
            addCriterion("request_param <>", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamGreaterThan(String value) {
            addCriterion("request_param >", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamGreaterThanOrEqualTo(String value) {
            addCriterion("request_param >=", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamLessThan(String value) {
            addCriterion("request_param <", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamLessThanOrEqualTo(String value) {
            addCriterion("request_param <=", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamLike(String value) {
            addCriterion("request_param like", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotLike(String value) {
            addCriterion("request_param not like", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamIn(List<String> values) {
            addCriterion("request_param in", values, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotIn(List<String> values) {
            addCriterion("request_param not in", values, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamBetween(String value1, String value2) {
            addCriterion("request_param between", value1, value2, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotBetween(String value1, String value2) {
            addCriterion("request_param not between", value1, value2, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestMethodIsNull() {
            addCriterion("request_method is null");
            return (Criteria) this;
        }

        public Criteria andRequestMethodIsNotNull() {
            addCriterion("request_method is not null");
            return (Criteria) this;
        }

        public Criteria andRequestMethodEqualTo(String value) {
            addCriterion("request_method =", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodNotEqualTo(String value) {
            addCriterion("request_method <>", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodGreaterThan(String value) {
            addCriterion("request_method >", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodGreaterThanOrEqualTo(String value) {
            addCriterion("request_method >=", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodLessThan(String value) {
            addCriterion("request_method <", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodLessThanOrEqualTo(String value) {
            addCriterion("request_method <=", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodLike(String value) {
            addCriterion("request_method like", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodNotLike(String value) {
            addCriterion("request_method not like", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodIn(List<String> values) {
            addCriterion("request_method in", values, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodNotIn(List<String> values) {
            addCriterion("request_method not in", values, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodBetween(String value1, String value2) {
            addCriterion("request_method between", value1, value2, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodNotBetween(String value1, String value2) {
            addCriterion("request_method not between", value1, value2, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumIsNull() {
            addCriterion("max_retry_num is null");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumIsNotNull() {
            addCriterion("max_retry_num is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumEqualTo(Integer value) {
            addCriterion("max_retry_num =", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumNotEqualTo(Integer value) {
            addCriterion("max_retry_num <>", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumGreaterThan(Integer value) {
            addCriterion("max_retry_num >", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_retry_num >=", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumLessThan(Integer value) {
            addCriterion("max_retry_num <", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumLessThanOrEqualTo(Integer value) {
            addCriterion("max_retry_num <=", value, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumIn(List<Integer> values) {
            addCriterion("max_retry_num in", values, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumNotIn(List<Integer> values) {
            addCriterion("max_retry_num not in", values, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumBetween(Integer value1, Integer value2) {
            addCriterion("max_retry_num between", value1, value2, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andMaxRetryNumNotBetween(Integer value1, Integer value2) {
            addCriterion("max_retry_num not between", value1, value2, "maxRetryNum");
            return (Criteria) this;
        }

        public Criteria andRetriedNumIsNull() {
            addCriterion("retried_num is null");
            return (Criteria) this;
        }

        public Criteria andRetriedNumIsNotNull() {
            addCriterion("retried_num is not null");
            return (Criteria) this;
        }

        public Criteria andRetriedNumEqualTo(Integer value) {
            addCriterion("retried_num =", value, "retriedNum");
            return (Criteria) this;
        }

        public Criteria andRetriedNumNotEqualTo(Integer value) {
            addCriterion("retried_num <>", value, "retriedNum");
            return (Criteria) this;
        }

        public Criteria andRetriedNumGreaterThan(Integer value) {
            addCriterion("retried_num >", value, "retriedNum");
            return (Criteria) this;
        }

        public Criteria andRetriedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("retried_num >=", value, "retriedNum");
            return (Criteria) this;
        }

        public Criteria andRetriedNumLessThan(Integer value) {
            addCriterion("retried_num <", value, "retriedNum");
            return (Criteria) this;
        }

        public Criteria andRetriedNumLessThanOrEqualTo(Integer value) {
            addCriterion("retried_num <=", value, "retriedNum");
            return (Criteria) this;
        }

        public Criteria andRetriedNumIn(List<Integer> values) {
            addCriterion("retried_num in", values, "retriedNum");
            return (Criteria) this;
        }

        public Criteria andRetriedNumNotIn(List<Integer> values) {
            addCriterion("retried_num not in", values, "retriedNum");
            return (Criteria) this;
        }

        public Criteria andRetriedNumBetween(Integer value1, Integer value2) {
            addCriterion("retried_num between", value1, value2, "retriedNum");
            return (Criteria) this;
        }

        public Criteria andRetriedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("retried_num not between", value1, value2, "retriedNum");
            return (Criteria) this;
        }

        public Criteria andRetryStatusIsNull() {
            addCriterion("retry_status is null");
            return (Criteria) this;
        }

        public Criteria andRetryStatusIsNotNull() {
            addCriterion("retry_status is not null");
            return (Criteria) this;
        }

        public Criteria andRetryStatusEqualTo(Integer value) {
            addCriterion("retry_status =", value, "retryStatus");
            return (Criteria) this;
        }

        public Criteria andRetryStatusNotEqualTo(Integer value) {
            addCriterion("retry_status <>", value, "retryStatus");
            return (Criteria) this;
        }

        public Criteria andRetryStatusGreaterThan(Integer value) {
            addCriterion("retry_status >", value, "retryStatus");
            return (Criteria) this;
        }

        public Criteria andRetryStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("retry_status >=", value, "retryStatus");
            return (Criteria) this;
        }

        public Criteria andRetryStatusLessThan(Integer value) {
            addCriterion("retry_status <", value, "retryStatus");
            return (Criteria) this;
        }

        public Criteria andRetryStatusLessThanOrEqualTo(Integer value) {
            addCriterion("retry_status <=", value, "retryStatus");
            return (Criteria) this;
        }

        public Criteria andRetryStatusIn(List<Integer> values) {
            addCriterion("retry_status in", values, "retryStatus");
            return (Criteria) this;
        }

        public Criteria andRetryStatusNotIn(List<Integer> values) {
            addCriterion("retry_status not in", values, "retryStatus");
            return (Criteria) this;
        }

        public Criteria andRetryStatusBetween(Integer value1, Integer value2) {
            addCriterion("retry_status between", value1, value2, "retryStatus");
            return (Criteria) this;
        }

        public Criteria andRetryStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("retry_status not between", value1, value2, "retryStatus");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumIsNull() {
            addCriterion("total_run_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumIsNotNull() {
            addCriterion("total_run_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumEqualTo(Integer value) {
            addCriterion("total_run_num =", value, "totalRunNum");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumNotEqualTo(Integer value) {
            addCriterion("total_run_num <>", value, "totalRunNum");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumGreaterThan(Integer value) {
            addCriterion("total_run_num >", value, "totalRunNum");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_run_num >=", value, "totalRunNum");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumLessThan(Integer value) {
            addCriterion("total_run_num <", value, "totalRunNum");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_run_num <=", value, "totalRunNum");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumIn(List<Integer> values) {
            addCriterion("total_run_num in", values, "totalRunNum");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumNotIn(List<Integer> values) {
            addCriterion("total_run_num not in", values, "totalRunNum");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumBetween(Integer value1, Integer value2) {
            addCriterion("total_run_num between", value1, value2, "totalRunNum");
            return (Criteria) this;
        }

        public Criteria andTotalRunNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_run_num not between", value1, value2, "totalRunNum");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumIsNull() {
            addCriterion("total_failed_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumIsNotNull() {
            addCriterion("total_failed_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumEqualTo(Integer value) {
            addCriterion("total_failed_num =", value, "totalFailedNum");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumNotEqualTo(Integer value) {
            addCriterion("total_failed_num <>", value, "totalFailedNum");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumGreaterThan(Integer value) {
            addCriterion("total_failed_num >", value, "totalFailedNum");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_failed_num >=", value, "totalFailedNum");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumLessThan(Integer value) {
            addCriterion("total_failed_num <", value, "totalFailedNum");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_failed_num <=", value, "totalFailedNum");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumIn(List<Integer> values) {
            addCriterion("total_failed_num in", values, "totalFailedNum");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumNotIn(List<Integer> values) {
            addCriterion("total_failed_num not in", values, "totalFailedNum");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumBetween(Integer value1, Integer value2) {
            addCriterion("total_failed_num between", value1, value2, "totalFailedNum");
            return (Criteria) this;
        }

        public Criteria andTotalFailedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_failed_num not between", value1, value2, "totalFailedNum");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeIsNull() {
            addCriterion("last_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeIsNotNull() {
            addCriterion("last_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeEqualTo(Date value) {
            addCriterion("last_start_time =", value, "lastStartTime");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeNotEqualTo(Date value) {
            addCriterion("last_start_time <>", value, "lastStartTime");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeGreaterThan(Date value) {
            addCriterion("last_start_time >", value, "lastStartTime");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_start_time >=", value, "lastStartTime");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeLessThan(Date value) {
            addCriterion("last_start_time <", value, "lastStartTime");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_start_time <=", value, "lastStartTime");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeIn(List<Date> values) {
            addCriterion("last_start_time in", values, "lastStartTime");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeNotIn(List<Date> values) {
            addCriterion("last_start_time not in", values, "lastStartTime");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeBetween(Date value1, Date value2) {
            addCriterion("last_start_time between", value1, value2, "lastStartTime");
            return (Criteria) this;
        }

        public Criteria andLastStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_start_time not between", value1, value2, "lastStartTime");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeIsNull() {
            addCriterion("last_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeIsNotNull() {
            addCriterion("last_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeEqualTo(Date value) {
            addCriterion("last_end_time =", value, "lastEndTime");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeNotEqualTo(Date value) {
            addCriterion("last_end_time <>", value, "lastEndTime");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeGreaterThan(Date value) {
            addCriterion("last_end_time >", value, "lastEndTime");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_end_time >=", value, "lastEndTime");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeLessThan(Date value) {
            addCriterion("last_end_time <", value, "lastEndTime");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_end_time <=", value, "lastEndTime");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeIn(List<Date> values) {
            addCriterion("last_end_time in", values, "lastEndTime");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeNotIn(List<Date> values) {
            addCriterion("last_end_time not in", values, "lastEndTime");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeBetween(Date value1, Date value2) {
            addCriterion("last_end_time between", value1, value2, "lastEndTime");
            return (Criteria) this;
        }

        public Criteria andLastEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_end_time not between", value1, value2, "lastEndTime");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeIsNull() {
            addCriterion("next_fire_time is null");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeIsNotNull() {
            addCriterion("next_fire_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeEqualTo(Long value) {
            addCriterion("next_fire_time =", value, "nextFireTime");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeNotEqualTo(Long value) {
            addCriterion("next_fire_time <>", value, "nextFireTime");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeGreaterThan(Long value) {
            addCriterion("next_fire_time >", value, "nextFireTime");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("next_fire_time >=", value, "nextFireTime");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeLessThan(Long value) {
            addCriterion("next_fire_time <", value, "nextFireTime");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeLessThanOrEqualTo(Long value) {
            addCriterion("next_fire_time <=", value, "nextFireTime");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeIn(List<Long> values) {
            addCriterion("next_fire_time in", values, "nextFireTime");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeNotIn(List<Long> values) {
            addCriterion("next_fire_time not in", values, "nextFireTime");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeBetween(Long value1, Long value2) {
            addCriterion("next_fire_time between", value1, value2, "nextFireTime");
            return (Criteria) this;
        }

        public Criteria andNextFireTimeNotBetween(Long value1, Long value2) {
            addCriterion("next_fire_time not between", value1, value2, "nextFireTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
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