package com.xevicorp1.marketplace.controllers;

import com.xevicorp1.marketplace.dto.ProductRequestDto;
import com.xevicorp1.marketplace.models.Product;
import com.xevicorp1.marketplace.models.User;
import com.xevicorp1.marketplace.services.IProductService;
import com.xevicorp1.marketplace.services.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    private IProductService productService;
    private IUserService userService;

    public ProductController(IProductService productService, IUserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/products")
    List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping("/products")
    Product create(@RequestBody ProductRequestDto productRequest){
        var authUser = getAuthUser();
        return productService.create(productRequest, authUser);
    }

    private User getAuthUser() {
        return userService.getById(1L);
    }
}
