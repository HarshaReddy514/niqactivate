package com.niq.activate.repository;

import com.niq.activate.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, String> {

    Product findProductsByProductId(String productId);

}
