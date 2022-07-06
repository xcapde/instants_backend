package com.xevicorp1.marketplace.repositories;

import com.xevicorp1.marketplace.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
