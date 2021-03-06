package com.spier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement  
@SpringBootApplication
@EnableCaching
public class Start extends SpringBootServletInitializer{  
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	       return builder.sources(Start.class);
	 }
	 
	 public static void main(String[] args) {  
	      SpringApplication.run(Start.class, args);  
	  }  
}  