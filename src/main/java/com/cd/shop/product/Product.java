package com.cd.shop.product;

import com.cd.shop.image.Image;
import com.cd.shop.localization.LocalizedLabel;
import com.cd.shop.product.category.ProductCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true, unique = true)
    private Long naturalId;

    @OneToMany
    private Set<LocalizedLabel> titles = new HashSet<>();

    @ManyToOne
    private ProductCategory category;

    @OneToOne
    private Image mainImage;

    private boolean published;

    private Instant createdAt;
}
