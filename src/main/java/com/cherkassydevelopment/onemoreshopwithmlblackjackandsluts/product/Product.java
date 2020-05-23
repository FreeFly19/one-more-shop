package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.product;

import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.image.Image;
import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.localization.LocalizedLabel;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<LocalizedLabel> titles;

    @OneToOne
    private Image mainImage;

    private boolean published;

    private Instant createdAt;
}
