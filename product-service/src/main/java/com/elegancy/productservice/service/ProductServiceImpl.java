package com.elegancy.productservice.service;

import com.elegancy.productservice.dto.ProductRequestDTO;
import com.elegancy.productservice.dto.ProductResponseDTO;
import com.elegancy.productservice.entities.Product;
import com.elegancy.productservice.exceptions.ProductAlreadyExistException;
import com.elegancy.productservice.exceptions.ProductNotFoundException;
import com.elegancy.productservice.mappers.ProductMapper;
import com.elegancy.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponseDTO> allProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> responseDTOS = new ArrayList<>();
        products.forEach(product ->
                responseDTOS.add(productMapper.productToProductResponseDto(product)));
        return responseDTOS;
    }

    @Override
    public ProductResponseDTO getProduct(Long id) {
        Product prod;
        try {
            prod = productRepository.findById(id).get();
        }catch (Exception e){
            throw new ProductNotFoundException("L'article demandé n'existe pas!");
        }
        return productMapper.productToProductResponseDto(prod);
    }

    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) {
        Product product = productMapper.productResponseDtoToProduct(productRequestDTO);
        if(productRepository.findByName(product.getName()) != null){
            throw new ProductAlreadyExistException("Ce t'article existe déjà!");
        }
        Product prodsave = productRepository.save(product);
        return productMapper.productToProductResponseDto(prodsave);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Product product;
        try {
            product = productRepository.findById(id).get();
        }catch (Exception e){
            throw new ProductNotFoundException("L'article ne peut être mis à jours car introuvable!");
        }
        if(product.getName() != productRequestDTO.getName()){
            product.setName(productRequestDTO.getName());
        }
        if(product.getPrice() != productRequestDTO.getPrice()){
            product.setPrice(productRequestDTO.getPrice());
        }
        if(product.getQuantity() != productRequestDTO.getQuantity()){
            product.setQuantity(productRequestDTO.getQuantity());
        }

        return productMapper.productToProductResponseDto(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
