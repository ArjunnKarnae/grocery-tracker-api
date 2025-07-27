package com.grocerytracker.service;

import Exceptions.GroceryItemNotFoundException;
import com.grocerytracker.dto.GroceryItem;
import com.grocerytracker.entity.GroceryItemEntity;
import com.grocerytracker.mapper.GroceryItemMapper;
import com.grocerytracker.repository.GroceryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroceryItemsServiceImpl implements IGroceryItemsService{

    private final GroceryRepository groceryRepository;

    @Autowired
    public GroceryItemsServiceImpl(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        List<GroceryItemEntity> fetchedGroceryItems = this.groceryRepository.findAll();
        return fetchedGroceryItems.stream().map(GroceryItemMapper::mapGroceryItemEntityToGroceryItem).collect(Collectors.toList());
    }

    @Override
    public GroceryItem addNewGroceryItem(GroceryItem groceryItem) {
        GroceryItemEntity groceryItemDocumentToAdd = GroceryItemMapper.mapGroceryItemToGroceryEntity(groceryItem);
        GroceryItemEntity insertedItem = this.groceryRepository.insert(groceryItemDocumentToAdd);
        return groceryItem;
    }

    @Override
    public GroceryItem updateGroceryItem(GroceryItem groceryItem) {
        GroceryItemEntity fetchedGroceryItem = this.groceryRepository.findById(new ObjectId(groceryItem.getId()))
                .orElseThrow(() -> new GroceryItemNotFoundException(String.format("No Item exists with Id %s", groceryItem.getId())));
        GroceryItemEntity updatedGroceryItem = GroceryItemMapper.updateGroceryItemEntity(fetchedGroceryItem, groceryItem);
        GroceryItemEntity savedGroceryItem = this.groceryRepository.save(updatedGroceryItem);
        return GroceryItemMapper.mapGroceryItemEntityToGroceryItem(savedGroceryItem);
    }

    @Override
    public String deleteGroceryItem(String groceryItemId) {
        this.groceryRepository.deleteById(new ObjectId(groceryItemId));
        return groceryItemId;
    }
}
