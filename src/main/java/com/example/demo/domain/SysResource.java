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
 * A SysResource.
 */
@Entity
@Table(name = "sys_resource")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SysResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "resource_url")
    private String resourceUrl;

    @Column(name = "resource_permission")
    private String resourcePermission;

    @Column(name = "resource_available")
    private Integer resourceAvailable;

    @ManyToMany(mappedBy = "sysResources")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SysRole> sysRoles = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not
    // remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public SysResource resourceName(String resourceName) {
        this.resourceName = resourceName;
        return this;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public SysResource resourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public SysResource resourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
        return this;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourcePermission() {
        return resourcePermission;
    }

    public SysResource resourcePermission(String resourcePermission) {
        this.resourcePermission = resourcePermission;
        return this;
    }

    public void setResourcePermission(String resourcePermission) {
        this.resourcePermission = resourcePermission;
    }

    public Integer getResourceAvailable() {
        return resourceAvailable;
    }

    public SysResource resourceAvailable(Integer resourceAvailable) {
        this.resourceAvailable = resourceAvailable;
        return this;
    }

    public void setResourceAvailable(Integer resourceAvailable) {
        this.resourceAvailable = resourceAvailable;
    }

    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public SysResource sysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
        return this;
    }

    public SysResource addSysRole(SysRole sysRole) {
        this.sysRoles.add(sysRole);
        sysRole.getSysResources().add(this);
        return this;
    }

    public SysResource removeSysRole(SysRole sysRole) {
        this.sysRoles.remove(sysRole);
        sysRole.getSysResources().remove(this);
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
        SysResource sysResource = (SysResource) o;
        if (sysResource.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sysResource.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SysResource{" + "id=" + getId() + ", resourceName='" + getResourceName() + "'" + ", resourceType='"
                + getResourceType() + "'" + ", resourceUrl='" + getResourceUrl() + "'" + ", resourcePermission='"
                + getResourcePermission() + "'" + ", resourceAvailable=" + getResourceAvailable() + "}";
    }
}
