//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.07 at 09:08:31 PM EET 
//


package com.appliances.model.products;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.appliances.products package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.appliances.products
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAllProductsRequest }
     * 
     */
    public FindAllProductsRequest createFindAllProductsRequest() {
        return new FindAllProductsRequest();
    }

    /**
     * Create an instance of {@link FindProductsByNameRequest }
     * 
     */
    public FindProductsByNameRequest createFindProductsByNameRequest() {
        return new FindProductsByNameRequest();
    }

    /**
     * Create an instance of {@link FindProductByIdRequest }
     * 
     */
    public FindProductByIdRequest createFindProductByIdRequest() {
        return new FindProductByIdRequest();
    }

    /**
     * Create an instance of {@link CreateProductRequest }
     * 
     */
    public CreateProductRequest createCreateProductRequest() {
        return new CreateProductRequest();
    }

    /**
     * Create an instance of {@link UpdateProductRequest }
     * 
     */
    public UpdateProductRequest createUpdateProductRequest() {
        return new UpdateProductRequest();
    }

    /**
     * Create an instance of {@link DeleteProductRequest }
     * 
     */
    public DeleteProductRequest createDeleteProductRequest() {
        return new DeleteProductRequest();
    }

    /**
     * Create an instance of {@link ProductListResponse }
     * 
     */
    public ProductListResponse createProductListResponse() {
        return new ProductListResponse();
    }

    /**
     * Create an instance of {@link CreatedIdResponse }
     * 
     */
    public CreatedIdResponse createCreatedIdResponse() {
        return new CreatedIdResponse();
    }

    /**
     * Create an instance of {@link FindProductByIdResponse }
     * 
     */
    public FindProductByIdResponse createFindProductByIdResponse() {
        return new FindProductByIdResponse();
    }

}
