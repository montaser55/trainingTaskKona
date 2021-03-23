package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostResponse {
    private long userId;
    private long id;
    private String title;
    private String body;
    private long requestTimeInMillis;
    private long responseTimeinMillis;
    private long timeTaken;

}
