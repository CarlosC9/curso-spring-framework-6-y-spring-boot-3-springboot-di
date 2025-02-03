package com.carlos.springboot.di.app.springboot_di.services;

import com.carlos.springboot.di.app.springboot_di.models.Product;
import com.carlos.springboot.di.app.springboot_di.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository repository;

  private double tax;

  public ProductServiceImpl(
    @Qualifier("productJson") ProductRepository repository,
    @Value("${config.price.tax}") double tax
  ) {
    this.repository = repository;
    this.tax = tax;
  }

  @Override
  public List<Product> findAll() {
    return repository.findAll().stream()
      .map(p -> {
        double priceTax = p.getPrice() * tax;

        Product newProd = (Product) p.clone();
        newProd.setPrice((long) priceTax);
        return newProd;

//        p.setPrice((long) priceTax);
//        return p;

      }).collect(Collectors.toList());
  }

  @Override
  public Product findById(Long id) {
    return repository.findById(id);
  }

}
