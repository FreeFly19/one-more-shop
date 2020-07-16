package com.cd.shop.product.category;

import com.cd.shop.product.ProductOutputDto;
import com.cd.shop.user.RequestContext;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class ProductCategoryWithChildrenAndProductsOutputDto {
    private Long id;
    private String title;
    private List<ProductOutputDto> products;
    private List<ProductCategoryOutputDto> childrenCategories;

    public ProductCategoryWithChildrenAndProductsOutputDto(ProductCategory productCategory, RequestContext requestContext) {
        this.id = productCategory.getId();

        this.title = productCategory.getTitles().stream()
                .filter(t -> t.getLang().equals(requestContext.getLang()))
                .findAny()
                .or(() -> productCategory.getTitles().stream().findAny().stream().findAny())
                .orElseThrow()
                .getLabel();

        this.childrenCategories = productCategory.getChildren().stream()
                .map(c -> new ProductCategoryOutputDto(c, requestContext))
                .collect(Collectors.toList());

        this.products = Stream.concat(
                productCategory.getProducts().stream(),
                productCategory.getChildren().stream().flatMap(c -> c.getProducts().stream())
        )
                .map(p -> new ProductOutputDto(p, requestContext))
                .collect(Collectors.toList());


    }
}
