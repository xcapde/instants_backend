package com.xevicorp1.marketplace.controllers;

import com.xevicorp1.marketplace.models.Product;
import com.xevicorp1.marketplace.services.IProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    List<Product> getAll() {
        return productService.getAll();
    }
}
