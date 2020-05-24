package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name="\"order\"")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
}
