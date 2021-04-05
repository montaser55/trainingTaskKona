package com.example.demo.service;

import com.example.demo.dao.VideoDao;
import com.example.demo.entity.Device;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private EntityManagerFactory em;
    @Autowired
    UserService userService;

    public Video addVideoService(Video video){
        EntityManager entityManager=em.createEntityManager();
        Video newVideo=new Video();
        User user=entityManager.find(User.class,video.getID());

        newVideo.setFileName(video.getFileName());
        newVideo.setUrl(video.getUrl());
        newVideo.setUser(user);

        entityManager.getTransaction().begin();
        entityManager.persist(newVideo);
        entityManager.getTransaction().commit();
        entityManager.close();

        return newVideo;
    }

    public Iterable<Video> getAllVideosService(){
        VideoDao videoDao=new VideoDao();
        EntityManager entityManager=em.createEntityManager();
        String queryString= videoDao.createQueryForAllVideo();
        Query query=entityManager.createNativeQuery(queryString);
        Iterable<Video> videos=query.getResultList();
        entityManager.close();
        return videos;
    }

    public Iterable<Video> getVideoByIdService(Integer id){
        VideoDao videoDao=new VideoDao();
        EntityManager entityManager=em.createEntityManager();
        String queryString= videoDao.createQueryForIdVideo(id);
        Query query=entityManager.createNativeQuery(queryString);
        query.setParameter(1,id);
        Iterable<Video> video=query.getResultList();
        entityManager.close();
        return video;
    }

    public Video updateVideoService(Integer id, Video video){
        EntityManager entityManager=em.createEntityManager();

        Video updatedVideo=entityManager.find(Video.class,id);
        User user=entityManager.find(User.class,video.getID());

        updatedVideo.setFileName(video.getFileName());
        updatedVideo.setUrl(video.getUrl());
        updatedVideo.setUser(user);

        entityManager.getTransaction().begin();
        entityManager.merge(updatedVideo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return updatedVideo;
    }

    public void deleteByIdService(Integer id){
        VideoDao videoDao=new VideoDao();
        EntityManager entityManager=em.createEntityManager();
        String queryString= videoDao.createQueryForDeleteVideo(id);
        Query query=entityManager.createNativeQuery(queryString);
        query.setParameter(1,id);

        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
