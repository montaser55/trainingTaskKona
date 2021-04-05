package com.example.demo.service;

import com.example.demo.entity.Video;

public interface VideoService {
    Video addVideoService(Video video);

    Iterable<Video> getAllVideosService();

    Iterable<Video> getVideoByIdService(Integer id);

    Video updateVideoService(Integer id, Video video);

    void deleteByIdService(Integer id);
}
