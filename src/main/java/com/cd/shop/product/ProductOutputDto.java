package com.cd.shop.product;

import com.cd.shop.image.Image;
import com.cd.shop.user.RequestContext;
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
                .findAny()
                .or(() -> product.getTitles().stream().findAny().stream().findAny())
                .orElseThrow()
                .getLabel();
        this.mainImage = product.getMainImage();
    }
}
