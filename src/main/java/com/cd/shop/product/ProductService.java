package com.cd.shop.product;

import com.cd.shop.dataintegration.ExcelProduct;
import com.cd.shop.localization.LocalizedLabel;
import com.cd.shop.localization.LocalizedLabelInputDto;
import com.cd.shop.localization.LocalizedLabelService;
import com.cd.shop.product.category.ProductCategory;
import com.cd.shop.product.category.ProductCategoryRepository;
import com.cd.shop.user.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Set;

import static com.cd.shop.localization.Language.RU;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository categoryRepository;
    private final LocalizedLabelService localizedLabelService;

    public ProductOutputDto findById(Long id, RequestContext requestContext) {
        return productRepository
                .findById(id)
                .map(ctg -> new ProductOutputDto(ctg, requestContext))
                .orElseThrow();
    }

    @Transactional
    public void createProductFromExcel(ExcelProduct excelProduct) {
        var ctgLvl1 = categoryRepository.findByNaturalId(excelProduct.getCategory1Id())
                .orElseGet(() -> {
                    var c = new ProductCategory();
                    c.setNaturalId(excelProduct.getCategory1Id());
                    return c;
                });

        Set<LocalizedLabel> ctgLvl1LocalizedLabels = localizedLabelService
                .saveLabelsTransactional(Set.of(new LocalizedLabelInputDto(RU, excelProduct.getCategory1())));
        ctgLvl1.setTitles(ctgLvl1LocalizedLabels);
        categoryRepository.save(ctgLvl1);

        Product product = productRepository.findByNaturalId(excelProduct.getProductCode())
                .orElseGet(() -> {
                    Product p = new Product();
                    p.setNaturalId(excelProduct.getProductCode());
                    return p;
                });

        Set<LocalizedLabel> productLocalizedLabels = localizedLabelService
                .saveLabelsTransactional(Set.of(new LocalizedLabelInputDto(RU, excelProduct.getName())));
        product.setTitles(productLocalizedLabels);
        product.setCreatedAt(Instant.now());
        product.setPublished(true);

        productRepository.save(product);
    }
}
