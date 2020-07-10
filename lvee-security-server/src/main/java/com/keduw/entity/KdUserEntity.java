package com.keduw.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "kd_user", schema = "keduw", catalog = "")
public class KdUserEntity {
    private int id;
    private String userName;
    private String password;
    private String nickName;
    private String icon;
    private Timestamp regTime;
    private Timestamp loginTime;
    private String tips;
    private String inviteCode;
    private int flag;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "reg_time")
    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    @Basic
    @Column(name = "login_time")
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "tips")
    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Basic
    @Column(name = "invite_code")
    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    @Basic
    @Column(name = "flag")
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KdUserEntity that = (KdUserEntity) o;
        return id == that.id &&
                flag == that.flag &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(regTime, that.regTime) &&
                Objects.equals(loginTime, that.loginTime) &&
                Objects.equals(tips, that.tips) &&
                Objects.equals(inviteCode, that.inviteCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, nickName, icon, regTime, loginTime, tips, inviteCode, flag);
    }
}
