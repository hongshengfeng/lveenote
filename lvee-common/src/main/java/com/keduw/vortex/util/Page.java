package com.keduw.vortex.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> implements Serializable {
    private static final long serialVersionUID = 337297181251071639L;
    private Integer page = 1;//当前页
    private Integer rows = 15;//页大小
    private Integer totalRecord = 0;// 总记录数
    private Integer firstPage;  //首页
    private Integer endPage;  //末页
    private List<T> list;//页面数据列表
    private String keyWord;//查询关键字
    private T paramEntity;//多条件查询
    private Integer start;//需要这里处理
    private Integer totalPage;
    private Map<String, Object> pageMap = new HashMap<String, Object>();

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public T getParamEntity() {
        return paramEntity;
    }

    public void setParamEntity(T paramEntity) {
        this.paramEntity = paramEntity;
    }

    public Integer getStart() {
        this.start = (page - 1) * rows;
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Map<String, Object> getPageMap() {
        return pageMap;
    }

    public void setPageMap(Map<String, Object> pageMap) {
        this.pageMap = pageMap;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

}
