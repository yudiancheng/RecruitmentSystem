package com.yu.pojo;

import java.util.List;

/**
 * 分页信息
 */
public class PageInfo {
    private int pageNumber;//当前第几页
    private int pageSize;//每页数据条数
    private int total;//符合条件记录数
    private List<?> data;//每页的数据
    private int count;//总页数

    public PageInfo() {
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", data=" + data +
                ", count=" + count +
                '}';
    }
}
