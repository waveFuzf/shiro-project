package com.example.shiroproject.Dao;

import com.example.shiroproject.Entity.Grade;
import com.example.shiroproject.Entity.User;
import com.example.shiroproject.Tkmapper.TkMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserMapper extends TkMapper<User> {
//    @Delete({
//        "delete from user",
//        "where id = #{id,jdbcType=INTEGER}"
//    })
//    int deleteByPrimaryKey(Integer id);

//    @Insert({
//        "insert into user (id, name, ",
//        "birthday, city)",
//        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
//        "#{birthday,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR})"
//    })
//    int insert(User record);

//    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
//    int insertSelective(User record);

//    @Select({
//        "select",
//        "id, name, birthday, city",
//        "from user",
//        "where id = #{id,jdbcType=INTEGER}"
//    })
//    @Results({
//        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
//        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
//        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
//        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR)
//    })
//    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set name = #{name,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
    @Select({
            "select * from User u where u.name=#{name}"
    })
    User selectByName(String name);

    @Select({
            "select * from User u where u.id='1'"
    })
    @Results({
            @Result(property = "g", column = "id",
                    many = @Many(select = "com.example.shiroproject.Dao.GradeMapper.selecttttt"))
    })
    List<User> getEmmm();
    @Select({
            "select * from User"
    })
    List<User> findAll();

    @Select({
            "select COUNT(*) from user"
    })
    int countItem();
}