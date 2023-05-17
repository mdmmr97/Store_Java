package com.practicajava.store.infrastructure.persistence;


import com.practicajava.store.domain.entity.Item;
import com.practicajava.store.infrastructure.specs.ItemSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCategoryId(Long id);

    Page<Item> findAll(ItemSpecification specification, Pageable pageable);
}
