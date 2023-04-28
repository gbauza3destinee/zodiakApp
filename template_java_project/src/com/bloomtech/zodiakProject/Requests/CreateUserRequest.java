package com.bloomtech.zodiakProject.Requests;

import com.amazonaws.internal.config.Builder;

import java.text.DateFormat;
import java.util.Objects;


// TODO: Double check at this point in execution of flow, if
// TODO: this request class should have birthdate in DateFormat or String (like in data table)?

public class CreateUserRequest {


    private String userName;
    private DateFormat birthdate;
    private String pronouns;


    public CreateUserRequest( String userName, DateFormat birthdate, String pronouns){
        this.userName = userName;
        this.birthdate = birthdate;
        this.pronouns = pronouns;
    }

    public CreateUserRequest(){

    }

    public CreateUserRequest(Builder builder){
        this.userName = userName;
        this.birthdate = birthdate;
        this.pronouns = pronouns;

    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public DateFormat getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(DateFormat birthdate) {
        this.birthdate = birthdate;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserRequest that = (CreateUserRequest) o;
        return userId.equals(that.userId) && userName.equals(that.userName) && birthdate.equals(that.birthdate) && pronouns.equals(that.pronouns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, birthdate, pronouns);
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", birthdate=" + birthdate +
                ", pronouns='" + pronouns + '\'' +
                '}';
    }


    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{

        private String userId;
        private String userName;
        private DateFormat birthdate;
        private String pronouns;

        private Builder (){
        }


        private Builder withUserId(String userIdToUse){
            this.userId = userIdToUse;
            return this;
        }

        private Builder withUserName(String userNameToUse){
            this.userName = userNameToUse;
            return this;
        }


        private Builder withbirthdate(DateFormat userBirthDateToUse){
            this.birthdate = userBirthDateToUse;
            return this;
        }


        public CreateUserRequest build(){
            return new CreateUserRequest(this);
        }
    }


}


