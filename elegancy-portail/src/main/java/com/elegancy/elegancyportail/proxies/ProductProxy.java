package com.elegancy.elegancyportail.proxies;

import com.elegancy.elegancyportail.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ZUUL-SERVER")
public interface ProductProxy {
    @GetMapping(path = "/product-service/api/products")
    public List<ProductBean> allProducts();
    @GetMapping(path = "/product-service/api/product-service/api/products/{id}")
    public ProductBean getProductById(@PathVariable Long id);
    @PostMapping(path = "/product-service/api/products")
    public ProductBean saveProduct(@RequestBody ProductBean requestDTO);
    @PutMapping(path = "/product-service/api/products/{id}")
    public ProductBean updateProduct(@PathVariable Long id, @RequestBody ProductBean requestDTO);
    @DeleteMapping(path = "/product-service/api/products/{id}")
    public void deleteProduct(@PathVariable Long id);

}
