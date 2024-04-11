package com.niq.activate.repository;

import com.niq.activate.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, String> {

    Product findProductsByProductId(String productId);

    List<Product> findProductByCategoryAndBrand(String category, String brand, Pageable pageable);
}
