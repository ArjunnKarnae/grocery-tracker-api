package com.grocerytracker.mapper;

import com.grocerytracker.dto.GroceryItem;
import com.grocerytracker.entity.GroceryItemEntity;
import org.bson.types.ObjectId;

import java.util.Optional;

public class GroceryItemMapper {

    public static GroceryItemEntity mapGroceryItemToGroceryEntity(GroceryItem groceryItem){
        GroceryItemEntity groceryItemEntity = new GroceryItemEntity();
        groceryItemEntity.setName(groceryItem.getName());
        groceryItemEntity.setQuantity(groceryItem.getQuantity());
        groceryItemEntity.setCategory(groceryItem.getCategory());
        groceryItemEntity.setUnit(groceryItem.getUnit());
        groceryItemEntity.setExpirationDate(groceryItem.getExpirationDate());
        return groceryItemEntity;
    }

    public static GroceryItem mapGroceryItemEntityToGroceryItem(GroceryItemEntity groceryItemEntity){
        GroceryItem groceryItem = new GroceryItem();
        groceryItem.setId(groceryItemEntity.getId().toString());
        groceryItem.setName(groceryItemEntity.getName());
        groceryItem.setQuantity(groceryItemEntity.getQuantity());
        groceryItem.setCategory(groceryItemEntity.getCategory());
        groceryItem.setUnit(groceryItemEntity.getUnit());
        groceryItem.setExpirationDate(groceryItemEntity.getExpirationDate());
        return groceryItem;
    }


    public static GroceryItemEntity updateGroceryItemEntity(GroceryItemEntity fetchedGroceryItem, GroceryItem groceryItem) {
        fetchedGroceryItem.setName(groceryItem.getName());
        fetchedGroceryItem.setQuantity(groceryItem.getQuantity());
        fetchedGroceryItem.setCategory(groceryItem.getCategory());
        fetchedGroceryItem.setUnit(groceryItem.getUnit());
        fetchedGroceryItem.setExpirationDate(groceryItem.getExpirationDate());
        return fetchedGroceryItem;
    }
}
