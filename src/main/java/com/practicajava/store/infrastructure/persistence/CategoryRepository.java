package com.practicajava.store.infrastructure.persistence;

import com.practicajava.store.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameContainsIgnoreCase(String name);
}
