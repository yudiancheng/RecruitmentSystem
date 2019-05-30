package com.yu.pojo;

/**
 * 求职者实体
 */
public class Person {
    private int id;
    private String username;
    private String password;
    private String realName;
    private String sex;
    private String birth;
    private String school;
    private String phone;
    private String email;
    private String major;
    private String salary;
    private String tip;
    private String desiredPosition;

    public Person() {
    }

    public Person(int id, String username, String password, String realName, String sex, String birth, String school, String phone, String email, String major, String salary, String tip, String desiredPosition) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.birth = birth;
        this.school = school;
        this.phone = phone;
        this.email = email;
        this.major = major;
        this.salary = salary;
        this.tip = tip;
        this.desiredPosition = desiredPosition;
    }

    public Person(String username, String password, String realName, String sex, String birth, String school, String phone, String email, String major, String salary, String tip, String desiredPosition) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.birth = birth;
        this.school = school;
        this.phone = phone;
        this.email = email;
        this.major = major;
        this.salary = salary;
        this.tip = tip;
        this.desiredPosition = desiredPosition;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDesiredPosition() {
        return desiredPosition;
    }

    public void setDesiredPosition(String desiredPosition) {
        this.desiredPosition = desiredPosition;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", school='" + school + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", salary='" + salary + '\'' +
                ", tip='" + tip + '\'' +
                ", desiredPosition='" + desiredPosition + '\'' +
                '}';
    }
}
