package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.web.frontend;

import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.localization.Language;
import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.product.category.ProductCategoryOutputDto;
import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.product.category.ProductCategoryService;
import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.user.RequestContext;
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
    private final ProductCategoryService productCategoryService;

    @GetMapping("/")
    public String index(Model model) {
        RequestContext requestContext = new RequestContext();
        requestContext.setLang(Language.UA);
        requestContext.setRequestedAt(Instant.now());
        requestContext.setSessionId(UUID.randomUUID().toString());
        requestContext.setUser(null);

        var categories = productCategoryService.getPublishedCategories(requestContext);
        model.addAttribute("categories", categories);
        return "index";
    }
}
