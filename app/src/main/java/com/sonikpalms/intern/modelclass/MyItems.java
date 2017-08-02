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
    }


}



