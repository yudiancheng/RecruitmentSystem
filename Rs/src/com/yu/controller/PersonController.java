package com.yu.controller;

import com.yu.pojo.Company;
import com.yu.pojo.Employ;
import com.yu.pojo.PageInfo;
import com.yu.pojo.Person;
import com.yu.service.CompanyService;
import com.yu.service.PersonService;
import com.yu.util.WordGenerator;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

/**
 * 个人控制器
 */
@Controller
public class PersonController {
    @Resource
    PersonService personServiceImpl;
    @Resource
    CompanyService companyServiceImpl;

    /**
     * 根据选择条件查询合适企业ajax
     */
    @RequestMapping("showComByParam")
    @ResponseBody
    public void showComByParam(HttpServletRequest req,HttpSession session) throws  UnsupportedEncodingException{
        int pageSize = 2;
        int pageNumber = 1;
        //获取条件查询参数
        String size = req.getParameter("pageSize");
        String number = req.getParameter("pageNumber");
        String position = req.getParameter("trade");
        if(position != null) {
            position = new String(position.getBytes("iso8859-1"), "utf-8");
        }
        if(size != null && !size .equals("")) {
            pageSize = Integer.parseInt(size);
        }
        if(number != null && !number.equals("")) {
            pageNumber = Integer.parseInt(number);
        }
        //保存选择的两个条件，以防止前台select刷新
        session.setAttribute("position",position);
        //掉用业务层查询
        PageInfo pageInfo = personServiceImpl.selCompany(position,pageNumber,pageSize);
       //返回和处理数据
        List<?> companies = pageInfo.getData();
        if(companies != null && companies.size() != 0) {
            req.getServletContext().setAttribute("pageInfo",pageInfo);
            return;
        }
        req.getServletContext().removeAttribute("pageInfo");
    }

    /**
     * 个人信息修改
     */
    @RequestMapping("updateInfo")
    @ResponseBody
    public String updateInfo(HttpServletRequest req,HttpSession session) throws UnsupportedEncodingException{
       //获取参数与乱码处理
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        String name = req.getParameter("realName");
        name = new String(name.getBytes("iso8859-1"),"utf-8");
        String sex = req.getParameter("sex");
        sex = new String(sex.getBytes("iso8859-1"),"utf-8");
        String birth = req.getParameter("birthday");
        String school = req.getParameter("school");
        school = new String(school.getBytes("iso8859-1"),"utf-8");
        System.out.println(school);
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String major = req.getParameter("trade");
        major = new String(major.getBytes("iso8859-1"),"utf-8");
        String salary = req.getParameter("salary");
        String position = req.getParameter("position");
        position = new String(position.getBytes("iso8859-1"),"utf-8");
        String tip = req.getParameter("tip");
        tip = new String(tip.getBytes("iso8859-1"),"utf-8");
        Person user = (Person) session.getAttribute("user");
        Person person = new Person(user.getId(),username,password,name,sex,birth,school,phone,email,major,salary,tip,position);
        int res = personServiceImpl.updateInfo(person);
        if(res > 0) {
            session.setAttribute("user",person);
            return "成功";
        }
        return "失败";
    }

    /**
     * 简历下载
     */
   @RequestMapping("resumeDownload")
    public void resumeDownload(HttpServletResponse resp,HttpSession session) throws IOException{
        //获取用户信息
       HashMap<String,Person> map = new HashMap<>();
       Person user =(Person) session.getAttribute("user");
       map.put("user",user);
        //把二进制流放入响应实体中
        ServletOutputStream outputStream = resp.getOutputStream();
       File resume = null;
       try {
           resume = WordGenerator.createDoc(map,"resume.xml");
       } catch (Exception e) {
           e.printStackTrace();
       }
       //设置响应头文件下载
       resp.setHeader("Content-Disposition","attachment;filename="+resume.getName());
       byte bytes[] = FileUtils.readFileToByteArray(resume);
       outputStream.write(bytes);
       outputStream.flush();
       outputStream.close();
    }

    /**
     * 发布简历
     */
    @RequestMapping("publish")
    @ResponseBody
    public String publish(HttpSession session) {
        Person user = (Person)session.getAttribute("user");
        int res = personServiceImpl.insResume(user.getId());
        if(res > 0) {
            return "成功";
        } else {
            return "失败";
        }
    }

    /**
     * 撤销简历
     */
    @ResponseBody
    @RequestMapping("cancel")
    public String cancel(HttpSession session) {
        Person user = (Person)session.getAttribute("user");
        int res = personServiceImpl.delResume(user.getId());
        if(res > 0) {
            return "成功";
        } else {
            return "失败";
        }
    }

    /**
     * 公司详细信息展示
     */
    @RequestMapping("showComInfo")
    public String showComInfo(int id,HttpServletRequest req) {
        //调用业务层方法查询公司信息
        Company company = companyServiceImpl.selCompanyById(id);
        req.setAttribute("c_detailed",company);
        return "c_info.jsp";
    }

    /**
     * 求职者申请指定公司岗位
     */
    @RequestMapping("applyPosition")
    @ResponseBody
    public String applyPosition(int cid,String position,HttpSession session) throws UnsupportedEncodingException{
        System.out.println(cid + "  " + position);
        //乱码处理
        if(position != null) {
            position = new String(position.getBytes("iso8859-1"),"utf-8");
        }
        //获取求职者信息
        Person user = (Person)session.getAttribute("user");
        //调用业务层方法
        int res = personServiceImpl.insEmploy(user.getId(), cid, position);
        if(res > 0) {
            return "成功";
        } else {
            return "失败";
        }
    }

    /**
     * 准备显示已经申请的公司
     */
    @RequestMapping("prepareApplied")
    public String prepareApplied(HttpSession session,HttpServletRequest req){
        Person user = (Person)session.getAttribute("user");
        List<Employ> employs = personServiceImpl.selAppliedCom(user.getId());
        req.setAttribute("employs",employs);
        return "advise.jsp";
    }
}
