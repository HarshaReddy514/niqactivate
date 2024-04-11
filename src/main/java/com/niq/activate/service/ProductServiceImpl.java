package com.niq.activate.service;

import com.niq.activate.entities.Shelf;
import com.niq.activate.exceptions.ShopperNotFoundException;
import com.niq.activate.entities.Product;
import com.niq.activate.entities.Shopper;
import com.niq.activate.repository.ProductsRepository;
import com.niq.activate.repository.ShoppersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    ShoppersRepository shoppersRepository;

    @Override
    public Shopper saveShoppersData(Shopper shopperData) {
        return shoppersRepository.save(shopperData);
    }

    @Override
    public Product saveProduct(Product product) {
        return productsRepository.save(product);
    }

    @Override
    @Cacheable("filteredProducts")
    public List<Product> getProductsByFilters(String shopperId, String category, String brand, int limit) {
        Optional<Shopper> shopper = shoppersRepository.findByShopperId(shopperId);
        if(shopper.isEmpty()){
            throw new ShopperNotFoundException("Shopper with shopper id : " + shopperId + " is not found");
        } else {
            List<Shelf> shelf = shopper.get().getShelf();
            return shelf.stream().map(item -> productsRepository.findProductsByProductId(item.getProductId())).collect(Collectors.toList());
        }
    }
}
