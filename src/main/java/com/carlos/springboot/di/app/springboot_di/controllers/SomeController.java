package com.carlos.springboot.di.app.springboot_di.controllers;

import com.carlos.springboot.di.app.springboot_di.models.Product;
import com.carlos.springboot.di.app.springboot_di.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

  private ProductService service = new ProductService();

  @GetMapping
  public List<Product> list() {
    return this.service.findAll();
  }

  @GetMapping("/{id}")
  public Product show(
    @PathVariable Long id
  ) {
    return this.service.findById(id);
  }
}
