package com.cd.shop.user.role;

import com.cd.shop.web.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
