package com.example.stocksystem.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
  
  @Autowired
  private ItemRepository itemRepository;

  @PostMapping
  public ResponseEntity<ItemCreateResponse> createItem(@RequestBody ItemRequestPayload payload) {
    Item newItem = new Item(payload);

    this.itemRepository.save(newItem);

    return ResponseEntity.ok(new ItemCreateResponse(newItem.getId()));
  }
}
