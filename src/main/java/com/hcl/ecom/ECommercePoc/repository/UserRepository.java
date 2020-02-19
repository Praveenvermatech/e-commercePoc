package com.hcl.ecom.ECommercePoc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hcl.ecom.ECommercePoc.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

}
