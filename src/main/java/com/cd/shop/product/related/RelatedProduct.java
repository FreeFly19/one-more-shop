package com.cd.shop.product.related;

import com.cd.shop.localization.LocalizedLabel;
import com.cd.shop.product.Product;
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
