package com.cd.shop.image;

import lombok.Getter;
import lombok.Setter;

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

    private Instant createdAt;
}
