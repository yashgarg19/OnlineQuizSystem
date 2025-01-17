package io.OnlineQuizSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
@Getter
@Setter
public class Role {


    @Id
    private Long roleId;
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL,fetch =  FetchType.LAZY,mappedBy = "role")
    @JsonIgnore
    private Set<UserRole> userRoles= new HashSet<>();

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
