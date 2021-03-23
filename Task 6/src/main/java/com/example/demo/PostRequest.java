package com.example.demo;

import lombok.Data;

@Data
public class PostRequest {
    private long demoUserId;
    private String demoTitle;
    private String demoBody;
}
