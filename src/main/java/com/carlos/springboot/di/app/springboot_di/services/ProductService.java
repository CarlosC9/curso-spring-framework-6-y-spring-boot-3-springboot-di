package com.carlos.springboot.di.app.springboot_di.services;

import com.carlos.springboot.di.app.springboot_di.models.Product;
import com.carlos.springboot.di.app.springboot_di.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

  private ProductRepository repository = new ProductRepository();

  public List<Product> findAll() {
    return repository.findAll().stream()
      .peek(p -> {
        double priceImp = p.getPrice() * 1.25d;
        p.setPrice((long) priceImp);
      }).collect(Collectors.toList());
  }

  public Product fundById(Long id) {

    return repository.findById(id);
  }

}
