package com.yu.service.impl;

import com.yu.mapper.CompanyMapper;
import com.yu.mapper.EmployMapper;
import com.yu.mapper.PersonMapper;
import com.yu.mapper.ResumeMapper;
import com.yu.pojo.*;
import com.yu.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 求职者业务实现类
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    PersonMapper personMapper;
    @Resource
    ResumeMapper resumeMapper;
    @Resource
    CompanyMapper companyMapper;
    @Resource
    EmployMapper employMapper;

    /**
     * 求职者身份登录
     */
    @Override
    public Person login(String username, String password) {
        return personMapper.login(username,password);
    }

    /**
     * 求职者注册
     */
    @Override
    public int insPerson(Person person) {
        //查询是否已存在用户名
        Person resPer = personMapper.selPersonByName(person.getUsername());
        if(resPer != null) {
            return 0;
        }
        return personMapper.insPerson(person);
    }

    /**
     * 求职者发布简历
     */
    @Override
    public int insResume(int pid) {
        return resumeMapper.insResume(pid);
    }

    /**
     * 求职者修改个人信息
     */
    @Override
    public int updateInfo(Person person) {
       return personMapper.updateInfo(person);
    }

    /**
     * 求职者删除简历
     */
    @Override
    public int delResume(int pid) {
        return resumeMapper.updResume(pid);
    }

    /**
     * 查询企业人才需求
     */
    public PageInfo selCompany(String trade,int pageNumber,int pageSize) {
        PageInfo pi = new PageInfo();
        System.out.println(trade);
        if(trade == null || trade.equals("")) {//如果是非条件查询
            //存储分页参数
            HashMap<String, Object> page = new HashMap<>();
            page.put("pageSize", pageSize);
            page.put("pageNumber", (pageNumber-1)*pageSize);
            //查询分页数据
            List<Company> res = companyMapper.selAllComNeeds(page);
            pi.setPageNumber(pageNumber);
            pi.setPageSize(pageSize);
            //查询总条数
            int count = companyMapper.selCount();
            pi.setTotal(count);
            pi.setData(res);
            pi.setCount((int) Math.ceil((double) count / pageSize));
        } else {//如果是条件查询
            //查询出所有的数据
            List<Company> res = companyMapper.selAllComNeedsNoPage();
            List<Company> suitable = new ArrayList<>();
            //筛选符合条件的数据
            for(Company company:res) {
                for(Needs needs:company.getNeeds()) {
                    if(needs.getNeeds().equals(trade)) {
                        suitable.add(company);
                    }
                }
            }
            //设置分页数据
            int count = suitable.size();
            //System.out.println(count);
            int fromIndex = (pageNumber-1)*pageSize;
            int toIndex = pageNumber*pageSize;
            //防止越界
            if(count == 0) {
                toIndex = 0;
            }
            if(count == 1) {
                toIndex = 1;
            }
            //准备返回数据
            List<Company> data = suitable.subList(fromIndex,toIndex);
         /* for(Company cm:data) {
                System.out.println(cm);
            }*/
            pi.setPageNumber(pageNumber);
            pi.setPageSize(pageSize);
            pi.setTotal(count);
            pi.setData(data);
            pi.setCount((int)Math.ceil((double)count/pageSize));
        }
        return pi;
    }


    /**
     * 求职者申请指定公司岗位
     */
    @Override
    public int insEmploy(int pid, int cid, String position) {
        //调用数据访问层方法
        return employMapper.insEmploy(pid, cid, position);
    }

    /**
     * 求职者查询已经申请过的公司
     */
    @Override
    public List<Employ> selAppliedCom(int id) {
        return employMapper.selAppliedCom(id);
    }

    @Override
    public Person selPersonById(int id) {
        return personMapper.selPersonById(id);
    }
}
