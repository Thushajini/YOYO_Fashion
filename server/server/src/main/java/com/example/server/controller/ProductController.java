package com.example.server.controller;

import com.example.server.entity.Product;
import com.example.server.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {


    private ProductService productService;
    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> product = productService.getAllProducts();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId){
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);

    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(
            @ModelAttribute Product product,
            @RequestParam("proImage") MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {
            String filename = file.getOriginalFilename();
            Path path = Paths.get(uploadDirectory, filename);
            Files.write(path, file.getBytes());

           
            product.setImage(filename);
        }

        // save product
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }


    }
