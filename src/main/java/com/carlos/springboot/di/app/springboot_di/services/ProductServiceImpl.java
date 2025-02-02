package com.carlos.springboot.di.app.springboot_di.services;

import com.carlos.springboot.di.app.springboot_di.models.Product;
import com.carlos.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

  private ProductRepositoryImpl repository = new ProductRepositoryImpl();

  @Override
  public List<Product> findAll() {
    return repository.findAll().stream()
      .map(p -> {
        Product newProd = (Product) p.clone();
        double priceTax = p.getPrice() * 1.25d;
        newProd.setPrice((long) priceTax);
        return newProd;
      }).collect(Collectors.toList());
  }

  @Override
  public Product findById(Long id) {

    return repository.findById(id);
  }

}
