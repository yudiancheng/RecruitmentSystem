package com.yu.pojo;

import java.util.List;

/**
 * 雇佣关系实体
 */
public class Employ {
    private int id;
    private int pid;
    private int cid;
    private int status;
    private String position;
    private List<Company> companies;
    private List<Person> peoples;

    public Employ() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Person> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<Person> peoples) {
        this.peoples = peoples;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "id=" + id +
                ", pid=" + pid +
                ", cid=" + cid +
                ", status=" + status +
                ", position=" + position +
                ", companies=" + companies +
                ", peoples=" + peoples +
                '}';
    }
}
