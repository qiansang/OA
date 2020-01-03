package com.bonc.oa.wanda.dao;

import com.bonc.oa.wanda.bean.CustomerSource;
import com.bonc.oa.wanda.bean.CustomerSourceExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CustomerSourceMapper {

    @Select({
            "select",
            "name",
            "from customer_source",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    String selectNameById(Integer id);

    @Select({
            "select",
            "id, name",
            "from customer_source",
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<CustomerSource> selectAll();

    @SelectProvider(type=CustomerSourceSqlProvider.class, method="countByExample")
    long countByExample(CustomerSourceExample example);

    @DeleteProvider(type=CustomerSourceSqlProvider.class, method="deleteByExample")
    int deleteByExample(CustomerSourceExample example);

    @Delete({
        "delete from customer_source",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into customer_source (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(CustomerSource record);

    @InsertProvider(type=CustomerSourceSqlProvider.class, method="insertSelective")
    int insertSelective(CustomerSource record);

    @SelectProvider(type=CustomerSourceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<CustomerSource> selectByExample(CustomerSourceExample example);

    @Select({
        "select",
        "id, name",
        "from customer_source",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    CustomerSource selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CustomerSourceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CustomerSource record, @Param("example") CustomerSourceExample example);

    @UpdateProvider(type=CustomerSourceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CustomerSource record, @Param("example") CustomerSourceExample example);

    @UpdateProvider(type=CustomerSourceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CustomerSource record);

    @Update({
        "update customer_source",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CustomerSource record);

}