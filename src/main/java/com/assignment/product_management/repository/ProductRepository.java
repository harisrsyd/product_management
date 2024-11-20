package com.assignment.product_management.repository;

import com.assignment.product_management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
   
   @Query(value = "select * from products where name ilike '%name%' order by id", nativeQuery = true)
   public List<Product> findByName(String name);
}
