package com.loginregister.example.service;

import com.loginregister.example.entity.Users;
import com.loginregister.example.repo.UsersRepo;
import com.loginregister.example.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepo usersRepo;

    public Users addUser(Users user){
        return usersRepo.save(user);
    }

    public Boolean loginUser(LoginRequest loginRequest){
        Optional<Users> user = usersRepo.findById(loginRequest.getUserId());

        if(user.isPresent()){
            Users u = user.get();
            return u.getPassword().equals(loginRequest.getPassword());
        }else {
            return false;
        }
    }
}
