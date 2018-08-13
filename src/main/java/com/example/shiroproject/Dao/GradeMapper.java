package com.example.shiroproject.Dao;

import com.example.shiroproject.Entity.Grade;
import com.example.shiroproject.Tkmapper.TkMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

public interface GradeMapper extends TkMapper<Grade> {
//    @Insert({
//        "insert into grade (id, userid, ",
//        "grades)",
//        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
//        "#{grades,jdbcType=VARCHAR})"
//    })
//    int insert(Grade record);
//
//    @InsertProvider(type=GradeSqlProvider.class, method="insertSelective")
//    int insertSelective(Grade record);
//
    @Select({
            "select * from Grade g where g.userid=#{i}"
    })
    List<Grade> selecttttt(int i);



}