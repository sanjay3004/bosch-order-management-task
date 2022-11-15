package com.example.boschOrderManagementTask.repository;

import com.example.boschOrderManagementTask.Collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
}
