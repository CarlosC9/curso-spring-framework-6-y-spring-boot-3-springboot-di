package com.carlos.springboot.di.app.springboot_di.repositories;

import com.carlos.springboot.di.app.springboot_di.models.Product;

import java.util.List;

public interface ProductRepository {

  List<Product> findAll();

  Product findById(Long id);

}
