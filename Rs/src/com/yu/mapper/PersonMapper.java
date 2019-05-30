package com.yu.mapper;

import com.yu.pojo.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 求职者数据访问层接口
 */
@Repository
public interface PersonMapper {
    /**
     * 求职者登录查询
     */
    @Select("select * from person where username=#{0} and password=#{1}")
    public Person login(String username, String password);

    /**
     * 求职者注册
     */
    @Insert("insert into person values(default,#{username},#{password},#{realName},#{sex},#{birth},#{school},#{phone},#{email},#{major},#{salary},#{tip},#{desiredPosition})")
    public int insPerson(Person p);

    /**
     * 根据用户名查询求职者信息
     */
    @Select("select * from person where username=#{0}")
    public Person selPersonByName(String username);

    /**
     * 修改个人信息
     */
    public int updateInfo(Person person);

    /**
     * 根据id查询求职者信息
     */
    @Select("select * from person where id=#{0}")
    public Person selPersonById(int id);

}
