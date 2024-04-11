package com.niq.activate.service;

import com.niq.activate.entities.Product;
import com.niq.activate.entities.Shopper;

import java.util.List;

public interface ProductService {
    Shopper saveShoppersData(Shopper shopperData);

    Product saveProduct(Product product);

    List<Product> getProductsByFilters(String shopperId, String category, String brand, int limit);
}
