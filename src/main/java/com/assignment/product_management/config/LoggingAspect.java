package com.assignment.product_management.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
   
   private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
   
   @Pointcut("execution(* com.assignment.product_management.service.*.*(..))")
   public void serviceLayer() {
   }
   
   @Before("serviceLayer()")
   public void logServiceLayer() {
      LOGGER.info("Service layer method execution started");
   }
   
   @After("serviceLayer()")
   public void logServiceLayerAfter() {
      LOGGER.info("Service layer method execution completed");
   }
}
