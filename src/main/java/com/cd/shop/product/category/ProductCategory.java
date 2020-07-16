package com.cd.shop.product.category;

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
public class ProductCategory {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true, unique = true)
    private Long naturalId;

    @OneToMany
    private Set<LocalizedLabel> titles = new HashSet<>();

    @ManyToOne
    private ProductCategory parent;

    @OneToMany(mappedBy = "parent")
    private Set<ProductCategory> children = new HashSet<>();

    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();
}
