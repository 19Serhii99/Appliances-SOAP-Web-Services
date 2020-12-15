package com.appliances.endpoint;

import com.appliances.exception.ProductNotFoundException;
import com.appliances.model.entity.Product;
import com.appliances.model.products.*;
import com.appliances.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductEndpoint {

    private static final String NAMESPACE = "http://appliances.org/products";

    ProductRepository repository;

    @PayloadRoot(namespace = NAMESPACE, localPart = "findAllProductsRequest")
    @ResponsePayload
    public ProductListResponse findAll() {
        return new ProductListResponse(repository.findAll());
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "findProductsByNameRequest")
    @ResponsePayload
    public ProductListResponse findByName(@RequestPayload FindProductsByNameRequest request) {
        return new ProductListResponse(repository.findByName(request.getName()));
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "findProductByIdRequest")
    @ResponsePayload
    public FindProductByIdResponse findOneById(@RequestPayload FindProductByIdRequest request) {
        Product product = repository.findOneById(request.getProductId())
                .orElseThrow(ProductNotFoundException::new);
        return new FindProductByIdResponse(product);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "createProductRequest")
    @ResponsePayload
    public CreatedIdResponse create(@RequestPayload CreateProductRequest request) {
        int id = repository.create(request.getProduct());
        return new CreatedIdResponse(id);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "updateProductRequest")
    @ResponsePayload
    public void update(@RequestPayload UpdateProductRequest request) {
        repository.update(request.getProduct());
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "deleteProductRequest")
    @ResponsePayload
    public void delete(@RequestPayload DeleteProductRequest request) {
        repository.delete(request.getProductId());
    }
}
