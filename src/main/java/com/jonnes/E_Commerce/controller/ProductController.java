package com.jonnes.E_Commerce.controller;


import com.jonnes.E_Commerce.model.Product;
import com.jonnes.E_Commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity(product, HttpStatus.ACCEPTED);
        }
        else{
            return  new ResponseEntity<>(product,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product savedproduct = null;
        try {
            savedproduct = productService.addProduct(product,imageFile);
            return new ResponseEntity<>(savedproduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("product/{id}/image")
    public  ResponseEntity<byte[]> getProductImage(@PathVariable int id){
        Product product=productService.getProductById(id);
        return new ResponseEntity<>(product.getImagedata(), HttpStatus.OK);
    }
    @PutMapping("/product/update/{id}")
    public  ResponseEntity<String> updateProduct(@PathVariable int id,Product product, @RequestPart MultipartFile imageFile){
        Product updateproduct = null;
        try {
            updateproduct = productService.updateProduct(product,imageFile);
            return new ResponseEntity<>("updated", HttpStatus.ACCEPTED);
        } catch (IOException e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
