package com.cd.shop.product.category;

import com.cd.shop.localization.LocalizedLabel;
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

}
