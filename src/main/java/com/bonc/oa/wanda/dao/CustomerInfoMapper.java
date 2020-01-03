package com.bonc.oa.wanda.dao;

import com.bonc.oa.wanda.bean.CustomerInfo;
import com.bonc.oa.wanda.bean.CustomerInfoExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

@Mapper
public interface CustomerInfoMapper {

    @Select({
            "select",
            "count(*)",
            "from customer_info",
    })
    int selectSum();

    @Select({
            "select",
            "max(id)",
            "from customer_info",
    })
    Integer selectMaxId();

    @Select({
            "select",
            "id",
            "from customer_info",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    List<CustomerInfo> selectAllByUserId(Integer userId);

    @SelectProvider(type=CustomerInfoSqlProvider.class, method="countByExample")
    long countByExample(CustomerInfoExample example);

    @DeleteProvider(type=CustomerInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(CustomerInfoExample example);

    @Delete({
        "delete from customer_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into customer_info (id, type, ",
        "idea_id, source_id, ",
        "title_id, profession_id, ",
        "register, address, ",
        "update_date, user_id, ",
        "customer_name, customer_phone, ",
        "customer_cal, customer_email, ",
        "customer_qq, detail, ",
        "company_name, company_legal, ",
        "company_money, company_regist_address, ",
        "company_address, company_date, ",
        "company_signday, safe_id, ",
        "success_data)",
        "values (#{id,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{ideaId,jdbcType=INTEGER}, #{sourceId,jdbcType=INTEGER}, ",
        "#{titleId,jdbcType=INTEGER}, #{professionId,jdbcType=INTEGER}, ",
        "#{register,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{updateDate,jdbcType=TIMESTAMP}, #{userId,jdbcType=INTEGER}, ",
        "#{customerName,jdbcType=VARCHAR}, #{customerPhone,jdbcType=VARCHAR}, ",
        "#{customerCal,jdbcType=VARCHAR}, #{customerEmail,jdbcType=VARCHAR}, ",
        "#{customerQq,jdbcType=VARCHAR}, #{detail,jdbcType=VARCHAR}, ",
        "#{companyName,jdbcType=VARCHAR}, #{companyLegal,jdbcType=VARCHAR}, ",
        "#{companyMoney,jdbcType=VARCHAR}, #{companyRegistAddress,jdbcType=VARCHAR}, ",
        "#{companyAddress,jdbcType=VARCHAR}, #{companyDate,jdbcType=TIMESTAMP}, ",
        "#{companySignday,jdbcType=DATE}, #{safeId,jdbcType=INTEGER}, ",
        "#{successData,jdbcType=DATE})"
    })
    int insert(CustomerInfo record);

    @InsertProvider(type=CustomerInfoSqlProvider.class, method="insertSelective")
    int insertSelective(CustomerInfo record);

    @SelectProvider(type=CustomerInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="idea_id", property="ideaId", jdbcType=JdbcType.INTEGER),
        @Result(column="source_id", property="sourceId", jdbcType=JdbcType.INTEGER),
        @Result(column="title_id", property="titleId", jdbcType=JdbcType.INTEGER),
        @Result(column="profession_id", property="professionId", jdbcType=JdbcType.INTEGER),
        @Result(column="register", property="register", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_phone", property="customerPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_cal", property="customerCal", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_email", property="customerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_qq", property="customerQq", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_legal", property="companyLegal", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_money", property="companyMoney", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_regist_address", property="companyRegistAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_address", property="companyAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_date", property="companyDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="company_signday", property="companySignday", jdbcType=JdbcType.DATE),
        @Result(column="safe_id", property="safeId", jdbcType=JdbcType.INTEGER),
        @Result(column="success_data", property="successData", jdbcType=JdbcType.DATE)
    })
    List<CustomerInfo> selectByExample(CustomerInfoExample example);

    @Select({
        "select",
        "id, type, idea_id, source_id, title_id, profession_id, register, address, update_date, ",
        "user_id, customer_name, customer_phone, customer_cal, customer_email, customer_qq, ",
        "detail, company_name, company_legal, company_money, company_regist_address, ",
        "company_address, company_date, company_signday, safe_id, success_data",
        "from customer_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="idea_id", property="ideaId", jdbcType=JdbcType.INTEGER),
        @Result(column="source_id", property="sourceId", jdbcType=JdbcType.INTEGER),
        @Result(column="title_id", property="titleId", jdbcType=JdbcType.INTEGER),
        @Result(column="profession_id", property="professionId", jdbcType=JdbcType.INTEGER),
        @Result(column="register", property="register", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_phone", property="customerPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_cal", property="customerCal", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_email", property="customerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_qq", property="customerQq", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_legal", property="companyLegal", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_money", property="companyMoney", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_regist_address", property="companyRegistAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_address", property="companyAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_date", property="companyDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="company_signday", property="companySignday", jdbcType=JdbcType.DATE),
        @Result(column="safe_id", property="safeId", jdbcType=JdbcType.INTEGER),
        @Result(column="success_data", property="successData", jdbcType=JdbcType.DATE)
    })
    CustomerInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CustomerInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    @UpdateProvider(type=CustomerInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    @UpdateProvider(type=CustomerInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CustomerInfo record);

    @Update({
        "update customer_info",
        "set type = #{type,jdbcType=INTEGER},",
          "idea_id = #{ideaId,jdbcType=INTEGER},",
          "source_id = #{sourceId,jdbcType=INTEGER},",
          "title_id = #{titleId,jdbcType=INTEGER},",
          "profession_id = #{professionId,jdbcType=INTEGER},",
          "register = #{register,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "customer_name = #{customerName,jdbcType=VARCHAR},",
          "customer_phone = #{customerPhone,jdbcType=VARCHAR},",
          "customer_cal = #{customerCal,jdbcType=VARCHAR},",
          "customer_email = #{customerEmail,jdbcType=VARCHAR},",
          "customer_qq = #{customerQq,jdbcType=VARCHAR},",
          "detail = #{detail,jdbcType=VARCHAR},",
          "company_name = #{companyName,jdbcType=VARCHAR},",
          "company_legal = #{companyLegal,jdbcType=VARCHAR},",
          "company_money = #{companyMoney,jdbcType=VARCHAR},",
          "company_regist_address = #{companyRegistAddress,jdbcType=VARCHAR},",
          "company_address = #{companyAddress,jdbcType=VARCHAR},",
          "company_date = #{companyDate,jdbcType=TIMESTAMP},",
          "company_signday = #{companySignday,jdbcType=DATE},",
          "safe_id = #{safeId,jdbcType=INTEGER},",
          "success_data = #{successData,jdbcType=DATE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CustomerInfo record);

    @Update({
            "update customer_info",
            "set detail = #{detail,jdbcType=VARCHAR},",
            "update_date = #{updateDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateDetailById(@Param("id") Integer id, @Param("detail") String detail, @Param("updateDate") Date updateDate);

    @Update({
            "update customer_info",
            "set title_id = #{titleId,jdbcType=INTEGER},",
            "profession_id = #{professionId,jdbcType=INTEGER},",
            "update_date = #{updateDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateProfessionById(@Param("id") Integer id, @Param("titleId") int titleId, @Param("professionId") int professionId, @Param("updateDate") Date updateDate);

    @Update({
            "update customer_info",
            "set customer_name = #{customerName,jdbcType=VARCHAR},",
            "customer_phone = #{customerPhone,jdbcType=VARCHAR},",
            "customer_cal = #{customerCal,jdbcType=VARCHAR},",
            "customer_email = #{customerEmail,jdbcType=VARCHAR},",
            "update_date = #{updateDate,jdbcType=TIMESTAMP},",
            "customer_qq = #{customerQq,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updatePhoneInfo(CustomerInfo customerInfo);

    @Update({
            "update customer_info",
            "set company_name = #{companyName,jdbcType=VARCHAR},",
            "company_legal = #{companyLegal,jdbcType=VARCHAR},",
            "company_money = #{companyMoney,jdbcType=VARCHAR},",
            "company_regist_address = #{companyRegistAddress,jdbcType=VARCHAR},",
            "company_address = #{companyAddress,jdbcType=VARCHAR},",
            "company_date = #{companyDate,jdbcType=TIMESTAMP},",
            "company_signday = #{companySignday,jdbcType=DATE},",
            "update_date = #{updateDate,jdbcType=TIMESTAMP},",
            "safe_id = #{safeId,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateCompanyInfo(CustomerInfo customerInfo);

    @Update({
            "update customer_info",
            "set address = #{address,jdbcType=VARCHAR},",
            "update_date = #{updateDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateAddress(@Param("id") Integer id, @Param("address") String address, @Param("updateDate") Date updateDate);

    @Update({
            "update customer_info",
            "set idea_id = #{ideaId,jdbcType=INTEGER},",
            "update_date = #{updateDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateCustomerIdea(@Param("id") Integer id, @Param("ideaId") Integer ideaId, @Param("updateDate") Date updateDate);

    @Update({
            "update customer_info",
            "set source_id = #{sourceId,jdbcType=INTEGER},",
            "update_date = #{updateDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateCustomerSource(@Param("id") Integer id, @Param("sourceId") Integer sourceId, @Param("updateDate") Date updateDate);

    @Update({
            "update customer_info",
            "set register = #{register,jdbcType=VARCHAR},",
            "update_date = #{updateDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateCustomerRegister(@Param("id") Integer id, @Param("register") String register, @Param("updateDate") Date updateDate);

    @Update({
            "update customer_info",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "update_date = #{updateDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int changeUserToCustomer(@Param("id") Integer id, @Param("userId") Integer userId, @Param("updateDate") Date updateDate);

    @Update({
            "update customer_info",
            "set update_date = #{updateDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateUpdateDate(@Param("id") Integer id, @Param("updateDate") Date updateDate);

    @Delete({
            "delete from customer_info",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByIdList(Integer id);
}