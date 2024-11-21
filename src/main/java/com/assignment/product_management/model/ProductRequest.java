package com.assignment.product_management.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
   
   @NotBlank
   @Size(max = 100)
   private String name;
   
   @NotNull
   private Double price;
   
   @NotBlank
   @Size(max = 100)
   private String category;
   
   private String description;
}
