package com.example.demo.service;

import com.example.demo.entity.Device;
import com.example.demo.entity.User;
import com.example.demo.model.DeviceTemp;
import com.example.demo.model.UserTemp;
import com.example.demo.repository.DeviceRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public User addUserService(UserTemp user){
        User newUser=new User();
        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        newUser.setDevice(deviceRepository.findById(user.getDeviceId()).get());
        userRepository.save(newUser);
        return newUser;
    }

    public Iterable<User> getAllUsersService(){
        return userRepository.findAll();
    }

    public Optional<User> getUserByIdService(Integer id){
        return userRepository.findById(id);
    }

    public User updateUserService(Integer id, UserTemp user){
        User updatedUser=userRepository.findById(id).get();
        updatedUser.setName(user.getName());
        updatedUser.setAge(user.getAge());
        updatedUser.setDevice(deviceRepository.findById(user.getDeviceId()).get());
        userRepository.save(updatedUser);
        return userRepository.findById(id).get();
    }

    public void deleteByIdService(Integer id){
        userRepository.deleteById(id);
    }

}
