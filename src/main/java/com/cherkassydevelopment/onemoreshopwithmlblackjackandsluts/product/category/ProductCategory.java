package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.product.category;

import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.localization.LocalizedLabel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<LocalizedLabel> titles = new HashSet<>();

}
