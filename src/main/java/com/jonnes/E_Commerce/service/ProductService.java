package com.jonnes.E_Commerce.service;

import com.jonnes.E_Commerce.model.Product;
import com.jonnes.E_Commerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
   private  ProductRepo productRepo;

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }
}
