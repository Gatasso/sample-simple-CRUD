package com.example.crud.domain.repository;

import com.example.crud.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByIsActiveTrue();
}
