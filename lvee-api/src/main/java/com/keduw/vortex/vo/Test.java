package com.keduw.vortex.vo;

import java.io.Serializable;

public class Test implements Serializable {

    private Integer id;

    private String name;

    private String auth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}