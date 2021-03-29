package com.example.demo.service;

import com.example.demo.entity.Device;
import com.example.demo.model.DeviceTemp;
import com.example.demo.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Component
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device addDeviceService(DeviceTemp device){
        Device newDevice=new Device();
        newDevice.setOS(device.getOS());
        newDevice.setMac(device.getMac());
        newDevice.setDeviceToken(device.getDeviceToken());
        deviceRepository.save(newDevice);
        return newDevice;
    }

    public Iterable<Device> getAllDevicesService(){
        return deviceRepository.findAll();
    }

    public Optional<Device> getDeviceByIdService(Integer id){
        return deviceRepository.findById(id);
    }

    public Device updateDeviceService(Integer id,DeviceTemp device){
        Device updatedDevice=deviceRepository.findById(id).get();
        updatedDevice.setOS(device.getOS());
        updatedDevice.setMac(device.getMac());
        updatedDevice.setDeviceToken(device.getDeviceToken());
        deviceRepository.save(updatedDevice);
        return deviceRepository.findById(id).get();
    }

    public void deleteByIdService(Integer id){
        deviceRepository.deleteById(id);
    }
}
