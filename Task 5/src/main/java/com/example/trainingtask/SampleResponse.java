package com.example.trainingtask;

public class SampleResponse {
    private long userId;
    private long id;
    private String title;
    private String body;
    private long requestTimeInMillis;
    private long responseTimeInMillis;

    public SampleResponse(long userId, long id, String title, String body, long requestTimeInMillis, long responseTimeInMillis, long timeTaken) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        this.requestTimeInMillis = requestTimeInMillis;
        this.responseTimeInMillis = responseTimeInMillis;
        this.timeTaken = timeTaken;
    }

    private long timeTaken;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getRequestTimeInMillis() {
        return requestTimeInMillis;
    }

    public void setRequestTimeInMillis(long requestTimeInMillis) {
        this.requestTimeInMillis = requestTimeInMillis;
    }

    public long getResponseTimeInMillis() {
        return responseTimeInMillis;
    }

    public void setResponseTimeInMillis(long responseTimeInMillis) {
        this.responseTimeInMillis = responseTimeInMillis;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }
}
