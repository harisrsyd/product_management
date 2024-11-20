package com.assignment.product_management.model;

import com.assignment.product_management.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
   
   private Long id;
   
   private String name;
   
   private Double price;
   
   private String category;
   
   private String description;
}
