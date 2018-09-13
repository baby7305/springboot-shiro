package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A SysRole.
 */
@Entity
@Table(name = "sys_role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_description")
    private String roleDescription;

    @Column(name = "user_available")
    private Integer userAvailable;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "sys_role_sys_resource", joinColumns = @JoinColumn(name = "sys_roles_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sys_resources_id", referencedColumnName = "id"))
    private Set<SysResource> sysResources = new HashSet<>();

    @ManyToMany(mappedBy = "sysRoles")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SysUser> sysUsers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not
    // remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public SysRole roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public SysRole roleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
        return this;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Integer getUserAvailable() {
        return userAvailable;
    }

    public SysRole userAvailable(Integer userAvailable) {
        this.userAvailable = userAvailable;
        return this;
    }

    public void setUserAvailable(Integer userAvailable) {
        this.userAvailable = userAvailable;
    }

    public Set<SysResource> getSysResources() {
        return sysResources;
    }

    public SysRole sysResources(Set<SysResource> sysResources) {
        this.sysResources = sysResources;
        return this;
    }

    public SysRole addSysResource(SysResource sysResource) {
        this.sysResources.add(sysResource);
        sysResource.getSysRoles().add(this);
        return this;
    }

    public SysRole removeSysResource(SysResource sysResource) {
        this.sysResources.remove(sysResource);
        sysResource.getSysRoles().remove(this);
        return this;
    }

    public void setSysResources(Set<SysResource> sysResources) {
        this.sysResources = sysResources;
    }

    public Set<SysUser> getSysUsers() {
        return sysUsers;
    }

    public SysRole sysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
        return this;
    }

    public SysRole addSysUser(SysUser sysUser) {
        this.sysUsers.add(sysUser);
        sysUser.getSysRoles().add(this);
        return this;
    }

    public SysRole removeSysUser(SysUser sysUser) {
        this.sysUsers.remove(sysUser);
        sysUser.getSysRoles().remove(this);
        return this;
    }

    public void setSysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
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
        SysRole sysRole = (SysRole) o;
        if (sysRole.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sysRole.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SysRole{" + "id=" + getId() + ", roleName='" + getRoleName() + "'" + ", roleDescription='"
                + getRoleDescription() + "'" + ", userAvailable=" + getUserAvailable() + "}";
    }
}
