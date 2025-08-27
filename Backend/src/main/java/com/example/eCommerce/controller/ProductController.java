package com.example.eCommerce.controller;

import com.example.eCommerce.model.Product;
import com.example.eCommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> gellAllProducts(){
        List<Product> products=productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product=productService.getProductById(id);
        return ResponseEntity.ok(product);

    }

    @PostMapping("/products")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newproduct = productService.addProduct(product);
        return ResponseEntity.ok(newproduct);
    }
  @PutMapping("/{id}")
 // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){
        Product updateproduct = productService.updateProduct(id,product);
        return ResponseEntity.ok(updateproduct);
  }

  @DeleteMapping("/{id}")
  //@PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> deleteProduct(@PathVariable Long id){
         productService.deleteProduct(id);
         return ResponseEntity.ok("Product deleted successfully");
  }
}
