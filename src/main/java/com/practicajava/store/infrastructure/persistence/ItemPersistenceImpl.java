package com.practicajava.store.infrastructure.persistence;

import com.practicajava.store.domain.entity.Item;
import com.practicajava.store.domain.persistence.ItemPersistence;
import com.practicajava.store.infrastructure.specs.ItemSpecification;
import com.practicajava.store.infrastructure.specs.shared.SearchCriteriaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemPersistenceImpl implements ItemPersistence {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemPersistenceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

    @Override
    public List<Item> getAllItemsByCategory(Long categoryId) {
        return this.itemRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public Optional<Item> getItemById(Long itemId) {
        return this.itemRepository.findById(itemId);
    }

    @Override
    public Item saveItem(Item item) {
        return this.itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        this.itemRepository.deleteById(itemId);
    }

    @Override
    public Page<Item> findAll(Pageable pageable, String filter) {
        ItemSpecification specification = new ItemSpecification(SearchCriteriaHelper.fromFilterString(filter));
        return this.itemRepository.findAll(specification, pageable);
    }
}
