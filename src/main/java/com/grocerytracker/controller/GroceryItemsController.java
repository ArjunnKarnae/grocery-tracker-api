package com.grocerytracker.controller;

import com.grocerytracker.dto.GroceryItem;
import com.grocerytracker.service.IGroceryItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GroceryItemsController {

    private final IGroceryItemsService groceryItemsService;

    @Autowired
    public GroceryItemsController(IGroceryItemsService groceryItemsService) {
        this.groceryItemsService = groceryItemsService;
    }

    @GetMapping("/grocery-items")
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems(){
        List<GroceryItem> groceryItems = this.groceryItemsService.getAllGroceryItems();
        return ResponseEntity.status(200).body(groceryItems);
    }

    @PostMapping("/grocery-items")
    public ResponseEntity<GroceryItem> addNewGroceryItem(@RequestBody GroceryItem groceryItem){
        GroceryItem groceryItemAdded = this.groceryItemsService.addNewGroceryItem(groceryItem);
        return ResponseEntity.status(201).body(groceryItemAdded);
    }

    @PutMapping("/grocery-items/update")
    public ResponseEntity<GroceryItem> updateGroceryItem(@RequestBody GroceryItem groceryItem){
        GroceryItem groceryItemUpdated = this.groceryItemsService.updateGroceryItem(groceryItem);
        return ResponseEntity.status(201).body(groceryItemUpdated);
    }

    @DeleteMapping("/grocery-items")
    public ResponseEntity<String> deleteGroceryItem(@RequestBody String groceryItemId){
        String deletedGroceryItemId = this.groceryItemsService.deleteGroceryItem(groceryItemId);
        return ResponseEntity.status(200).body(deletedGroceryItemId);
    }

    private List<GroceryItem> mockGroceryList(){
         List<GroceryItem> items = List.of(
                new GroceryItem("Milk", 1, new Date(), "Dairy", "Liters"),
                new GroceryItem("Eggs", 12, new Date(), "Dairy", "Count"),
                new GroceryItem("Apples", 6, new Date(), "Fruits", "Pieces"),
                new GroceryItem("Bread", 2, new Date(), "Bakery", "Loaves"),
                new GroceryItem("Chicken Breast", 1, new Date(), "Meat", "Kilograms"),
                new GroceryItem("Carrots", 5, new Date(), "Vegetables", "Pieces"),
                new GroceryItem("Rice", 2, new Date(), "Grains", "Kilograms"),
                new GroceryItem("Olive Oil", 1, new Date(), "Pantry", "Liters"),
                new GroceryItem("Cheddar Cheese", 1, new Date(), "Dairy", "Blocks"),
                new GroceryItem("Yogurt", 4, new Date(), "Dairy", "Cups"),
                new GroceryItem("Bananas", 6, new Date(), "Fruits", "Pieces"),
                new GroceryItem("Tomatoes", 4, new Date(), "Vegetables", "Pieces"),
                new GroceryItem("Ground Beef", 1, new Date(), "Meat", "Kilograms"),
                new GroceryItem("Cereal", 1, new Date(), "Pantry", "Boxes"),
                new GroceryItem("Orange Juice", 1, new Date(), "Beverages", "Liters")
        );
         return items;
    }
}
