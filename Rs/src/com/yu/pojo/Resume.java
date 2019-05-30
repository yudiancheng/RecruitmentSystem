package com.yu.pojo;

/**
 * 求职者发布简历实体
 */
public class Resume {
    private int id;
    private int pid;

    public Resume() {
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

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", pid=" + pid +
                '}';
    }
}
