package com.lc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by liuch on 2018/7/31.
 */
@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(name = "sys_permission_role",
            joinColumns = {@JoinColumn(name = "sys_role_id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_permission_id")})
    private List<SysPermission> permissions;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}