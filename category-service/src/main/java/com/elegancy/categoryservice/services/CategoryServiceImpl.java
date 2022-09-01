package com.elegancy.categoryservice.services;

import com.elegancy.categoryservice.dto.CategoryRequestDTO;
import com.elegancy.categoryservice.dto.CategoryResponseDTO;
import com.elegancy.categoryservice.entities.Category;
import com.elegancy.categoryservice.exceptions.CategoryAlreadyExistException;
import com.elegancy.categoryservice.exceptions.CategoryNotFoundException;
import com.elegancy.categoryservice.mappers.CategoryMapper;
import com.elegancy.categoryservice.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDTO> allCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryResponseDTO> responseDTOList = new ArrayList<>();
        categories.forEach(category ->
                responseDTOList.add(categoryMapper.categoryToCategoryResponseDTO(category))
                );
        return responseDTOList;
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category;
        try {
            category = categoryRepo.findById(id).get();
        } catch (Exception e){
            throw new CategoryNotFoundException("Cette catégorie est introuvable!");
        }
        return categoryMapper.categoryToCategoryResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO getCategoryByName(String name) {
        Category category;
        try {
            category = categoryRepo.findByCatName(name);
        } catch (Exception e){
            throw new CategoryNotFoundException("Cette catégorie est introuvable!");
        }
        return categoryMapper.categoryToCategoryResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO saveCategory(CategoryRequestDTO requestDTO) {
        Category cat= categoryMapper.categoryRequestDTOToCategory(requestDTO);
        if(categoryRepo.findByCatName(cat.getCatName()) != null){
            throw new CategoryAlreadyExistException("Cette catégorie existe déjà!");
        }
        Category catsave = categoryRepo.save(cat);
        return categoryMapper.categoryToCategoryResponseDTO(catsave);
    }

    @Override
    public void deleteCategory(Long id) {
         categoryRepo.deleteById(id);
    }
}
