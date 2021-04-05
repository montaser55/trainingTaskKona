package com.example.demo.dao;

import com.example.demo.entity.Device;

public class DeviceDao {


    public String createQueryForAllDevice() {
        String str = "select d.id,d.os,d.mac,d.device_token,d.created_at,d.updated_at,d.version from device d";
        return str;
    }

    public String createQueryForIdDevice(int id) {
        String str = "select * from device where id=?1";
        return str;
    }

    public String createQueryForUpdateDevice(int id,Device device) {
        String str = "update device d SET d.os=?1, d.mac=?2, d.device_token=?3 where d.id=?4";
        return str;
    }

    public String createQueryForDeleteDevice(int id) {
        String str = "DELETE from device where id=?1";
        return str;
    }
}
