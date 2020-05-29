package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.web.frontend.product;

import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.localization.Language;
import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.product.ProductService;
import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.user.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public String index(@PathVariable Long id, Model model) {
        RequestContext requestContext = new RequestContext();
        requestContext.setLang(Language.UA);
        requestContext.setRequestedAt(Instant.now());
        requestContext.setSessionId(UUID.randomUUID().toString());
        requestContext.setUser(null);

        var product = productService.findById(id, requestContext);
        model.addAttribute("product", product);
        return "product";
    }
}
