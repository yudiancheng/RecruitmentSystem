package com.yu.pojo;

import java.util.ArrayList;

/**
 * 筛选条件选择下拉框内容实体
 */

public class SelectList {
    //岗位列表
    private static ArrayList<String> tradeList;
    //工资列表
    private static ArrayList<String> salaryList;
    //专业列表
    private static ArrayList<String> majorList;

    static {
        tradeList = new ArrayList<>();
        salaryList = new ArrayList<>();
        majorList = new ArrayList<>();
        tradeList.add("软件工程师");
        tradeList.add("会计");
        tradeList.add("文员");
        tradeList.add("客户经理");
        tradeList.add("网站策划");
        tradeList.add("平面设计师");
        tradeList.add("java后端");
        tradeList.add("web前端");
        tradeList.add("UI设计");
        salaryList.add("0-3000");
        salaryList.add("3001-4000");
        salaryList.add("4001-5000");
        salaryList.add("5001-6000");
        salaryList.add("6001-7000");
        salaryList.add("7001-8000");
        salaryList.add("8000-?");
        majorList.add("软件工程");
        majorList.add("经济管理");
        majorList.add("数学");
        majorList.add("土木工程");
        majorList.add("法学");
        majorList.add("计算机科学");
    }


    public  ArrayList<String> getTradeList() {
        return tradeList;
    }

    public  void setTradeList(ArrayList<String> tradeList) {
        SelectList.tradeList = tradeList;
    }

    public  ArrayList<String> getSalaryList() {
        return salaryList;
    }

    public  void setSalaryList(ArrayList<String> salaryList) {
        SelectList.salaryList = salaryList;
    }

    public  ArrayList<String> getMajorList() {
        return majorList;
    }

    public  void setMajorList(ArrayList<String> majorList) {
        SelectList.majorList = majorList;
    }
}
