package com.ebuy.shared.service;

import com.ebuy.shared.database.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(long id);

    void save(Category category);

    void deleteById(long id);

    boolean existsByName(String name);
}
