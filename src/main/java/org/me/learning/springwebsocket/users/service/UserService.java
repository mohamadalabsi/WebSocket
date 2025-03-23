package org.me.learning.springwebsocket.users.service;


import org.me.learning.springwebsocket.users.model.Status;
import org.me.learning.springwebsocket.users.model.User;
import org.me.learning.springwebsocket.users.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo ;

    public void saveUser(User user){
         user.setStatus(Status.ONLINE);
         userRepo.save(user);

    }

    public void disconnect(User user){
        User storedUser = userRepo.findById(user.getNickName()).orElse(null);

        if (storedUser != null){
            user.setStatus(Status.OFFLINE);
           userRepo.save(storedUser);
        }


    }

    public List<User> findConnectedUsers(){
        return userRepo.findAllByStatus(Status.ONLINE);

    }




}
