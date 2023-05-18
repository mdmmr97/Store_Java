package com.practicajava.store.infrastructure.rest;

import com.practicajava.store.application.dto.ItemDTO;
import com.practicajava.store.application.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemRestController {
    private final ItemService itemService;

    @Autowired
    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping(value = "/items-old", produces = "application/json")
    ResponseEntity<List<ItemDTO>> getAllItems(){
        List<ItemDTO> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/items", produces = "application/json")
    ResponseEntity<List<ItemDTO>> getItemsByCriteriaPaged(@RequestParam(value = "filter") String filter, Pageable pageable){
        List<ItemDTO> items = itemService.getItemsByCriteriaStringPaged(pageable, filter);
        return new ResponseEntity<List<ItemDTO>>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/categories/{idCategory}/items", produces = "application/json")
    ResponseEntity<List<ItemDTO>> getAllItemsFromCategory(@PathVariable long idCategory){
        List<ItemDTO> items = itemService.getAllItemsByCategory(idCategory);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/items", produces = "application/json", consumes = "application/json")
    ResponseEntity<ItemDTO> insertItem(@RequestBody ItemDTO itemDTO){
       ItemDTO itemSaved = this.itemService.saveItem(itemDTO);
       return new ResponseEntity<>(itemSaved,HttpStatus.CREATED);
    }
}
