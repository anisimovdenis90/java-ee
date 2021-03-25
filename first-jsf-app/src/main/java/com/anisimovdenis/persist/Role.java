package com.anisimovdenis.persist;


import com.anisimovdenis.service.RoleDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "roles")
@NamedQueries({
        @NamedQuery(name = "findAllRoles", query = "FROM Role "),
        @NamedQuery(name = "countAllRoles", query = "SELECT COUNT(*) FROM Role"),
        @NamedQuery(name = "deleteRoleById", query = "DELETE FROM Role r WHERE r.id = :id")
})
public class Role implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(@NotNull String name) {
        this.name = name;
    }

    public Role(RoleDto r) {
        this.id = r.getId();
        this.name = r.getName();
    }

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
