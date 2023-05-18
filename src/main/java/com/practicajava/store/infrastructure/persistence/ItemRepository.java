package com.practicajava.store.infrastructure.persistence;


import com.practicajava.store.domain.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCategoryId(Long id);
    Page<Item> findAll(Specification<Item> specification, Pageable pageable);
}
