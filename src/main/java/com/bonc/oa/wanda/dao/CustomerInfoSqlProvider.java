package com.bonc.oa.wanda.dao;

import com.bonc.oa.wanda.bean.CustomerInfo;
import com.bonc.oa.wanda.bean.CustomerInfoExample.Criteria;
import com.bonc.oa.wanda.bean.CustomerInfoExample.Criterion;
import com.bonc.oa.wanda.bean.CustomerInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CustomerInfoSqlProvider {

    public String countByExample(CustomerInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("customer_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CustomerInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("customer_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CustomerInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("customer_info");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getIdeaId() != null) {
            sql.VALUES("idea_id", "#{ideaId,jdbcType=INTEGER}");
        }
        
        if (record.getSourceId() != null) {
            sql.VALUES("source_id", "#{sourceId,jdbcType=INTEGER}");
        }
        
        if (record.getTitleId() != null) {
            sql.VALUES("title_id", "#{titleId,jdbcType=INTEGER}");
        }
        
        if (record.getProfessionId() != null) {
            sql.VALUES("profession_id", "#{professionId,jdbcType=INTEGER}");
        }
        
        if (record.getRegister() != null) {
            sql.VALUES("register", "#{register,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.VALUES("update_date", "#{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerName() != null) {
            sql.VALUES("customer_name", "#{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerPhone() != null) {
            sql.VALUES("customer_phone", "#{customerPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerCal() != null) {
            sql.VALUES("customer_cal", "#{customerCal,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerEmail() != null) {
            sql.VALUES("customer_email", "#{customerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerQq() != null) {
            sql.VALUES("customer_qq", "#{customerQq,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.VALUES("detail", "#{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            sql.VALUES("company_name", "#{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyLegal() != null) {
            sql.VALUES("company_legal", "#{companyLegal,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyMoney() != null) {
            sql.VALUES("company_money", "#{companyMoney,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyRegistAddress() != null) {
            sql.VALUES("company_regist_address", "#{companyRegistAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyAddress() != null) {
            sql.VALUES("company_address", "#{companyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyDate() != null) {
            sql.VALUES("company_date", "#{companyDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCompanySignday() != null) {
            sql.VALUES("company_signday", "#{companySignday,jdbcType=DATE}");
        }
        
        if (record.getSafeId() != null) {
            sql.VALUES("safe_id", "#{safeId,jdbcType=INTEGER}");
        }
        
        if (record.getSuccessData() != null) {
            sql.VALUES("success_data", "#{successData,jdbcType=DATE}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CustomerInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("type");
        sql.SELECT("idea_id");
        sql.SELECT("source_id");
        sql.SELECT("title_id");
        sql.SELECT("profession_id");
        sql.SELECT("register");
        sql.SELECT("address");
        sql.SELECT("update_date");
        sql.SELECT("user_id");
        sql.SELECT("customer_name");
        sql.SELECT("customer_phone");
        sql.SELECT("customer_cal");
        sql.SELECT("customer_email");
        sql.SELECT("customer_qq");
        sql.SELECT("detail");
        sql.SELECT("company_name");
        sql.SELECT("company_legal");
        sql.SELECT("company_money");
        sql.SELECT("company_regist_address");
        sql.SELECT("company_address");
        sql.SELECT("company_date");
        sql.SELECT("company_signday");
        sql.SELECT("safe_id");
        sql.SELECT("success_data");
        sql.FROM("customer_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CustomerInfo record = (CustomerInfo) parameter.get("record");
        CustomerInfoExample example = (CustomerInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("customer_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getIdeaId() != null) {
            sql.SET("idea_id = #{record.ideaId,jdbcType=INTEGER}");
        }
        
        if (record.getSourceId() != null) {
            sql.SET("source_id = #{record.sourceId,jdbcType=INTEGER}");
        }
        
        if (record.getTitleId() != null) {
            sql.SET("title_id = #{record.titleId,jdbcType=INTEGER}");
        }
        
        if (record.getProfessionId() != null) {
            sql.SET("profession_id = #{record.professionId,jdbcType=INTEGER}");
        }
        
        if (record.getRegister() != null) {
            sql.SET("register = #{record.register,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerName() != null) {
            sql.SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerPhone() != null) {
            sql.SET("customer_phone = #{record.customerPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerCal() != null) {
            sql.SET("customer_cal = #{record.customerCal,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerEmail() != null) {
            sql.SET("customer_email = #{record.customerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerQq() != null) {
            sql.SET("customer_qq = #{record.customerQq,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{record.detail,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            sql.SET("company_name = #{record.companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyLegal() != null) {
            sql.SET("company_legal = #{record.companyLegal,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyMoney() != null) {
            sql.SET("company_money = #{record.companyMoney,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyRegistAddress() != null) {
            sql.SET("company_regist_address = #{record.companyRegistAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyAddress() != null) {
            sql.SET("company_address = #{record.companyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyDate() != null) {
            sql.SET("company_date = #{record.companyDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCompanySignday() != null) {
            sql.SET("company_signday = #{record.companySignday,jdbcType=DATE}");
        }
        
        if (record.getSafeId() != null) {
            sql.SET("safe_id = #{record.safeId,jdbcType=INTEGER}");
        }
        
        if (record.getSuccessData() != null) {
            sql.SET("success_data = #{record.successData,jdbcType=DATE}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("customer_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("idea_id = #{record.ideaId,jdbcType=INTEGER}");
        sql.SET("source_id = #{record.sourceId,jdbcType=INTEGER}");
        sql.SET("title_id = #{record.titleId,jdbcType=INTEGER}");
        sql.SET("profession_id = #{record.professionId,jdbcType=INTEGER}");
        sql.SET("register = #{record.register,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        sql.SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        sql.SET("customer_phone = #{record.customerPhone,jdbcType=VARCHAR}");
        sql.SET("customer_cal = #{record.customerCal,jdbcType=VARCHAR}");
        sql.SET("customer_email = #{record.customerEmail,jdbcType=VARCHAR}");
        sql.SET("customer_qq = #{record.customerQq,jdbcType=VARCHAR}");
        sql.SET("detail = #{record.detail,jdbcType=VARCHAR}");
        sql.SET("company_name = #{record.companyName,jdbcType=VARCHAR}");
        sql.SET("company_legal = #{record.companyLegal,jdbcType=VARCHAR}");
        sql.SET("company_money = #{record.companyMoney,jdbcType=VARCHAR}");
        sql.SET("company_regist_address = #{record.companyRegistAddress,jdbcType=VARCHAR}");
        sql.SET("company_address = #{record.companyAddress,jdbcType=VARCHAR}");
        sql.SET("company_date = #{record.companyDate,jdbcType=TIMESTAMP}");
        sql.SET("company_signday = #{record.companySignday,jdbcType=DATE}");
        sql.SET("safe_id = #{record.safeId,jdbcType=INTEGER}");
        sql.SET("success_data = #{record.successData,jdbcType=DATE}");
        
        CustomerInfoExample example = (CustomerInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CustomerInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("customer_info");
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getIdeaId() != null) {
            sql.SET("idea_id = #{ideaId,jdbcType=INTEGER}");
        }
        
        if (record.getSourceId() != null) {
            sql.SET("source_id = #{sourceId,jdbcType=INTEGER}");
        }
        
        if (record.getTitleId() != null) {
            sql.SET("title_id = #{titleId,jdbcType=INTEGER}");
        }
        
        if (record.getProfessionId() != null) {
            sql.SET("profession_id = #{professionId,jdbcType=INTEGER}");
        }
        
        if (record.getRegister() != null) {
            sql.SET("register = #{register,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.SET("update_date = #{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerName() != null) {
            sql.SET("customer_name = #{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerPhone() != null) {
            sql.SET("customer_phone = #{customerPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerCal() != null) {
            sql.SET("customer_cal = #{customerCal,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerEmail() != null) {
            sql.SET("customer_email = #{customerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerQq() != null) {
            sql.SET("customer_qq = #{customerQq,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            sql.SET("company_name = #{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyLegal() != null) {
            sql.SET("company_legal = #{companyLegal,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyMoney() != null) {
            sql.SET("company_money = #{companyMoney,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyRegistAddress() != null) {
            sql.SET("company_regist_address = #{companyRegistAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyAddress() != null) {
            sql.SET("company_address = #{companyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyDate() != null) {
            sql.SET("company_date = #{companyDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCompanySignday() != null) {
            sql.SET("company_signday = #{companySignday,jdbcType=DATE}");
        }
        
        if (record.getSafeId() != null) {
            sql.SET("safe_id = #{safeId,jdbcType=INTEGER}");
        }
        
        if (record.getSuccessData() != null) {
            sql.SET("success_data = #{successData,jdbcType=DATE}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CustomerInfoExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}