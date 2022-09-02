package com.elegancy.productservice.mappers;

import com.elegancy.productservice.dto.ProductRequestDTO;
import com.elegancy.productservice.dto.ProductResponseDTO;
import com.elegancy.productservice.entities.Product;
import org.mapstruct.Mapper;

public interface ProductMapper {
    public static Product productResponseDtoToProduct (ProductRequestDTO requestDTO){
        Product product = new Product();
        product.setName(requestDTO.getName());
        product.setQuantity(requestDTO.getQuantity());
        product.setPrice(requestDTO.getPrice());
        return product;
    }
    public static ProductResponseDTO productToProductResponseDto (Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setId(product.getId());
        responseDTO.setName(product.getName());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setQuantity(product.getQuantity());
        return responseDTO;
    }
}
