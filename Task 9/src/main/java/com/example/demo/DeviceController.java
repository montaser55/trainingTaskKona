package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/device")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @PostMapping(path="")
    public @ResponseBody Device addDevice(@RequestBody DeviceTemp device){
        Device newDevice=new Device();
        newDevice.setOS(device.getOS());
        newDevice.setMac(device.getMac());
        newDevice.setDeviceToken(device.getDeviceToken());
        deviceRepository.save(newDevice);
        return newDevice;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Device> getAllDevices(){
        return deviceRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Device> getDeviceById(@PathVariable("id") Integer id){
        return deviceRepository.findById(id);
    }

    @PutMapping(path="/{id}")
    public @ResponseBody Device updateDevice(@PathVariable("id") Integer id,@RequestBody DeviceTemp device){
        Device updatedDevice=deviceRepository.findById(id).get();
        updatedDevice.setOS(device.getOS());
        updatedDevice.setMac(device.getMac());
        updatedDevice.setDeviceToken(device.getDeviceToken());
        deviceRepository.save(updatedDevice);
        return deviceRepository.findById(id).get();
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteById(@PathVariable("id") Integer id){
        deviceRepository.deleteById(id);
    }
}
