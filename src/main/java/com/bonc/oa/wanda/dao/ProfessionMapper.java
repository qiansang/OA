package com.bonc.oa.wanda.dao;

import com.bonc.oa.wanda.bean.Profession;
import com.bonc.oa.wanda.bean.ProfessionExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ProfessionMapper {

    @Select({
            "select",
            "name",
            "from profession",
            "where title_id = #{titleId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
    })
    String selectById(Integer id);

    @Select({
            "select",
            "id, name, title_id, num",
            "from profession",
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="title_id", property="titleId", jdbcType=JdbcType.INTEGER),
            @Result(column="num", property="num", jdbcType=JdbcType.INTEGER)
    })
    List<Profession> selectAll();

    @Select({
            "select",
            "id, name, title_id, num",
            "from profession",
            "where title_id = #{titleId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="title_id", property="titleId", jdbcType=JdbcType.INTEGER),
            @Result(column="num", property="num", jdbcType=JdbcType.INTEGER)
    })
    List<Profession> selectByTitleId(Integer titleId);

    @Update({
            "update profession",
            "set name = #{name,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(Profession record);

    @SelectProvider(type=ProfessionSqlProvider.class, method="countByExample")
    long countByExample(ProfessionExample example);

    @DeleteProvider(type=ProfessionSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProfessionExample example);

    @Delete({
        "delete from profession",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into profession (id, name, ",
        "title_id, num)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{titleId,jdbcType=INTEGER}, #{num,jdbcType=INTEGER})"
    })
    int insert(Profession record);

    @InsertProvider(type=ProfessionSqlProvider.class, method="insertSelective")
    int insertSelective(Profession record);

    @SelectProvider(type=ProfessionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="title_id", property="titleId", jdbcType=JdbcType.INTEGER),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER)
    })
    List<Profession> selectByExample(ProfessionExample example);

    @Select({
        "select",
        "id, name, title_id, num",
        "from profession",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="title_id", property="titleId", jdbcType=JdbcType.INTEGER),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER)
    })
    Profession selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProfessionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Profession record, @Param("example") ProfessionExample example);

    @UpdateProvider(type=ProfessionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Profession record, @Param("example") ProfessionExample example);

    @UpdateProvider(type=ProfessionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Profession record);

    @Update({
        "update profession",
        "set name = #{name,jdbcType=VARCHAR},",
          "title_id = #{titleId,jdbcType=INTEGER},",
          "num = #{num,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Profession record);

    @Update({
            "update profession",
            "set num = num + 1",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int addNumById(Integer id);

    @Update({
            "update profession",
            "set num = num - 1",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int cutNumById(Integer id);

    @Update({
            "update profession",
            "set num = num - 1",
            "where id = #{profesionId,jdbcType=INTEGER}"
    })
    int cutNumByIdList(Integer profesionId);
}