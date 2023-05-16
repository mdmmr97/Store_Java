package com.practicajava.store.application.service.impl;

import com.practicajava.store.application.dto.ItemDTO;
import com.practicajava.store.application.mapper.ItemMapper;
import com.practicajava.store.application.service.ItemService;
import com.practicajava.store.domain.entity.Item;
import com.practicajava.store.domain.persistence.ItemPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemPersistence persistence;
    private final ItemMapper mapper;

    @Autowired
    public ItemServiceImpl(ItemPersistence persistence, ItemMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = this.persistence.getAllItems();
        return this.mapper.toDto(items);
    }

    @Override
    public List<ItemDTO> getAllItemsByCategory(Long categoryId) {
        List<Item> items = this.persistence.getAllItemsByCategory(categoryId);
        return this.mapper.toDto(items);
    }

    @Override
    public Optional<ItemDTO> getItemById(Long itemId) {
        return this.persistence.getItemById(itemId).map(mapper::toDto);
    }

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        Item itemsave = this.persistence.saveItem(this.mapper.toEntity(itemDTO));
        return this.mapper.toDto(itemsave);
    }

    @Override
    public void deleteItem(Long itemId) {
        this.persistence.deleteItem(itemId);
    }
}
