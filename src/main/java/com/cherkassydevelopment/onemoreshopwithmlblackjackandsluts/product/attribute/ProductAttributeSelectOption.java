package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.product.attribute;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class ProductAttributeSelectOption {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ProductAttribute attribute;

    @Column(nullable = false)
    private String systemName;



}
