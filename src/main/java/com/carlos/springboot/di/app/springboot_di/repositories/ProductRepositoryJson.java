package com.carlos.springboot.di.app.springboot_di.repositories;

import com.carlos.springboot.di.app.springboot_di.models.Product;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements ProductRepository {

  private List<Product> list;

  public ProductRepositoryJson() {
    Resource resource = new ClassPathResource("json/product.json");
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Product> findAll() {
    return this.list;
  }

  @Override
  public Product findById(Long id) {
    return list.stream()
      .filter(p -> p.getId().equals(id))
      .findFirst()
      .orElseThrow();
  }
}
