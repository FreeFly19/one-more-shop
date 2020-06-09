package com.cd.shop.product.media;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class ProductMedia {
    @Id
    @GeneratedValue
    private Long id;
}
