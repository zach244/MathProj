package com.example.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 2/7/2017.
 */
@Entity
public class User implements UserDetails { //defines the user entity, and how to return it.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)

    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TestAttempt> testAttempts = new HashSet<>();

    public User(String username, String password, Set<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.userRoles = userRoles;
    }


    public User(String username, String password, Set<UserRole> userRoles, Set<TestAttempt> testAttempts) {
        this.username = username;
        this.password = password;
        this.userRoles = userRoles;
        this.testAttempts = testAttempts;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Set<TestAttempt> getTestAttempts() {
        return testAttempts;
    }

    public void setTestAttempts(Set<TestAttempt> testAttempts) {
        this.testAttempts = testAttempts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}