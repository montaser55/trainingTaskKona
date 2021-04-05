package com.example.demo.service;

import com.example.demo.dao.DeviceDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Device;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private EntityManagerFactory em;
    @Autowired
    DeviceService deviceService;

    public User addUserService(User user){
        EntityManager entityManager=em.createEntityManager();
        User newUser=new User();

        Device device=entityManager.find(Device.class,user.getID());
        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        newUser.setDevice(device);

        entityManager.getTransaction().begin();
        entityManager.persist(newUser);
        entityManager.getTransaction().commit();
        entityManager.close();

        return newUser;
    }

    public Iterable<User> getAllUsersService(){
        UserDao userDao=new UserDao();
        EntityManager entityManager=em.createEntityManager();
        String queryString= userDao.createQueryForAllUser();
        Query query=entityManager.createQuery(queryString);
        Iterable<User> users=query.getResultList();
        entityManager.close();
        return users;
    }

    public Iterable<User> getUserByIdService(Integer id){
        UserDao userDao=new UserDao();
        EntityManager entityManager=em.createEntityManager();
        String queryString= userDao.createQueryForIdUser(id);
        Query query=entityManager.createQuery(queryString);
        query.setParameter("id",id);
        Iterable<User> user=query.getResultList();
        entityManager.close();
        return user;
    }

    public User updateUserService(Integer id, User user){
        EntityManager entityManager=em.createEntityManager();

        User updatedUser=entityManager.find(User.class,id);
        Device device=entityManager.find(Device.class,user.getID());

        updatedUser.setName(user.getName());
        updatedUser.setAge(user.getAge());
        updatedUser.setDevice(device);

        entityManager.getTransaction().begin();
        entityManager.merge(updatedUser);
        entityManager.getTransaction().commit();
        entityManager.close();
        return updatedUser;
    }

    public void deleteByIdService(Integer id){
        UserDao userDao=new UserDao();
        EntityManager entityManager=em.createEntityManager();
        String queryString= userDao.createQueryForDeleteUser(id);
        Query query=entityManager.createQuery(queryString);
        query.setParameter("id",id);

        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
