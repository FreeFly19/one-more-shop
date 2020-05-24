package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.image;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Setter
@Getter
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
