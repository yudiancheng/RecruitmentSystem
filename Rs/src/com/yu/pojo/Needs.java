package com.yu.pojo;

/**
 * 公司需求实体
 */
public class Needs {
    private int id;
    private int cid;
    private String needs;
    private String salary;

    public Needs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Needs{" +
                "id=" + id +
                ", cid=" + cid +
                ", needs='" + needs + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
