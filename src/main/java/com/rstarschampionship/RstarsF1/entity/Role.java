package com.rstarschampionship.RstarsF1.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<UserSecu> userSecu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<UserSecu> getUserSecu() {
        return userSecu;
    }

    public void setUserSecu(Collection<UserSecu> userSecu) {
        this.userSecu = userSecu;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }


    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = {@JoinColumn(
                    name = "role_id")},
            inverseJoinColumns = {@JoinColumn(
                    name = "privilege_id")})
    private Collection<Privilege> privileges;

    public Role(String name) {
    }
}