package com.carlos.springboot.di.app.springboot_di;

import com.carlos.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.carlos.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;

@Configuration
@PropertySources({
  @PropertySource(value = "classpath:config.properties")
})
public class AppConfig {

  @Value("classpath:json/product.json")
  private Resource resource;

  @Bean("productJson")
  ProductRepository productRepositoryJson() {
    return new ProductRepositoryJson(resource);
  }

}
