package com.elegancy.productservice.service;


import com.elegancy.productservice.dto.ProductRequestDTO;
import com.elegancy.productservice.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    public List<ProductResponseDTO> allProducts();
    public ProductResponseDTO getProduct(Long id);
    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO);
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);
    public void deleteProduct(Long id);
}
