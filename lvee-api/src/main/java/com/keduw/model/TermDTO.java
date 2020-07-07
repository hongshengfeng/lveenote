package com.keduw.model;

import java.sql.Date;

/**
 * @author hongshengfeng
 * @date 2020/07/05
 */

public class TermDTO {

    private Integer id;
    private String uuid;
    private Integer userId;
    private String name;
    private Date createTime;
    private Integer odds;
    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOdds() {
        return odds;
    }

    public void setOdds(Integer odds) {
        this.odds = odds;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
