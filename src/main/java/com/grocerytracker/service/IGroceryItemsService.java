package com.grocerytracker.service;

import com.grocerytracker.dto.GroceryItem;

import java.util.List;

public interface IGroceryItemsService {

    public List<GroceryItem> getAllGroceryItems();

    GroceryItem addNewGroceryItem(GroceryItem groceryItem);

    String deleteGroceryItem(String groceryItemId);

    GroceryItem updateGroceryItem(GroceryItem groceryItem);
}
