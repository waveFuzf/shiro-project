package com.example.shiroproject.Dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.example.shiroproject.Entity.Grade;

public class GradeSqlProvider {

    public String insertSelective(Grade record) {
        BEGIN();
        INSERT_INTO("grade");
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            VALUES("userid", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getGrades() != null) {
            VALUES("grades", "#{grades,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }
}