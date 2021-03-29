package com.example.demo.repository;

import com.example.demo.entity.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video,Integer> {
}
