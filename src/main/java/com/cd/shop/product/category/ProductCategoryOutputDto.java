package com.cd.shop.product.category;

import com.cd.shop.user.RequestContext;
import lombok.Data;

@Data
public class ProductCategoryOutputDto {
    private Long id;
    private String title;

    public ProductCategoryOutputDto(ProductCategory productCategory, RequestContext requestContext) {
        this.id = productCategory.getId();

        this.title = productCategory.getTitles().stream()
                .filter(t -> t.getLang().equals(requestContext.getLang()))
                .findAny()
                .or(() -> productCategory.getTitles().stream().findAny().stream().findAny())
                .orElseThrow()
                .getLabel();
    }
}
