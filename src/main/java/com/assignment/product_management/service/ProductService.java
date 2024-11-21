package com.assignment.product_management.service;

import com.assignment.product_management.entity.Product;
import com.assignment.product_management.model.ProductRequest;
import com.assignment.product_management.model.ProductResponse;
import com.assignment.product_management.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
   
   private ProductRepository productRepository;
   
   private ValidationService validationService;
   
   public ProductService(ProductRepository productRepository, ValidationService validationService) {
      this.productRepository = productRepository;
      this.validationService = validationService;
   }
   
   @CacheEvict(value = "products", allEntries = true)
   public ProductResponse addProduct(ProductRequest request) {
      validationService.validate(request);
      Product product = new Product();
      product.setName(request.getName());
      product.setPrice(request.getPrice());
      product.setCategory(request.getCategory());
      product.setDescription(request.getDescription());
      productRepository.save(product);
      
      return toProductResponse(product);
   }
   
   public ProductResponse toProductResponse(Product product) {
      return ProductResponse.builder()
          .id(product.getId())
          .name(product.getName())
          .price(product.getPrice())
          .category(product.getCategory())
          .description(product.getDescription())
          .build();
   }
   
   public List<ProductResponse> getAllProducts() {
      List<Product> products = productRepository.findAll();
      return products.stream()
          .map(this::toProductResponse)
          .collect(Collectors.toList());
   }
   
   public ProductResponse getProduct(Long id) {
      Product product = productRepository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product data not found"));
      return toProductResponse(product);
   }
   
   @CachePut(value = "products", key = "#id")
   public ProductResponse updateProduct(Long id, ProductRequest request) {
      validationService.validate(request);
      Product product = productRepository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product data not found"));
      product.setName(request.getName());
      product.setPrice(request.getPrice());
      product.setCategory(request.getCategory());
      product.setDescription(request.getDescription());
      
      productRepository.save(product);
      
      return toProductResponse(product);
   }
   
   @CacheEvict(value = "products", allEntries = true)
   public void deleteProduct(Long id) {
      Product product = productRepository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product data not found"));
      productRepository.delete(product);
   }
   
   @Cacheable(value = "products", key = "#name")
   public List<ProductResponse> searchProduct(String name) {
      List<Product> products = productRepository.findByName(name);
      return products.stream()
          .map(this::toProductResponse)
          .collect(Collectors.toList());
   }
}
