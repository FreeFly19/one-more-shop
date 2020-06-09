package com.cd.shop.product;

import com.cd.shop.user.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductOutputDto findById(Long id, RequestContext requestContext) {
        return productRepository
                .findById(id)
                .map(ctg -> new ProductOutputDto(ctg, requestContext))
                .orElseThrow();
    }
}
