package com.niq.activate.endpoint;

import com.niq.activate.entities.Product;
import com.niq.activate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/external")
public class ExternalDataController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductsByFilters(@RequestParam String shopperId,
                                                              @RequestParam(required = false) String category,
                                                              @RequestParam(required = false) String brand,
                                                              @RequestParam(defaultValue = "10") int limit){
        List<Product> products = productService.getProductsByFilters(shopperId, category, brand, limit);
        return ResponseEntity.ok(products);
    }

}
