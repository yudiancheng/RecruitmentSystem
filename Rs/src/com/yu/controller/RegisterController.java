package com.yu.controller;

import com.yu.pojo.Company;
import com.yu.pojo.Person;
import com.yu.service.CompanyService;
import com.yu.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注册控制器
 */
@Controller
public class RegisterController {
    @Resource
    PersonService personServiceImpl;
    @Resource
    CompanyService companyServiceImpl;
    /**
     * 求职者注册模块
     */
    @RequestMapping("register")
    @ResponseBody
    public String register(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String realName = req.getParameter("realName");
        String sex = req.getParameter("sex");
        String birth = req.getParameter("birthday");
        String school = req.getParameter("school");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String major = req.getParameter("major");
        String salary = req.getParameter("salary");
        String desiredPosition = req.getParameter("position");
        String tip = req.getParameter("tip");
        String release = req.getParameter("isAuto");
        Person p = new Person(username,password,realName,sex,birth,school,phone,email,major,salary,tip,desiredPosition);
        int flag = personServiceImpl.insPerson(p);
        if(flag < 1) {//注册失败
            String message = "该用户名已存在！";
            return message;
        } else {
            //注册成功
            //判断是否选中了立即发布简历，如果选中则发布简历
            if(release != null) {
                //获取新插入的求职者id 然后向简历表添加记录
                Person afterReg = personServiceImpl.login(username, password);
                personServiceImpl.insResume(afterReg.getId());
            }
            return "注册成功!";
        }
    }

    /**
     * 企业注册模块
     */
    @RequestMapping("comReg")
    @ResponseBody
    public String comReg(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String realName = req.getParameter("realName");
        String location = req.getParameter("location");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String tip = req.getParameter("tip");
        Company company = new Company(username, password, realName, location, phone, email, tip);
        int flag = companyServiceImpl.insCompany(company);
        if (flag < 1) {//注册失败
            String message = "该用户名已存在！";
            return message;
        } else {
            //注册成功
            return "注册成功！";
        }
    }
}
