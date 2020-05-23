package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    private String alt;

    private Instant createdAt;
}
