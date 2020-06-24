package com.cd.shop;

import com.cd.shop.localization.Language;
import com.cd.shop.localization.LocalizedLabelInputDto;
import com.cd.shop.product.category.CreateCategoryCommand;
import com.cd.shop.product.category.ProductCategoryRepository;
import com.cd.shop.product.category.ProductCategoryService;
import com.cd.shop.user.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class DbSeed {
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryRepository categoryRepository;

    @PostConstruct
    public void postInit() {
        CreateCategoryCommand createCategoryCommand = new CreateCategoryCommand();
        createCategoryCommand.setLocalizedLabels(Set.of(
                new LocalizedLabelInputDto(Language.UA, "Акумулятори"),
                new LocalizedLabelInputDto(Language.RU, "Аккумуляторы")
        ));

        createCategoryCommand.setNaturalId(4645L);

        RequestContext requestContext = new RequestContext();
        requestContext.setLang(Language.UA);
        requestContext.setRequestedAt(Instant.now());
        requestContext.setSessionId(UUID.randomUUID().toString());
        requestContext.setUserId(null);

        if (categoryRepository.count() == 0) {
            productCategoryService.createCategory(createCategoryCommand, requestContext);
        }
    }
}
