package com.sonikpalms.intern.modelclass;

/**
 * Created by i.metlin on 26.07.2017.
 */

import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class MyItems {

    private transient int id;

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("urlToImage")
    @Expose
    public String urlToImage;

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;

    public MyItems() {
        this.author = this.author;
        this.title = this.title;
        this.description = this.description;
        this.url = this.url;
        this.urlToImage = this.urlToImage;
        this.publishedAt = this.publishedAt;
    }



    public void setId(){
        id = hashCode();
    }
    public int getId(){
        return id;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyItems that = (MyItems) o;

        return author == that.author;

    }

    @Override
    public String toString() {
        return "MyItems{" +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }


}




/*
    private boolean isOnline;
    private String userName;
    private Category taskCategory;
    private int userId;
    private String userAddress;


    public enum Category {Friend, Family, Work, Another}


    public MyItems(boolean isOnline, String userName, Category taskCategory, int userId, String userAddress) {
        this.isOnline = isOnline;
        this.userName = userName;
        this.taskCategory = taskCategory;
        this.userId = userId;
        this.userAddress = userAddress;
    }

    public MyItems(boolean isOnline, String userName, int userId, String userAddress) {
        this(isOnline, userName, Category.Another, userId, userAddress);

    }


    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Category getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(Category taskCategory) {
        this.taskCategory = taskCategory;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        MyItems other = (MyItems) o;
        return userName.equals(other.getUserName());
    }*/






