package com.carlos.springboot.di.app.springboot_di.repositories;

import com.carlos.springboot.di.app.springboot_di.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {

  private List<Product> data;

  public ProductRepository() {
    this.data = Arrays.asList(
      new Product(1L, "Memoria corasir 32", 300L),
      new Product(2L, "CPU Intel Core i9", 850L),
      new Product(3L, "Teclado Razer 60%", 180L),
      new Product(4L, "Motherboard Gigabyte", 490L)
    );
  }

  public List<Product> findAll() {
    return data;
  }
}
