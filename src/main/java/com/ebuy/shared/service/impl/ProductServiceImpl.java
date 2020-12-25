package com.ebuy.shared.service.impl;

import com.ebuy.shared.database.entity.Category;
import com.ebuy.shared.database.entity.Product;
import com.ebuy.shared.database.repository.ProductRepository;
import com.ebuy.shared.helper.exception.exceptions.ResourceNotFoundException;
import com.ebuy.shared.service.CategoryService;
import com.ebuy.shared.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAllByIsDeletedFalse();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        Product product = null;
        if (result.isPresent()) {
            product = result.get();
        } else {
            throw new ResourceNotFoundException("Product not found with id: "+ id);
        }
        return product;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        Product product = this.findById(id);
        product.setDeleted(true);
        this.save(product);
    }

    public String existingSize(Long id){
//        String sizeName = productRepository.getSizeNameById(id);
        return productRepository.getSizeNameById(id);
    }


}
