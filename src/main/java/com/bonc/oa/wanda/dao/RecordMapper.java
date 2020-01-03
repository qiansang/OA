package com.bonc.oa.wanda.dao;

import com.bonc.oa.wanda.bean.Record;
import com.bonc.oa.wanda.bean.RecordExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface RecordMapper {

    @Select({
            "select",
            "id, content, date, customer_id",
            "from record",
            "where customer_id = #{customerId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER)
    })
    List<Record> selectByCustomerId(Integer customerId);

    @SelectProvider(type=RecordSqlProvider.class, method="countByExample")
    long countByExample(RecordExample example);

    @DeleteProvider(type=RecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(RecordExample example);

    @Delete({
        "delete from record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into record (id, content, ",
        "date, customer_id)",
        "values (#{id,jdbcType=INTEGER}, #{content,jdbcType=VARCHAR}, ",
        "#{date,jdbcType=TIMESTAMP}, #{customerId,jdbcType=INTEGER})"
    })
    int insert(Record record);

    @InsertProvider(type=RecordSqlProvider.class, method="insertSelective")
    int insertSelective(Record record);

    @SelectProvider(type=RecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER)
    })
    List<Record> selectByExample(RecordExample example);

    @Select({
        "select",
        "id, content, date, customer_id",
        "from record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER)
    })
    Record selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordExample example);

    @UpdateProvider(type=RecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Record record, @Param("example") RecordExample example);

    @UpdateProvider(type=RecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Record record);

    @Update({
        "update record",
        "set content = #{content,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Record record);

    @Delete({
            "delete from record",
            "where customer_id = #{id,jdbcType=INTEGER}"
    })
    int deleteByCustomerId(Integer id);
}