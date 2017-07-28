package com.sonikpalms.intern.modelclass;

/**
 * Created by i.metlin on 26.07.2017.
 */

public class MyItems {


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
}
