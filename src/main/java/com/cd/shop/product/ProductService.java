package com.cd.shop.product;

import com.cd.shop.dataintegration.ExcelProduct;
import com.cd.shop.localization.LocalizedLabel;
import com.cd.shop.localization.LocalizedLabelInputDto;
import com.cd.shop.localization.LocalizedLabelService;
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
    private final LocalizedLabelService localizedLabelService;

    public ProductOutputDto findById(Long id, RequestContext requestContext) {
        return productRepository
                .findById(id)
                .map(ctg -> new ProductOutputDto(ctg, requestContext))
                .orElseThrow();
    }

    @Transactional
    public void createProductFromExcel(ExcelProduct excelProduct) {
        Product product = new Product();

        Set<LocalizedLabel> localizedLabels = localizedLabelService
                .saveLabelsTransactional(Set.of(new LocalizedLabelInputDto(RU, excelProduct.getName())));

        product.setTitles(localizedLabels);
        product.setCreatedAt(Instant.now());
        product.setPublished(true);

        productRepository.save(product);
    }
}
