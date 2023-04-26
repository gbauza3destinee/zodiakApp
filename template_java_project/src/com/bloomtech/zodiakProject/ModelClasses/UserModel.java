package com.bloomtech.zodiakProject.ModelClasses;

import java.util.Objects;

public class UserModel {

    private String userId;
    private String userName;
    private String birthDate;
    private String pronouns;


    public UserModel() {

    }

    public UserModel(Builder builder) {
        this.userId = userId;
        this.userName = userName;
        this.birthDate = birthDate;
        this.pronouns = pronouns;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }


    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, userName, birthDate, pronouns);
    }

    @Override
    public boolean equals(Object o){

        return false;
     }

    @java.lang.Override
    public java.lang.String toString() {
        return "UserModel{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", pronouns='" + pronouns + '\'' +
                '}';
    }




    public static Builder builder() {
        return new Builder();
    }


    // TODO:Implement Builder with all fields as with method()

    public static final class Builder{

        private String userId;
        private String userName;
        private String birthDate;
        private String pronouns;

    }
}
