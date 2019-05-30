package com.yu.mapper;

import com.yu.pojo.Company;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 公司数据访问层接口
 */
@Repository
public interface CompanyMapper {
    /**
     * 公司登录查询
     */
    @Select("select * from company where username=#{0} and password=#{1}")
    public Company login(String username,String password);

    /**
     * 插入新公司
     */
    @Insert("insert into company values(default,#{username},#{password},#{realName},#{location},#{phone},#{email},#{tip})")
    public int insCompany(Company company);

    /**
     * 根据用户名查询公司信息
     */
    @Select("select * from company where username=#{0}")
    public Company selCompanyByName(String username);

    /**
     * 公司信息修改
     */
    public int updateComInfo(Company company);

    /**
     * 查询公司用人需求信息分页
     */
    public List<Company> selAllComNeeds(HashMap<String,Object> map);

    /**
     * 条件查询公司用人需求不分页
     */
    public List<Company> selAllComNeedsNoPage();

    /**
     * 查询总条数
     */
    public int selCount();

    /**
     * 根据id查询公司信息 n+1方式
     */
    public Company selCompanyById(int id);

    /**
     * 根据id查询公司信息 非n+1方式
     */
    public Company selComInfoById(int id);

}
