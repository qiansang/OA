package com.bonc.oa.login.dao;

import com.bonc.oa.login.bean.Permission;
import com.bonc.oa.login.bean.PermissionExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface PermissionMapper {

    @Select({
            "select",
            "id, role_id, permission, remarks",
            "from permission",
            "where role_id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
            @Result(column="permission", property="permission", jdbcType=JdbcType.INTEGER),
            @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR)
    })
    List<Permission> selectByRoleId(Integer id);

    @SelectProvider(type=PermissionSqlProvider.class, method="countByExample")
    long countByExample(PermissionExample example);

    @DeleteProvider(type=PermissionSqlProvider.class, method="deleteByExample")
    int deleteByExample(PermissionExample example);

    @Delete({
        "delete from permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into permission (id, user_id, ",
        "permission, remarks)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{permission,jdbcType=INTEGER}, #{remarks,jdbcType=VARCHAR})"
    })
    int insert(Permission record);

    @InsertProvider(type=PermissionSqlProvider.class, method="insertSelective")
    int insertSelective(Permission record);

    @SelectProvider(type=PermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission", property="permission", jdbcType=JdbcType.INTEGER),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR)
    })
    List<Permission> selectByExample(PermissionExample example);

    @Select({
        "select",
        "id, user_id, permission, remarks",
        "from permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission", property="permission", jdbcType=JdbcType.INTEGER),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR)
    })
    Permission selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PermissionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    @UpdateProvider(type=PermissionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    @UpdateProvider(type=PermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Permission record);

    @Update({
        "update permission",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "permission = #{permission,jdbcType=INTEGER},",
          "remarks = #{remarks,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Permission record);
}