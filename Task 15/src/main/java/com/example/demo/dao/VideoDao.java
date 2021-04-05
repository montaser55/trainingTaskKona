package com.example.demo.dao;

import com.example.demo.entity.Video;

public class VideoDao {

    public String createQueryForAllVideo() {
        String str = "select v from Video v";
        return str;
    }

    public String createQueryForIdVideo(int id) {
        String str = "select v from Video v where v.id=:id";
        return str;
    }

    public String createQueryForDeleteVideo(int id) {
        String str = "DELETE from Video v where v.id=:id";
        return str;
    }
}
