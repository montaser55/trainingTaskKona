package com.example.demo.service;

import com.example.demo.entity.Device;

public interface DeviceService {
    Device addDeviceService(Device device);

    Iterable<Device> getAllDevicesService();

    Iterable<Device> getDeviceByIdService(Integer id);

    Device updateDeviceService(Integer id, Device device);

    void deleteByIdService(Integer id);
}
