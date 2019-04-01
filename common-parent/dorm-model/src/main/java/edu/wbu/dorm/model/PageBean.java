package edu.wbu.dorm.model;

import java.util.List;

public class PageBean<T> {
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private int currentPage;//当前页
    private int pageSize;//每页显示条数
    private List<T> info;//当前页面数据

    public PageBean() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getInfo() {
        return info;
    }

    public void setInfo(List<T> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", info=" + info +
                '}';
    }
}
