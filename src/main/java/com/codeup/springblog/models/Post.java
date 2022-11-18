package com.codeup.springblog.models;

public class Post  {

// === variables

    private String title;

    private String body;
// === constructors


    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
// === setters and getters
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
}
