package com.example.demo.api;

import com.example.demo.entity.Video;
import com.example.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping(path="")
    public @ResponseBody
    Video addVideo(@RequestBody Video video){
        return videoService.addVideoService(video);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Video> getAllVideos(){
        return videoService.getAllVideosService();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Iterable<Video> getVideoById(@PathVariable("id") Integer id){
        return videoService.getVideoByIdService(id);
    }

    @PutMapping(path="/{id}")
    public @ResponseBody Video updateVideo(@PathVariable("id") Integer id,@RequestBody Video video){
        return videoService.updateVideoService(id,video);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteById(@PathVariable("id") Integer id){
        videoService.deleteByIdService(id);
    }
}
