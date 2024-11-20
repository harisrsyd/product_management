package com.assignment.product_management.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ValidationService {
   
   private Validator validator;
   
   public ValidationService(Validator validator) {
      this.validator = validator;
   }
   
   public void validate(Object object) {
      Set<ConstraintViolation<Object>> violations = validator.validate(object);
      if (!violations.isEmpty()) {
         throw new ConstraintViolationException(violations);
      }
   }
}
