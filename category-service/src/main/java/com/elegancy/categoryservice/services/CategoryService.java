package com.elegancy.categoryservice.services;

import com.elegancy.categoryservice.dto.CategoryRequestDTO;
import com.elegancy.categoryservice.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    public List<CategoryResponseDTO> allCategories();
    public CategoryResponseDTO getCategoryById(Long id);
    public CategoryResponseDTO getCategoryByName(String name);
    public CategoryResponseDTO saveCategory(CategoryRequestDTO requestDTO);
    void deleteCategory(Long id);
}
