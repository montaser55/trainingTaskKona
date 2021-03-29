package com.example.demo.repository;

import com.example.demo.entity.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device,Integer> {
}
