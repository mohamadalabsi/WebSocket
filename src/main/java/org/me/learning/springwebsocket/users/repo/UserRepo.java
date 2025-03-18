package org.me.learning.springwebsocket.users.repo;


import org.me.learning.springwebsocket.users.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository <User, String > {
    List<User> findAllByStatus();
}
