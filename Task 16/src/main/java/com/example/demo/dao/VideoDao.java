package com.example.demo.dao;

import com.example.demo.entity.Video;

public class VideoDao {

    public String createQueryForAllVideo() {
        String str = "select * from video";
        return str;
    }

    public String createQueryForIdVideo(int id) {
        String str = "select * from video where id=?1";
        return str;
    }

    public String createQueryForDeleteVideo(int id) {
        String str = "DELETE from video where id=?1";
        return str;
    }
}
