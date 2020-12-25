package com.ebuy.shared.service.impl;

import com.ebuy.shared.database.entity.Category;
import com.ebuy.shared.database.repository.CategoryRepository;
import com.ebuy.shared.helper.exception.exceptions.ResourceNotFoundException;
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
            throw new ResourceNotFoundException("Category not found with id: "+ id);
        }
        return category;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(long id) {
        Category category = this.findById(id);
        category.setDeleted(true);
        this.save(category);
    }

    @Override
    public boolean existsByName(String name) {
        //return categoryRepository.existsByName(name);
        return false;
    }
}

