package com.cd.shop.web;

import com.cd.shop.user.role.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

}
