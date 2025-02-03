package com.carlos.springboot.di.app.springboot_di.repositories;

import com.carlos.springboot.di.app.springboot_di.models.Product;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

  private List<Product> data;

  public ProductRepositoryImpl() {
    this.data = Arrays.asList(
      new Product(1L, "Memoria corasir 32", 300L),
      new Product(2L, "CPU Intel Core i9", 850L),
      new Product(3L, "Teclado Razer 60%", 180L),
      new Product(4L, "Motherboard Gigabyte", 490L)
    );
  }

  @Override
  public List<Product> findAll() {
    return this.data;
  }

  @Override
  public Product findById(Long id) {
    return this.data.stream()
      .filter(product -> product.getId().equals(id))
      .findFirst()
      .orElse(null);
  }
}
