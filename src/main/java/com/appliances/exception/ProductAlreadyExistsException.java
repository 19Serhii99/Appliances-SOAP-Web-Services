package com.appliances.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException() {
        super("Product with the specified id already exists");
    }
}
