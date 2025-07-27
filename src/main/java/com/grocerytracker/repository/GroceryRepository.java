package com.grocerytracker.repository;

import com.grocerytracker.entity.GroceryItemEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends MongoRepository<GroceryItemEntity, ObjectId> {
}
