package com.ebuy.shared.service;



import com.ebuy.shared.database.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void deleteById(Long id);
}
