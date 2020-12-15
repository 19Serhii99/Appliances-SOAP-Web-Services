package com.appliances.repository;

import com.appliances.exception.ProductAlreadyExistsException;
import com.appliances.exception.ProductNotFoundException;
import com.appliances.model.entity.Product;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ProductRepository {

    private static final Map<Integer, Product> products = new ConcurrentHashMap<>();

    private static int autoincrement = 0;

    @PostConstruct
    private void initDefaultBrands() {
        String[] brands = new String[] { "Samsung", "Sharp", "Candy" };

        IntStream.range(0, 3).forEach(index -> {
            Product product = Product.builder()
                    .id(++autoincrement)
                    .name(String.format("Product %d", autoincrement))
                    .price(ThreadLocalRandom.current().nextDouble(1000.0, 100000.0))
                    .amount(ThreadLocalRandom.current().nextLong(1, 100))
                    .width(ThreadLocalRandom.current().nextDouble(1.0, 10.0))
                    .height(ThreadLocalRandom.current().nextDouble(1.0, 10.0))
                    .depth(ThreadLocalRandom.current().nextDouble(1.0, 10.0))
                    .weight(ThreadLocalRandom.current().nextDouble(1.0, 10.0))
                    .brand(brands[ThreadLocalRandom.current().nextInt(0, brands.length)])
                    .build();
            products.put(product.getId(), product);
        });
    }

    public int create(Product product) {
        if (products.containsKey(product.getId())) throw new ProductAlreadyExistsException();

        product.setId(++autoincrement);
        products.put(autoincrement, product);

        return autoincrement;
    }

    public void update(Product product) {
        if (!products.containsKey(product.getId())) throw new ProductNotFoundException();
        products.put(product.getId(), product);
    }

    public void delete(int id) {
        if (!products.containsKey(id)) throw new ProductNotFoundException();
        products.remove(id);
    }

    public List<Product> findByName(String name) {
        if (Strings.isEmpty(name)) return findAll();

        return products.values().stream()
                .filter(product -> product.getName().contains(name))
                .collect(Collectors.toList());
    }

    public List<Product> findAll() {
        return List.copyOf(products.values());
    }

    public Optional<Product> findOneById(int id) {
        return Optional.ofNullable(products.get(id));
    }
}
