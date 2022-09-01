package com.elegancy.productservice.web;

import com.elegancy.productservice.dto.ProductRequestDTO;
import com.elegancy.productservice.dto.ProductResponseDTO;
import com.elegancy.productservice.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ProductRestAPI {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping(path = "products")
    public List<ProductResponseDTO> allProducts(){
        return productService.allProducts();
    }
    @GetMapping(path = "/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id){
        return productService.getProduct(id);
    }
    @PostMapping(path = "/products")
    public ProductResponseDTO saveProduct(@RequestBody ProductRequestDTO requestDTO){
        return productService.saveProduct(requestDTO);
    }
    @PutMapping(path = "/products/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO requestDTO){
        return productService.updateProduct(id, requestDTO);
    }
    @DeleteMapping(path = "/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
