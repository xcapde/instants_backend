package com.xevicorp1.marketplace.services;

import com.xevicorp1.marketplace.dto.ProductRequestDto;
import com.xevicorp1.marketplace.models.Product;
import com.xevicorp1.marketplace.models.User;
import com.xevicorp1.marketplace.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductRequestDto productRequestDto, User auth) {
        return null;
    }
}
