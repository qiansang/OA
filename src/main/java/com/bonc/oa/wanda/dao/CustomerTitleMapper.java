package com.bonc.oa.wanda.dao;

import com.bonc.oa.wanda.bean.CustomerTitle;
import com.bonc.oa.wanda.bean.CustomerTitleExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CustomerTitleMapper {

    @Select({
            "select",
            "name",
            "from customer_title",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    String selectById(Integer id);

    @Select({
            "select",
            "id, name",
            "from customer_title",
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<CustomerTitle> selectAll();

    @SelectProvider(type=CustomerTitleSqlProvider.class, method="countByExample")
    long countByExample(CustomerTitleExample example);

    @DeleteProvider(type=CustomerTitleSqlProvider.class, method="deleteByExample")
    int deleteByExample(CustomerTitleExample example);

    @Delete({
        "delete from customer_title",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into customer_title (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(CustomerTitle record);

    @InsertProvider(type=CustomerTitleSqlProvider.class, method="insertSelective")
    int insertSelective(CustomerTitle record);

    @SelectProvider(type=CustomerTitleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<CustomerTitle> selectByExample(CustomerTitleExample example);

    @Select({
        "select",
        "id, name",
        "from customer_title",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    CustomerTitle selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CustomerTitleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CustomerTitle record, @Param("example") CustomerTitleExample example);

    @UpdateProvider(type=CustomerTitleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CustomerTitle record, @Param("example") CustomerTitleExample example);

    @UpdateProvider(type=CustomerTitleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CustomerTitle record);

    @Update({
        "update customer_title",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CustomerTitle record);

}