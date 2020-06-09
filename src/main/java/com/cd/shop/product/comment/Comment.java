package com.cd.shop.product.comment;

import com.cd.shop.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Product product;

    @ManyToOne(optional = true)
    private Comment parentComment;
}
