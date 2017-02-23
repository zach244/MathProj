package com.example.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;

/**
 * Created by zach on 2/7/2017.
 */
@Entity
public class User implements UserDetails{ //defines the user entity, and how to return it
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(unique = true)

    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() { //not implemented
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //not implemented
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // not implemented
        return true;
    }

    @Override
    public boolean isEnabled() { //not implemented
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // returns a hash set of all the users roles and names.
       Set<GrantedAuthority> authorities = new HashSet<>();
       userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
       return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
