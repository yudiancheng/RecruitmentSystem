package com.yu.controller;

import com.yu.pojo.*;
import com.yu.service.CompanyService;
import com.yu.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 企业控制器
 */
@Controller
public class CompanyController {
    @Resource
    CompanyService companyServiceImpl;
    @Resource
    PersonService personServiceImpl;


    /**
     * 分页展示所有人才信息ajax
     */
    @RequestMapping("showAllPeople")
    @ResponseBody
    public void showAllPeople(HttpServletRequest req, HttpSession session) throws UnsupportedEncodingException {
        int size = 2;
        int number = 1;
        //获取条件查询参数
        String major = req.getParameter("major");
        String salary = req.getParameter("salary");
        String school = req.getParameter("school");
        String pageSize = req.getParameter("pageSize");
        String pageNumber = req.getParameter("pageNumber");
        //乱码处理
        if(major != null) {
            major = new String(major.getBytes("iso8859-1"),"utf-8");
        }
        if(school != null && !school.equals("")) {
            school = new String(school.getBytes("iso8859-1"),"utf-8");
        }
        //转换数字处理
        if(pageSize != null) {
            size = Integer.parseInt(pageSize);
        }
        if(pageNumber != null){
            number = Integer.parseInt(pageNumber);
        }
        //保存选择参数，防止前端页面Select刷新
        session.setAttribute("major",major);
        session.setAttribute("school",school);
        session.setAttribute("c_salary",salary);
        //调用业务层查询
        PageInfo pageInfo = companyServiceImpl.selResume(number, size, major, salary, school);
        //处理数据
        List<?> persons = pageInfo.getData();
        if(persons != null && persons.size() != 0) {
            req.getServletContext().setAttribute("c_pageInfo",pageInfo);
            return;
        }
        //如果没有匹配数据
        req.getServletContext().removeAttribute("c_pageInfo");
    }

    /**
     * 修改企业信息
     */
    @RequestMapping("updateComInfo")
    @ResponseBody
    public String updateComInfo(HttpServletRequest req,HttpSession session) throws UnsupportedEncodingException {
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String realName = req.getParameter("realName");
        String location = req.getParameter("location");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String tip = req.getParameter("tip");
        //乱码处理
        realName = new String(realName.getBytes("iso8859-1"),"utf-8");
        location = new String(location.getBytes("iso8859-1"),"utf-8");
        tip = new String(tip.getBytes("iso8859-1"),"utf-8");
        //更新公司信息
        Company company = (Company)session.getAttribute("company");
        Company newCom= new Company(company.getId(),username,password,realName,location,phone,email,tip);
        //调用业务层方法
        int res = companyServiceImpl.updateComInfo(newCom);
        System.out.println(res);
        if(res > 0) {
            session.setAttribute("company",newCom);
            return "成功";
        }
        return "失败";
    }

    /**
     * 发布招聘信息
     */
    @RequestMapping("insNeeds")
    @ResponseBody
    public String insNeeds(HttpServletRequest req,HttpSession session) throws UnsupportedEncodingException{
        //获取参数
        String needs = req.getParameter("needs");
        String salary = req.getParameter("salary");
        Company company = (Company) session.getAttribute("company");
        //处理乱码
        if(needs != null) {
            needs = new String(needs.getBytes("iso8859-1"),"utf-8");
        }
        //调用业务层方法
        int res = companyServiceImpl.insNeeds(company.getId(), needs, salary);
        //处理结果
        if(res > 0) {
            return "成功";
        }
        return "失败";
    }

    /**
     * 撤销招聘信息预备数据（查询本企业已发布的招聘信息）
     */
    @RequestMapping("prepareDelNeeds")
    public String prepareDelNeeds(HttpSession session) {
        Company self = (Company)session.getAttribute("company");
        List<Needs> needs = companyServiceImpl.selAllNeedBySelf(self.getId());
        session.setAttribute("self_needs",needs);
        return "c_cancel.jsp";
    }

    /**
     * 撤销已发布的招聘信息
     */
    @RequestMapping("delNeeds")
    @ResponseBody
    public String delNeeds(HttpServletRequest req,HttpSession session)throws UnsupportedEncodingException {
        //获取要删除数据的参数
        Company company = (Company) session.getAttribute("company");
        int id = company.getId();
        String needs = req.getParameter("needs");
        //乱码处理
        needs = new String(needs.getBytes("iso8859-1"),"utf-8");
        //调用业务层方法
        int res = companyServiceImpl.delNeeds(id, needs);
        if(res > 0) {
            return "成功";
        } else {
            return "失败";
        }
    }
    /**
     * 准备展示求职者详细信息的数据
     */
    @RequestMapping("showDetail")
    public String showDetail(int id,HttpServletRequest req) {
        //调用业务层方法
        Person person = personServiceImpl.selPersonById(id);
        req.setAttribute("p_detailed",person);
        return "info.jsp";
    }

    /**
     * 准备求职者通知模块的数据
     */
    @RequestMapping("preparePersonData")
    public String preparePersonData(HttpSession session,HttpServletRequest req) {
        Company company = (Company) session.getAttribute("company");
        List<Employ> employs = companyServiceImpl.selPersonByCid(company.getId());
        req.setAttribute("c_employs",employs);
        return "c_advise.jsp";
    }

    /**
     * 处理是否通过简历
     */
    @ResponseBody
    @RequestMapping("agreeOrDis")
    public String agreeOrDis(Integer pid,Integer isAgree,String position,HttpSession session) throws UnsupportedEncodingException {
        System.out.println(pid + "   "+isAgree);
        //乱码处理
        if(position != null) {
            position = new String(position.getBytes("iso8859-1"),"utf-8");
        }
        //获取当前登录的公司信息
        Company company = (Company) session.getAttribute("company");
        //调用业务层方法
        int res = companyServiceImpl.updateAgreeOrDis(company.getId(), pid, isAgree, position);
        if(res > 0) {
            return "成功";
        } else {
            return "失败";
        }
    }
}

