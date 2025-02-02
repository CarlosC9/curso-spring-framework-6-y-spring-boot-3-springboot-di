package com.carlos.springboot.di.app.springboot_di.services;

import com.carlos.springboot.di.app.springboot_di.models.Product;
import com.carlos.springboot.di.app.springboot_di.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

  private ProductRepository repository = new ProductRepository();

  public List<Product> findAll() {
    return repository.findAll().stream()
      .map(p -> {
        Product newProd = (Product) p.clone();
        double priceTax = p.getPrice() * 1.25d;
        newProd.setPrice((long) priceTax);
        return newProd;
      }).collect(Collectors.toList());
  }

  public Product findById(Long id) {

    return repository.findById(id);
  }

}
