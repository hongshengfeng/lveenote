package com.keduw.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author hongshengfeng
 * @date 2020/07/13
 */
public class UrlAccess {

    private int id;
    private String url;
    private String remark;
    private Date createTime;
    private int flag;

    public static class Flag{
        public static final int IS_AUTH = 0x1;  //是否校验权限
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
