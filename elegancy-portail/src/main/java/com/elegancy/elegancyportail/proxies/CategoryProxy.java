package com.elegancy.elegancyportail.proxies;

import com.elegancy.elegancyportail.beans.CategoryBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ZUUL-SERVER")
public interface CategoryProxy {
    @GetMapping(path = "/category-service/api/categories")
    public List<CategoryBean> allCategories();
    @GetMapping(path = "/category-service/api/categories/{id}")
    public CategoryBean getCategoryById(@PathVariable Long id);
    @PostMapping(path = "/category-service/api/categories")
    public CategoryBean saveCategory(@RequestBody CategoryBean requestDTO);
    @DeleteMapping(path = "/category-service/api/categories/{id}")
    public void deleteCategoryByName(@PathVariable Long id);
}
