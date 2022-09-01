package com.elegancy.productservice.mappers;

import com.elegancy.productservice.dto.ProductRequestDTO;
import com.elegancy.productservice.dto.ProductResponseDTO;
import com.elegancy.productservice.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product fromProductResponseDTO (ProductRequestDTO productRequestDTO);
    ProductResponseDTO fromProduct (Product product);
}