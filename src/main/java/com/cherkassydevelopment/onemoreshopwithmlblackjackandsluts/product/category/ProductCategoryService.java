package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.product.category;

import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.user.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductCategoryService {
    private final ProductCategoryRepository categoryRepository;

    public List<ProductCategoryOutputDto> getPublishedCategories(RequestContext requestContext) {
        return categoryRepository.findAll()
                .stream()
                .map(ctg -> new ProductCategoryOutputDto(ctg, requestContext))
                .collect(Collectors.toList());
    }
}
