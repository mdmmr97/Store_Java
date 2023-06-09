package com.practicajava.store.application.service;

import com.practicajava.store.application.dto.ItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemDTO> getAllItems();
    List<ItemDTO> getAllItemsByCategory(Long categoryId);
    Optional<ItemDTO> getItemById(Long itemId);
    ItemDTO saveItem(ItemDTO itemDTO);
    void deleteItem(Long itemId);
    Page<ItemDTO> getItemsByCriteriaStringPaged(Pageable pageable, String filter);
}
