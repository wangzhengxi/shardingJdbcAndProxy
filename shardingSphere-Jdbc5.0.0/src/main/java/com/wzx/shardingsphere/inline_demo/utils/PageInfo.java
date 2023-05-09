package com.wzx.shardingsphere.inline_demo.utils;


import java.util.List;

public class PageInfo<T> {

    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 每页数目
     */
    private int pageSize;
    /**
     * 总数目
     */
    private long totalRecord;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 数据集合
     */
    private List<T> result;

    public PageInfo() {
    }

    public PageInfo(int currentPage, int pageSize, long totalRecord, int totalPage, List result) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.result = result;
    }


    public static PageInfo getPageInfo(int currentPage, int pageSize, long totalRecord, int totalPage, List result) {
        PageInfo pageInfo = new PageInfo(currentPage, pageSize, totalRecord, totalPage, result);
        return pageInfo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
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

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
