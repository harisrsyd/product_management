package com.assignment.product_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
public class ProductManagementApplication {
   
   public static void main(String[] args) {
      SpringApplication.run(ProductManagementApplication.class, args);
   }
   
}
