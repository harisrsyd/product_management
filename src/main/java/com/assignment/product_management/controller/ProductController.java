package com.assignment.product_management.controller;

import com.assignment.product_management.model.ProductRequest;
import com.assignment.product_management.model.ProductResponse;
import com.assignment.product_management.model.WebResponse;
import com.assignment.product_management.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
   
   private ProductService productService;
   
   public ProductController(ProductService productService) {
      this.productService = productService;
   }
   
   @GetMapping("api/products")
   public WebResponse<List<ProductResponse>> getAll() {
      List<ProductResponse> products = productService.getAllProducts();
      return WebResponse.<List<ProductResponse>>builder().status(HttpStatus.OK.value()).data(products).build();
   }
   
   @PostMapping("api/products")
   public WebResponse<ProductResponse> add(@RequestBody ProductRequest request) {
      return WebResponse.<ProductResponse>builder().status(HttpStatus.CREATED.value()).data(productService.addProduct(request)).build();
   }
   
   @GetMapping("api/products/{id}")
   public WebResponse<ProductResponse> get(@PathVariable Long id) {
      return WebResponse.<ProductResponse>builder().status(HttpStatus.OK.value()).data(productService.getProduct(id)).build();
   }
   
   @PutMapping("api/products/{id}")
   public WebResponse<ProductResponse> update(@PathVariable Long id, @RequestBody ProductRequest request) {
      return WebResponse.<ProductResponse>builder().status(HttpStatus.OK.value()).data(productService.updateProduct(id, request)).build();
   }
   
   @DeleteMapping("api/products/{id}")
   public WebResponse<String> delete(@PathVariable Long id) {
      productService.deleteProduct(id);
      return WebResponse.<String>builder().status(HttpStatus.OK.value()).data("Product data deleted Successfully").build();
   }
   
   @GetMapping("api/products/search")
   public WebResponse<List<ProductResponse>> search(@RequestParam String name) {
      List<ProductResponse> products = productService.searchProduct(name);
      if (CollectionUtils.isEmpty(products)) {
         String message = String.format("Product data with name '%s' not found", name);
         return WebResponse.<List<ProductResponse>>builder().status(HttpStatus.NOT_FOUND.value()).error(message).build();
      }
      return WebResponse.<List<ProductResponse>>builder().status(HttpStatus.OK.value()).data(products).build();
   }
}
