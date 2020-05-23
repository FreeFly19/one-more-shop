package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.taxonomy;

import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.localization.LocalizedLabel;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Taxonomy {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<LocalizedLabel> titles;

    @ManyToOne
    private Taxonomy parent;

    @OneToMany(mappedBy = "parent")
    private Set<Taxonomy> children;
}
