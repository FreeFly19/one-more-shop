package com.cd.shop.product.attribute;

import com.cd.shop.localization.LocalizedLabel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class ProductAttribute {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private ProductAttributeType type;

    @Column(nullable = false)
    private String systemFieldName;

    @OneToMany
    private Set<LocalizedLabel> titles = new HashSet<>();

    @OneToMany(mappedBy = "attribute")
    private Set<ProductAttributeSelectOption> selectOptions = new HashSet<>();
}
