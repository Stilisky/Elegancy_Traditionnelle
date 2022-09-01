package com.elegancy.categoryservice.web;

import com.elegancy.categoryservice.dto.CategoryRequestDTO;
import com.elegancy.categoryservice.dto.CategoryResponseDTO;
import com.elegancy.categoryservice.services.CategoryService;
import com.elegancy.categoryservice.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CategoryRestAPI {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping(path = "/categories")
    public List<CategoryResponseDTO> allCategories(){
        return categoryService.allCategories();
    }

    @GetMapping(path = "/categories/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    /*@GetMapping(path = "/categories/{name}")
    public CategoryResponseDTO getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }*/

    @PostMapping(path = "/categories")
    public CategoryResponseDTO saveCategory(@RequestBody CategoryRequestDTO requestDTO){
        return  categoryService.saveCategory(requestDTO);
    }

    @DeleteMapping(path = "/categories/{id}")
    public void deleteCategoryByName(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> categoryException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
