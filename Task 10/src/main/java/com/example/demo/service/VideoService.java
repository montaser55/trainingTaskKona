package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import com.example.demo.model.UserTemp;
import com.example.demo.model.VideoTemp;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private UserRepository userRepository;

    public Video addVideoService(VideoTemp video){
        Video newVideo=new Video();
        newVideo.setFileName(video.getFileName());
        newVideo.setUrl(video.getUrl());
        newVideo.setUser(userRepository.findById(video.getUserId()).get());
        videoRepository.save(newVideo);
        return newVideo;
    }

    public Iterable<Video> getAllVideosService(){
        return videoRepository.findAll();
    }

    public Optional<Video> getVideoByIdService(Integer id){
        return videoRepository.findById(id);
    }

    public Video updateVideoService(Integer id, VideoTemp video){
        Video updatedVideo=videoRepository.findById(id).get();
        updatedVideo.setFileName(video.getFileName());
        updatedVideo.setUrl(video.getUrl());
        updatedVideo.setUser(userRepository.findById(video.getUserId()).get());
        videoRepository.save(updatedVideo);
        return videoRepository.findById(id).get();
    }

    public void deleteByIdService(Integer id){
        videoRepository.deleteById(id);
    }

}
