package com.yu.pojo;

import java.util.List;

/**
 * 公司实体
 */
public class Company {
    private int id;
    private String username;
    private String password;
    private String realName;
    private String location;
    private String phone;
    private String email;
    private String tip;
    private List<Needs> needs;
    public Company() {
    }

    public Company(int id, String username, String password, String realName, String location, String phone, String email, String tip) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.tip = tip;
    }

    public Company(String username, String password, String realName, String location, String phone, String email, String tip) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.tip = tip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public List<Needs> getNeeds() {
        return needs;
    }

    public void setNeeds(List<Needs> needs) {
        this.needs = needs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", tip='" + tip + '\'' +
                ", needs=" + needs +
                '}';
    }
}
