package com.yu.service;

import com.yu.pojo.Employ;
import com.yu.pojo.PageInfo;
import com.yu.pojo.Person;

import java.util.List;

/**
 * 求职者业务逻辑接口
 */
public interface PersonService {
    /**
     * 求职者身份登录
     */
    public Person login(String username, String password);

    /**
     * 求职者注册
     */
    public int insPerson(Person person);

    /**
     * 求职者发布简历
     */
    public int insResume(int pid);

    /**
     * 求职者修改个人信息
     */
    public int updateInfo(Person person);

    /**
     * 求职者删除简历
     */
    public int delResume(int pid);

    /**
     * 查询企业人才需求
     */
    public PageInfo selCompany(String trade,int pageNumber, int pageSize);

    /**
     * 求职者申请指定公司岗位
     */
    public int insEmploy(int pid,int cid,String position);


    /**
     * 求职者查询已经申请的公司
     */
    public List<Employ> selAppliedCom(int id);

    /**
     * 根据id查询求职者信息
     */
    public Person selPersonById(int id);

}
