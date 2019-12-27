package com.rstarschampionship.RstarsF1.entity;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name = "usersecu")
public class UserSecu implements Serializable, UserDetails {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column (name = "userid")
        private Long userId;
        private String username;
        private String password;
        private String email;
       private boolean enabled;
       @Column(name = "tokenexpired")
       private boolean tokenExpired;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
            return username;
        }
        @Override
        public boolean isAccountNonExpired() {
            return false;
        }
        @Override
        public boolean isAccountNonLocked() {
            return false;
        }
        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }
        @Override
        public boolean isEnabled() {
            return false;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }


    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(
                    name = "user_id")},
            inverseJoinColumns = {@JoinColumn(
                    name = "role_id")})
    private Collection<Role> roles;
}
