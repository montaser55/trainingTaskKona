package com.example.demo.dao;

import com.example.demo.entity.Device;

public class DeviceDao {


    public String createQueryForAllDevice() {
        String str = "select device from Device device";
        return str;
    }

    public String createQueryForIdDevice(int id) {
        String str = "select d from Device d where d.id=:id";
        return str;
    }

    public String createQueryForUpdateDevice(int id,Device device) {
        String str = "update device d SET d.os=:os, d.mac=:mac, d.device_token=:device_token where d.id=:id";
        return str;
    }

    public String createQueryForDeleteDevice(int id) {
        String str = "DELETE from Device d where d.id=:id";
        return str;
    }
}
