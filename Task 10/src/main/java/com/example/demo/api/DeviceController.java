package com.example.demo.api;

import com.example.demo.model.DeviceTemp;
import com.example.demo.entity.Device;
import com.example.demo.repository.DeviceRepository;
import com.example.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping(path="")
    public @ResponseBody Device addDevice(@RequestBody DeviceTemp device){
        return deviceService.addDeviceService(device);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Device> getAllDevices(){
        return deviceService.getAllDevicesService();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Device> getDeviceById(@PathVariable("id") Integer id){
        return deviceService.getDeviceByIdService(id);
    }

    @PutMapping(path="/{id}")
    public @ResponseBody Device updateDevice(@PathVariable("id") Integer id,@RequestBody DeviceTemp device){
        return deviceService.updateDeviceService(id, device);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteById(@PathVariable("id") Integer id){
        deviceService.deleteByIdService(id);
    }
}
