package com.example.demo.api;

import com.example.demo.model.UserTemp;
import com.example.demo.entity.User;
import com.example.demo.repository.DeviceRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="")
    public @ResponseBody
    User addUser(@RequestBody UserTemp user){
        return userService.addUserService(user);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userService.getAllUsersService();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<User> getUserById(@PathVariable("id") Integer id){
        return userService.getUserByIdService(id);
    }

    @PutMapping(path="/{id}")
    public @ResponseBody User updateUser(@PathVariable("id") Integer id,@RequestBody UserTemp user){
        return userService.updateUserService(id, user);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteById(@PathVariable("id") Integer id){
        userService.deleteByIdService(id);
    }
}
