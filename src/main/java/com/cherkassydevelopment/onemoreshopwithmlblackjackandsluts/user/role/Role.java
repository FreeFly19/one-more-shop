package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.user.role;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;
}
