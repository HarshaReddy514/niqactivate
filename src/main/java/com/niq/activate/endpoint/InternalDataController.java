package com.niq.activate.endpoint;

import com.niq.activate.entities.Product;
import com.niq.activate.entities.Shopper;
import com.niq.activate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/internal")
public class InternalDataController {

    @Autowired
    ProductService productService;

    /*
    * This endpoint will save the shoppers data assuming the data will be as in the format of given in task file
    * Can be customized later in case the data is list of objects*/
    @PostMapping("/shoppers")
    public ResponseEntity<Shopper> saveShoppersData(@RequestBody Shopper shopperData){
        Shopper shopper = productService.saveShoppersData(shopperData);
        return new ResponseEntity<>(shopper, HttpStatus.CREATED);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

}
