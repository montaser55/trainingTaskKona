package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/video")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="")
    public @ResponseBody Video addVideo(@RequestBody VideoTemp video){
        Video newVideo=new Video();
        newVideo.setFileName(video.getFileName());
        newVideo.setUrl(video.getUrl());
        newVideo.setUser(userRepository.findById(video.getUserId()).get());
        videoRepository.save(newVideo);
        return newVideo;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Video> getAllVideos(){
        return videoRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Video> getVideoById(@PathVariable("id") Integer id){
        return videoRepository.findById(id);
    }

    @PutMapping(path="/{id}")
    public @ResponseBody Video updateVideo(@PathVariable("id") Integer id,@RequestBody VideoTemp video){
        Video updatedVideo=videoRepository.findById(id).get();
        updatedVideo.setFileName(video.getFileName());
        updatedVideo.setUrl(video.getUrl());
        updatedVideo.setUser(userRepository.findById(video.getUserId()).get());
        videoRepository.save(updatedVideo);
        return videoRepository.findById(id).get();
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteById(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
}
