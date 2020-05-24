package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/*
A user which entered Name/Email/Phone etc, when left comment or bought a product
 */
@Getter
@Setter
@Entity
public class PartialUser {
    @Id
    @GeneratedValue
    private Long id;
}
