package com.yu.service.impl;

import com.yu.mapper.CompanyMapper;
import com.yu.mapper.EmployMapper;
import com.yu.mapper.NeedsMapper;
import com.yu.mapper.ResumeMapper;
import com.yu.pojo.*;
import com.yu.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 企业业务实现类
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    CompanyMapper companyMapper;
    @Autowired
    NeedsMapper needsMapper;
    @Resource
    ResumeMapper resumeMapper;
    @Resource
    EmployMapper employMapper;

    /**
     * 企业身份登录
     */
    @Override
    public Company login(String username, String password) {
        return companyMapper.login(username,password);
    }

    /**
     *企业注册
     */
    @Override
    public int insCompany(Company company) {
        //查询是否已经存在公司名
       Company com = companyMapper.selCompanyByName(company.getUsername());
       if(com != null) {
           return 0;
       }
        return companyMapper.insCompany(company);
    }

    /**
     * 查询所有已经发布的人才
     */
    @Override
    public PageInfo selResume(int pageNumber,int pageSize,String major,String salary,String school) {
        PageInfo pi = new PageInfo();
        //计算并存储分页数据
        HashMap<String,Object> map = new HashMap<>();
        map.put("pageNumber",pageSize*(pageNumber-1));
        map.put("pageSize",pageSize);
        map.put("major",major);
        map.put("salary",salary);
        map.put("school",school);
        //调用数据访问层方法查询数据
        List<Person> people = resumeMapper.selResume(map);
        //查询符合条件的数据总条数
        int total = resumeMapper.selResumeCount(map);
        //计算总页数
        int count = (int)Math.ceil((double)total/pageSize);
        //往分页类里存储数据
        pi.setPageNumber(pageNumber);
        pi.setPageSize(pageSize);
        pi.setTotal(total);
        pi.setData(people);
        pi.setCount(count);
        //返回数据
        return pi;
    }

    /**
     * 修改企业信息
     */
    @Override
    public int updateComInfo(Company company) {
        //调用数据访问层方法
        return companyMapper.updateComInfo(company);
    }

    /**
     * 发布招聘信息
     */
    @Override
    public int insNeeds(int cid, String needs, String salary) {
        return needsMapper.insNeeds(cid,needs,salary);
    }

    /**
     * 查询本企业已发布的招聘信息
     */
    @Override
    public List<Needs> selAllNeedBySelf(int cid) {
        return needsMapper.selNeedsByCid(cid);
    }

    /**
     * 撤销招聘信息
     */
    @Override
    public int delNeeds(int cid, String needs) {
        return needsMapper.delNeeds(cid,needs);
    }

    /**
     * 根据id查询公司信息
     */
    @Override
    public Company selCompanyById(int id) {
        //调用数据访问层方法查询
        return  companyMapper.selCompanyById(id);
    }

    /**
     *查询本公司已经申请的求职者
     */
    @Override
    public List<Employ> selPersonByCid(int cid) {
        //调用数据访问层方法查询
        return employMapper.selPersonByCid(cid);
    }

    /**
     * 修改是否通过求职者的简历
     */
    @Override
    public int updateAgreeOrDis(int cid, int pid, int status, String position) {
        //调用数据访问层方法
        return employMapper.updateAgreeOrDis(cid,pid,status,position);
    }
}
