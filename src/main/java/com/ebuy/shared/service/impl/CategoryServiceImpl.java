package com.ebuy.shared.service.impl;

import com.ebuy.shared.database.entity.Category;
import com.ebuy.shared.database.repository.CategoryRepository;
import com.ebuy.shared.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAllByIsDeletedFalse();
    }

    @Override
    public Category findById(long id) {
        Optional<Category> result = categoryRepository.findById(id);
        Category category = null;
        if (result.isPresent()) {
            category = result.get();
        } else {
            throw new RuntimeException("Did not find employee category");
        }
        return category;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(long id) {
    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }
}

