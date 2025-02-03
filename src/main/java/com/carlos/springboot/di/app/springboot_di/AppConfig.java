package com.carlos.springboot.di.app.springboot_di;

import com.carlos.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.carlos.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
  @PropertySource(value = "classpath:config.properties")
})
public class AppConfig {

  @Bean("productJson")
  ProductRepository productRepositoryJson() {
    return new ProductRepositoryJson();
  }

}
