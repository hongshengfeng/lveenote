package com.keduw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "kd_auth_role_permission", schema = "keduw", catalog = "")
public class KdAuthRolePermissionEntity {
    private int id;
    private int roleId;
    private int permissionId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "permission_id")
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KdAuthRolePermissionEntity that = (KdAuthRolePermissionEntity) o;
        return id == that.id &&
                roleId == that.roleId &&
                permissionId == that.permissionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, permissionId);
    }
}
