package com.bonc.oa.wanda.dao;

import com.bonc.oa.wanda.bean.CustomerIdea;
import com.bonc.oa.wanda.bean.CustomerIdeaExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CustomerIdeaMapper {

    @Select({
            "select",
            "name",
            "from customer_idea",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    String selectById(Integer id);

    @Select({
            "select",
            "id, name",
            "from customer_idea",
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<CustomerIdea> selectAll();

    @SelectProvider(type=CustomerIdeaSqlProvider.class, method="countByExample")
    long countByExample(CustomerIdeaExample example);

    @DeleteProvider(type=CustomerIdeaSqlProvider.class, method="deleteByExample")
    int deleteByExample(CustomerIdeaExample example);

    @Delete({
        "delete from customer_idea",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into customer_idea (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(CustomerIdea record);

    @InsertProvider(type=CustomerIdeaSqlProvider.class, method="insertSelective")
    int insertSelective(CustomerIdea record);

    @SelectProvider(type=CustomerIdeaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<CustomerIdea> selectByExample(CustomerIdeaExample example);

    @Select({
        "select",
        "id, name",
        "from customer_idea",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    CustomerIdea selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CustomerIdeaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CustomerIdea record, @Param("example") CustomerIdeaExample example);

    @UpdateProvider(type=CustomerIdeaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CustomerIdea record, @Param("example") CustomerIdeaExample example);

    @UpdateProvider(type=CustomerIdeaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CustomerIdea record);

    @Update({
        "update customer_idea",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CustomerIdea record);

}