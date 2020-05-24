package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.product.related;

import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.localization.LocalizedLabel;
import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class RelatedProduct {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<LocalizedLabel> titles = new HashSet<>();

    @ManyToOne
    private Product from;

    @ManyToOne
    private Product to;
}
