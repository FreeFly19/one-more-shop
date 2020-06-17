package com.cd.shop.product;

import com.cd.shop.dataintegration.ExcelProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestProductController {
    private final ProductService productService;

    @PostMapping("/api/excel-products")
    public void importFromExcel(ExcelProduct excelProduct) {
        productService.createProductFromExcel(excelProduct);
    }
}
