package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.product;

import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.image.Image;
import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.user.RequestContext;
import lombok.Data;

@Data
public class ProductOutputDto {
    private Long id;
    private String title;
    private Image mainImage;

    public ProductOutputDto(Product product, RequestContext requestContext) {
        this.id = product.getId();
        this.title = product.getTitles().stream()
                .filter(t -> t.getLang().equals(requestContext.getLang()))
                .findAny().orElseThrow().getLabel();
        this.mainImage = product.getMainImage();
    }
}
