package com.example.trainingtask;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WebController {

    @RequestMapping("/v1/post/{id}")
    public SampleResponse Sample(@PathVariable("id") String id){
        final String uri = "https://jsonplaceholder.typicode.com/posts/{id}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        long requestTime=System.currentTimeMillis();
        User user = restTemplate.getForObject(uri, User.class, params);
        long responseTime=System.currentTimeMillis();
        SampleResponse response=new SampleResponse(user.getUserId(),user.getId(),user.getTitle(),user.getBody(),requestTime,responseTime,responseTime-requestTime);
        return response;
    }

}
