package com.example.demo.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A SysUser.
 */
@Entity
@Table(name = "sys_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_salt")
    private String userSalt;

    @Column(name = "user_available")
    private Integer userAvailable;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "sys_user_sys_role", joinColumns = @JoinColumn(name = "sys_users_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sys_roles_id", referencedColumnName = "id"))
    private Set<SysRole> sysRoles = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not
    // remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public SysUser userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public SysUser userPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public SysUser userSalt(String userSalt) {
        this.userSalt = userSalt;
        return this;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public Integer getUserAvailable() {
        return userAvailable;
    }

    public SysUser userAvailable(Integer userAvailable) {
        this.userAvailable = userAvailable;
        return this;
    }

    public void setUserAvailable(Integer userAvailable) {
        this.userAvailable = userAvailable;
    }

    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public SysUser sysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
        return this;
    }

    public SysUser addSysRole(SysRole sysRole) {
        this.sysRoles.add(sysRole);
        sysRole.getSysUsers().add(this);
        return this;
    }

    public SysUser removeSysRole(SysRole sysRole) {
        this.sysRoles.remove(sysRole);
        sysRole.getSysUsers().remove(this);
        return this;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysUser sysUser = (SysUser) o;
        if (sysUser.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sysUser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SysUser{" + "id=" + getId() + ", userName='" + getUserName() + "'" + ", userPassword='"
                + getUserPassword() + "'" + ", userSalt='" + getUserSalt() + "'" + ", userAvailable="
                + getUserAvailable() + "}";
    }
}
