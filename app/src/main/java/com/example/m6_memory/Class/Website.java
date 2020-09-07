package com.example.m6_memory.Class;

public class Website {

    private String name;
    private String url;

    public Website(String name, String url)  {
        this.name= name;
        this.url= url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()  {
        return name;
    }
}
