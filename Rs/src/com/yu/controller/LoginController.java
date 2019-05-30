package com.yu.controller;

import com.yu.pojo.*;
import com.yu.service.CompanyService;
import com.yu.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 登录控制器
 */
@Controller
public class LoginController {
    @Resource
    PersonService personServiceImpl;
    @Resource
    CompanyService companyServiceImpl;

    /**
     * 求职者登录模块
     */
    @RequestMapping("personLogin")
    public String personLogin(HttpServletRequest req, HttpSession session, HttpServletResponse resp) throws IOException {
       //获取登录参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        String rem = req.getParameter("rem");
        if(rem != null) {//如果记住密码复选框选中增加cookie
            Cookie name = new Cookie("username",username);
            Cookie pwd = new Cookie("password",password);
            name.setMaxAge(3*24*60*60);
            pwd.setMaxAge(3*24*60*60);
            name.setPath("/Rs");
            pwd.setPath("/Rs");
            resp.addCookie(name);
            resp.addCookie(pwd);
        }
        if(type.equals("公司")) {
            //调用企业登录
            return companyLogin(username,password,session,req);
        }
        Person person = personServiceImpl.login(username, password);
        if(person != null){
            //求职者登录成功
            session.setAttribute("user",person);
            //预备展示企业需求信息和筛选条件
            SelectList selectList = new SelectList();
            req.getServletContext().setAttribute("selectList", selectList);
            printPage(req);
            return "redirect:/index.jsp";
        }else {
            //求职者登录失败
            return "/login.jsp";
        }
    }

    /**
     * 企业登录模块
     */
    public String companyLogin(String username, String password, HttpSession session,HttpServletRequest req) throws IOException {
        //调用业务层查询
        Company company = companyServiceImpl.login(username, password);
        if (company != null) {
            //准备显示主页数据
            SelectList selectList = new SelectList();
            req.getServletContext().setAttribute("selectList",selectList);
            showAllPeopleByPage(req);
            //处理返回数据
            session.setAttribute("company", company);
            return "redirect:/c_index.jsp";
        } else {
            return "/login.jsp";
        }
    }
    /**
     * 企业用人需求分页非ajax
     */
    @RequestMapping("printPage")
    public String printPage(HttpServletRequest req) throws UnsupportedEncodingException {
        int pageSize = 2;
        int pageNumber = 1;
        //获取分页或查询条件参数
        String size = req.getParameter("pageSize");
        String number = req.getParameter("pageNumber");
        String position = req.getParameter("trade");
        //参数乱码处理
        if(position != null) {
            position = new String(position.getBytes("iso8859-1"), "utf-8");
        }
        if(size != null && !size .equals("")) {
            pageSize = Integer.parseInt(size);
        }
        if(number != null && !number.equals("")) {
            pageNumber = Integer.parseInt(number);
        }
        //调用业务层查询
        PageInfo pageInfo = personServiceImpl.selCompany(position,pageNumber,pageSize);
        //返回结果处理数据
        List<?> companies = pageInfo.getData();
        // System.out.println(pageInfo.getTotal());
        if(companies != null && companies.size() != 0) {
            req.getServletContext().setAttribute("pageInfo",pageInfo);
            return "redirect:/query.jsp";
        }
        req.getServletContext().removeAttribute("pageInfo");
        return "redirect:/query.jsp";
    }

    /**
     * 分页展示所有人才信息非ajax
     */
    @RequestMapping("showAllPeopleByPage")
    public String showAllPeopleByPage(HttpServletRequest req) throws UnsupportedEncodingException {
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
        //调用业务层查询
        PageInfo pageInfo = companyServiceImpl.selResume(number, size, major, salary, school);
        //处理数据
        List<?> persons = pageInfo.getData();
        if(persons != null && persons.size() != 0) {
            req.getServletContext().setAttribute("c_pageInfo",pageInfo);
            return "redirect:/c_query.jsp";
        }
        //如果没有匹配数据
        req.getServletContext().removeAttribute("c_pageInfo");
        return "redirect:/c_query.jsp";
    }
}
