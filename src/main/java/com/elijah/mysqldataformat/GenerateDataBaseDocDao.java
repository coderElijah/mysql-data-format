package com.elijah.mysqldataformat;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author elijahliu
 * @Note Talk is cheap,just show me ur code.- -!
 * ProjectName:mysql-data-format
 * PackageName: com.elijah.mysqldataformat
 * Date: 2019/12/11 15:25
 */
@Mapper
public interface GenerateDataBaseDocDao {
    @Select("select column_name,column_type,column_comment from columns where TABLE_SCHEMA=#{databaseName} and TABLE_NAME=#{tableName} order by ordinal_position asc;")
    List<Map> selectTableInfoByName(@Param("databaseName") String databaseName, @Param("tableName") String tableName);
}
