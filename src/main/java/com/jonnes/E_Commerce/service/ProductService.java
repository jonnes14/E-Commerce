package com.jonnes.E_Commerce.service;

import com.jonnes.E_Commerce.model.Product;
import com.jonnes.E_Commerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
   private  ProductRepo productRepo;

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(new Product());
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImagename(image.getOriginalFilename());
        product.setImagetype(image.getContentType());
        product.setImagedata(image.getBytes());
        return productRepo.save(product);
    }


    public Product updateProduct(Product product, MultipartFile image) throws IOException {
        product.setImagename(image.getOriginalFilename());
        product.setImagetype(image.getContentType());
        product.setImagedata(image.getBytes());
        return productRepo.save(product);
    }
}
