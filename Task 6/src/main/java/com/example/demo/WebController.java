package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

    @RequestMapping(value = "/v1/post", method = RequestMethod.POST)
    public PostResponse ResponseUsingExternalAPI(@RequestBody PostRequest inputPayload){
        final String uri = "https://jsonplaceholder.typicode.com/posts";
        RestTemplate restTemplate = new RestTemplate();

        long requestId=inputPayload.getDemoUserId();
        String requestTitle=inputPayload.getDemoTitle();
        String requestBody=inputPayload.getDemoBody();
        ExternalRequest newRequest = new ExternalRequest(requestId,requestTitle,requestBody);

        long requestTime=System.currentTimeMillis();
        ExternalResponse newResponse = restTemplate.postForObject( uri, newRequest, ExternalResponse.class);
        long responseTime=System.currentTimeMillis();

        long responseUserId=newResponse.getUserId();
        long responseId=newResponse.getId();
        String responseTitle=newResponse.getTitle();
        String responseBody=newResponse.getBody();
        long timeTaken=responseTime-requestTime;

        PostResponse response=new PostResponse(responseUserId,responseId,responseTitle,responseBody,requestTime,responseTime,timeTaken);
        return response;
    }

}
