package com.practicajava.store.domain.persistence;

import com.practicajava.store.domain.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistence {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long categoryId);
    Category saveCategory(Category category);
    void deleteCategory(Long categoryId);
    List<Category> getAllCategoriesByName(String partialName);
}
