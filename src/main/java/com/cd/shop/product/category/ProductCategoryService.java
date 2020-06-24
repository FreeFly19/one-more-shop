package com.cd.shop.product.category;

import com.cd.shop.localization.Language;
import com.cd.shop.localization.LocalizedLabelService;
import com.cd.shop.user.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("productCategoryService")
public class ProductCategoryService {
    private final LocalizedLabelService localizedLabelService;
    private final ProductCategoryRepository categoryRepository;

    public List<ProductCategoryOutputDto> getPublishedCategories(RequestContext requestContext) {
        return categoryRepository.findAll()
                .stream()
                .map(ctg -> new ProductCategoryOutputDto(ctg, requestContext))
                .collect(Collectors.toList());
    }

    @Deprecated
    public List<ProductCategoryOutputDto> getPublishedCategories() {
        RequestContext requestContext = new RequestContext();
        requestContext.setLang(Language.UA);
        requestContext.setRequestedAt(Instant.now());
        requestContext.setSessionId(UUID.randomUUID().toString());
        requestContext.setUserId(null);
        return getPublishedCategories(requestContext);
    }

    @Transactional
    public ProductCategoryOutputDto createCategory(CreateCategoryCommand createCategoryCommand, RequestContext rc) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setTitles(localizedLabelService.saveLabelsTransactional(createCategoryCommand.getLocalizedLabels()));
        productCategory.setNaturalId(createCategoryCommand.getNaturalId());
        return new ProductCategoryOutputDto(categoryRepository.save(productCategory), rc);
    }
}
