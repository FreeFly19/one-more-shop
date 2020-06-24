package com.cd.shop.image;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Setter
@Getter
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    private String alt;

    @Column(nullable = false, unique = true)
    private String publicUrl;

    @Column(nullable = false, unique = true)
    private String hash;

    private Instant createdAt;
}
