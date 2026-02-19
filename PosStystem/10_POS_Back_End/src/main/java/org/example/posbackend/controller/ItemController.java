package org.example.posbackend.controller;

import jakarta.validation.Valid;
import org.example.posbackend.Util.ApiResponse;
import org.example.posbackend.dto.ItemDto;
import org.example.posbackend.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemServiceImpl itemService;

    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ApiResponse<String>> saveItem(@RequestBody @Valid ItemDto itemDto) {
        itemService.saveItem(itemDto);
        return new ResponseEntity<>(new ApiResponse<>(
                201,"Item Updated" , null)
                , HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<ApiResponse<String>> updateItem(@RequestBody ItemDto itemDto) {
        itemService.updateItem(itemDto);
        return new ResponseEntity<>(new ApiResponse<>(
                201,"Item Updated" , null)
                , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(new ApiResponse<>(
                201,"Item Delete" , null)
                , HttpStatus.CREATED);
    }
    @GetMapping
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable String id) {
        return itemService.searchItem(id);
    }

}
