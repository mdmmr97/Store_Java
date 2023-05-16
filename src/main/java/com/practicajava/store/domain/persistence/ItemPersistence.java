package com.practicajava.store.domain.persistence;

import com.practicajava.store.domain.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemPersistence {
    List<Item> getAllItems();
    List<Item> getAllItemsByCategory(Long categoryId);
    Optional<Item> getItemById(Long itemId);
    Item saveItem(Item item);
    void deleteItem(Long itemId);
}
