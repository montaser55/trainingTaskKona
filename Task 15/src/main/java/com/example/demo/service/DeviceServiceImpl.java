package com.example.demo.service;

import com.example.demo.dao.DeviceDao;
import com.example.demo.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private EntityManagerFactory em;

    public Device addDeviceService(Device device){
        EntityManager entityManager=em.createEntityManager();
        Device newDevice=new Device();

        newDevice.setOS(device.getOS());
        newDevice.setMac(device.getMac());
        newDevice.setDeviceToken(device.getDeviceToken());

        entityManager.getTransaction().begin();
        entityManager.persist(newDevice);
        entityManager.getTransaction().commit();
        entityManager.close();

        return newDevice;
    }

    public Iterable<Device> getAllDevicesService(){
        DeviceDao deviceDao=new DeviceDao();
        EntityManager entityManager=em.createEntityManager();
        String queryString= deviceDao.createQueryForAllDevice();
        Query query=entityManager.createQuery(queryString);
        Iterable<Device> devices=query.getResultList();
        entityManager.close();
        return devices;
    }

    public Iterable<Device> getDeviceByIdService(Integer id){
        DeviceDao deviceDao=new DeviceDao();
        EntityManager entityManager=em.createEntityManager();
        String queryString= deviceDao.createQueryForIdDevice(id);
        Query query=entityManager.createQuery(queryString);
        query.setParameter("id",id);
        Iterable<Device> device=query.getResultList();
        entityManager.close();
        return device;
    }

    public Device updateDeviceService(Integer id, Device device){
        DeviceDao deviceDao=new DeviceDao();
        EntityManager entityManager=em.createEntityManager();
        String queryString= deviceDao.createQueryForUpdateDevice(id,device);
        Query query=entityManager.createQuery(queryString);
        query.setParameter("id",id);
        query.setParameter("os",device.getOS());
        query.setParameter("mac",device.getMac());
        query.setParameter("device_token",device.getDeviceToken());

        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return device;
    }

    public void deleteByIdService(Integer id){
        DeviceDao deviceDao=new DeviceDao();
        EntityManager entityManager=em.createEntityManager();
        String queryString= deviceDao.createQueryForDeleteDevice(id);
        Query query=entityManager.createQuery(queryString);
        query.setParameter("id",id);

        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
