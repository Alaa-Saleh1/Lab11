package com.example.blog_system_lab11.Service;

import com.example.blog_system_lab11.ApiResponse.ApiException;
import com.example.blog_system_lab11.Model.Category;
import com.example.blog_system_lab11.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id, Category category) {
        Category oldCategory = categoryRepository.findCategoryById(id);
        if (oldCategory == null) {
            throw new ApiException("Category not found");
        }

        oldCategory.setName(category.getName());
        categoryRepository.save(oldCategory);
    }

    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findCategoryById(id);
        if (category == null) {
            throw new ApiException("Category not found");
        }
        categoryRepository.delete(category);
    }
}
