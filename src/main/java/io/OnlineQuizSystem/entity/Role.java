package io.OnlineQuizSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {
    public Role(Long roleId, String roleName, Set<UserRole> userRoles) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userRoles = userRoles;
    }

    @Id
    private Long roleId;
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL,fetch =  FetchType.LAZY,mappedBy = "role")
    @JsonIgnore
    private Set<UserRole> userRoles= new HashSet<>();

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    public Role() {

    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
