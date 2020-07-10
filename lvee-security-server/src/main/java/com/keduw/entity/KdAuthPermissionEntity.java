package com.keduw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "kd_auth_permission", schema = "keduw", catalog = "")
public class KdAuthPermissionEntity {
    private int id;
    private int parentId;
    private String menuName;
    private String buttonName;
    private byte navMenu;
    private String url;
    private String path;
    private int flag;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parent_id")
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "menu_name")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "button_name")
    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    @Basic
    @Column(name = "nav_menu")
    public byte getNavMenu() {
        return navMenu;
    }

    public void setNavMenu(byte navMenu) {
        this.navMenu = navMenu;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        KdAuthPermissionEntity that = (KdAuthPermissionEntity) o;
        return id == that.id &&
                parentId == that.parentId &&
                navMenu == that.navMenu &&
                flag == that.flag &&
                Objects.equals(menuName, that.menuName) &&
                Objects.equals(buttonName, that.buttonName) &&
                Objects.equals(url, that.url) &&
                Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, menuName, buttonName, navMenu, url, path, flag);
    }
}
