package com.cd.shop.product.category;

import com.cd.shop.localization.LocalizedLabelInputDto;
import com.cd.shop.user.RequestContext;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class CreateCategoryCommand {
    private Set<LocalizedLabelInputDto> localizedLabels;
    private RequestContext requestContext;
    private Long naturalId;
}
