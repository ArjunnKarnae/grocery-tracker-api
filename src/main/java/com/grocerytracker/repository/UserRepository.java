package com.grocerytracker.repository;

import com.grocerytracker.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Long> {

    public UserEntity findByUserName(String userName);
}
