package com.product.crudwebdemo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.crudwebdemo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
