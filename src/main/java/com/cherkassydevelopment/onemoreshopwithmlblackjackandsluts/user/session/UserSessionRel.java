package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.user.session;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class UserSessionRel {
    @Id
    @GeneratedValue
    private Long id;
}
