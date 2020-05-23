package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ResizedImage {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Image image;

    private int width;
    private int height;
}
