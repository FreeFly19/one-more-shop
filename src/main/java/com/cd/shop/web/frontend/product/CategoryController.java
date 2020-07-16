package com.cd.shop.web.frontend.product;

import com.cd.shop.product.category.ProductCategoryService;
import com.cd.shop.user.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class CategoryController {
    private final ProductCategoryService categoryService;

    @GetMapping("category/{id}")
    public String getCategoryById(@PathVariable Long id,
                                  Model model,
                                  RequestContext requestContext) {
        return categoryService.getById(id, requestContext)
                .map(ctg -> {
                    model.addAttribute("category", ctg);
                    return "category";
                })
                .orElse("not-found");
    }
}
