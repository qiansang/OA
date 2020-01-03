package com.bonc.oa.wanda.dao;

import com.bonc.oa.wanda.bean.Safe;
import com.bonc.oa.wanda.bean.SafeExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface SafeMapper {

    @Select({
            "select",
            "id, name",
            "from safe",
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Safe> selectAll();

    @SelectProvider(type=SafeSqlProvider.class, method="countByExample")
    long countByExample(SafeExample example);

    @DeleteProvider(type=SafeSqlProvider.class, method="deleteByExample")
    int deleteByExample(SafeExample example);

    @Delete({
        "delete from safe",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into safe (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Safe record);

    @InsertProvider(type=SafeSqlProvider.class, method="insertSelective")
    int insertSelective(Safe record);

    @SelectProvider(type=SafeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Safe> selectByExample(SafeExample example);

    @Select({
        "select",
        "id, name",
        "from safe",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Safe selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SafeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Safe record, @Param("example") SafeExample example);

    @UpdateProvider(type=SafeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Safe record, @Param("example") SafeExample example);

    @UpdateProvider(type=SafeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Safe record);

    @Update({
        "update safe",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Safe record);
}