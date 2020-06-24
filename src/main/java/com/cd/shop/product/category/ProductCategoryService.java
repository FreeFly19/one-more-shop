package com.cd.shop.product.category;

import com.cd.shop.localization.LocalizedLabelService;
import com.cd.shop.user.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductCategoryService {
    private final LocalizedLabelService localizedLabelService;
    private final ProductCategoryRepository categoryRepository;

    public List<ProductCategoryOutputDto> getPublishedCategories(RequestContext requestContext) {
        return categoryRepository.findAll()
                .stream()
                .map(ctg -> new ProductCategoryOutputDto(ctg, requestContext))
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductCategoryOutputDto createCategory(CreateCategoryCommand createCategoryCommand, RequestContext rc) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setTitles(localizedLabelService.saveLabelsTransactional(createCategoryCommand.getLocalizedLabels()));
        productCategory.setNaturalId(createCategoryCommand.getNaturalId());
        return new ProductCategoryOutputDto(categoryRepository.save(productCategory), rc);
    }
}
