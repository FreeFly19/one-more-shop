package com.cd.shop.web.frontend;

import com.cd.shop.localization.Language;
import com.cd.shop.product.ProductOutputDto;
import com.cd.shop.product.ProductService;
import com.cd.shop.product.category.ProductCategoryService;
import com.cd.shop.user.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;

    @GetMapping("/")
    public String index(Model model) {
        RequestContext requestContext = new RequestContext();
        requestContext.setLang(Language.UA);
        requestContext.setRequestedAt(Instant.now());
        requestContext.setSessionId(UUID.randomUUID().toString());
        requestContext.setUserId(null);

        var categories = productCategoryService.getPublishedCategories(requestContext);
        model.addAttribute("categories", categories);

        List<ProductOutputDto> popularProducts = productService.getMostPopular(8, requestContext);
        model.addAttribute("popularProducts", popularProducts);

        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/about")
    public String about() {
        return "contact";
    }

    @GetMapping("/delivery")
    public String delivery() {
        return "contact";
    }
}
