package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @PostMapping(path="")
    public @ResponseBody User addUser(@RequestBody UserTemp user){
        User newUser=new User();
        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        newUser.setDevice(deviceRepository.findById(user.getDeviceId()).get());
        userRepository.save(newUser);
        return newUser;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<User> getUserById(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }

    @PutMapping(path="/{id}")
    public @ResponseBody User updateUser(@PathVariable("id") Integer id,@RequestBody UserTemp user){
        User updatedUser=userRepository.findById(id).get();
        updatedUser.setName(user.getName());
        updatedUser.setAge(user.getAge());
        updatedUser.setDevice(deviceRepository.findById(user.getDeviceId()).get());
        userRepository.save(updatedUser);
        return userRepository.findById(id).get();
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteById(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
}
