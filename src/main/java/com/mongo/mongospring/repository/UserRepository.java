package com.mongo.mongospring.repository;

import com.mongo.mongospring.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
    List<User> findByFirstName(String name);

    @Query("{'Address.city': ?0}")
    List<User> findByCity(String city);
}
