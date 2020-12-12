package com.ebuy.shared.database.repository;

import com.ebuy.shared.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByNameAsc();
    List<Product> findAllByIsDeletedTrue();
    List<Product> findAllByIsDeletedFalse();
}
