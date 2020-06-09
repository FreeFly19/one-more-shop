package com.cd.shop.product.price;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Price {
    @Id
    @GeneratedValue
    private Long id;
}
