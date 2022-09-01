package com.elegancy.categoryservice.mappers;

import com.elegancy.categoryservice.dto.CategoryRequestDTO;
import com.elegancy.categoryservice.dto.CategoryResponseDTO;
import com.elegancy.categoryservice.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    public Category categoryRequestDTOToCategory(CategoryRequestDTO requestDTO);
    public CategoryResponseDTO categoryToCategoryResponseDTO(Category category);
}
