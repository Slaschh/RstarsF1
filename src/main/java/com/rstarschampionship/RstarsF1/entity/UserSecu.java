package com.rstarschampionship.RstarsF1.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@EntityListeners({AuditingEntityListener.class})
@Table(name = "usersecu")
public class UserSecu implements Serializable, UserDetails {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column (name = "userid")
        private Integer userId;
        private String username;
        private String password;
        public Integer getUserId() {
            return userId;
        }
        public void setUserId(Integer userId) {
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

}
