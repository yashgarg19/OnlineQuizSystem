package io.OnlineQuizSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId" , nullable = false)
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean enabled=true;
    private String profile;


    @OneToMany(cascade = CascadeType.ALL,fetch =  FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserRole> userRoles= new HashSet<>();

    public User() {
    }

    public User(Long id, String username, String password, String firstname, String lastname, String email, String phone, boolean enabled, String profile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
        this.profile = profile;
    }
}
