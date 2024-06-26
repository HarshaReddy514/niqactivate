package com.niq.activate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShopperNotFoundException extends RuntimeException{
    public ShopperNotFoundException(String message) {
        super(message);
    }
}
