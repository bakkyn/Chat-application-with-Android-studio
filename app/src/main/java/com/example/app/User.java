package com.example.app;

public class User {

    private String id;
    private String userName;
    private String imageUrl;


    public User(String id, String userName, String imageUrl){

         this.id=id;
         this.userName= userName;
         this.imageUrl=imageUrl;

    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUserName() {
        return userName;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
