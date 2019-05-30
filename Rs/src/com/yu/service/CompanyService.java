package com.yu.service;

import com.yu.pojo.Company;
import com.yu.pojo.Employ;
import com.yu.pojo.Needs;
import com.yu.pojo.PageInfo;

import java.util.List;

/**
 * 企业业务逻辑接口
 */
public interface CompanyService {
    /**
     * 企业身份登录
     */
    public Company login(String username,String password);

    /**
     * 企业注册
     */
    public int insCompany(Company company);

    /**
     * 查询所有已经发布的人才
     */
    public PageInfo selResume(int pageNumber,int pageSize,String major,String salary,String school);

    /**
     * 修改企业信息
     */
    public int updateComInfo(Company company);

    /**
     * 发布招聘信息
     */
    public int insNeeds(int cid,String needs,String salary);

    /**
     * 查询本企业已发布的招聘信息
     */
    public List<Needs> selAllNeedBySelf(int cid);

    /**
     * 撤销招聘信息
     */
    public int delNeeds(int cid,String needs);

    /**
     * 根据id查询企业信息
     */
    public Company selCompanyById(int id);

    /**
     * 查询本公司已经申请的求职者
     */
    public List<Employ> selPersonByCid(int cid);

    /**
     * 是否通过简历
     */
    public int updateAgreeOrDis(int cid,int pid,int status,String position);
}
