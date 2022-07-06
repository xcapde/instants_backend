package com.xevicorp1.marketplace.services;

import com.xevicorp1.marketplace.dto.ProductRequestDto;
import com.xevicorp1.marketplace.models.Product;
import com.xevicorp1.marketplace.models.User;

import java.util.List;

public interface IProductService{

    List<Product> getAll();

    Product create(ProductRequestDto productRequestDto, User authUser);
}
