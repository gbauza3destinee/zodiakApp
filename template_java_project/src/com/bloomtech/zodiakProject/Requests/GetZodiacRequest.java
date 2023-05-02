package com.bloomtech.zodiakProject.Requests;

import java.time.LocalDate;
import java.util.Objects;

public class GetZodiacRequest {

    // TODO: Delete all fields but userId for this API action

    private String userId;
    private LocalDate birthdate;
    private String pronouns;


    public GetZodiacRequest( String userId, LocalDate birthdate, String pronouns){
        this.userId = userId;
        this.birthdate = birthdate;
        this.pronouns = pronouns;
    }

    public GetZodiacRequest(){

    }

    public GetZodiacRequest(GetZodiacRequest.Builder builder){
        this.userId = userId;
        this.birthdate = birthdate;
        this.pronouns = pronouns;

    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
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
        GetZodiacRequest that = (GetZodiacRequest) o;
        return userId.equals(that.userId) && birthdate.equals(that.birthdate) && pronouns.equals(that.pronouns);
    }

    @Override
    public int hashCode() {
        return Objects.hash( userId, birthdate, pronouns);
    }

    @Override
    public String toString() {
        return "GetZodiacRequest{" +
                ", userName='" + userId + '\'' +
                ", birthdate=" + birthdate +
                ", pronouns='" + pronouns + '\'' +
                '}';
    }


    public static GetZodiacRequest.Builder builder(){
        return new GetZodiacRequest.Builder();
    }


    // TODO: Update fields to just add userId.

    // -

    public static final class Builder{

        private String userId;
        private LocalDate birthdate;
        private String pronouns;

        private Builder (){
        }


        private GetZodiacRequest.Builder withUserId(String userId){
            this.userId = userId;
            return this;
        }


        private GetZodiacRequest.Builder withBirthDate(LocalDate userBirthDateToUse){
            this.birthdate = userBirthDateToUse;
            return this;
        }
        private GetZodiacRequest.Builder withPronouns(String userPronouns){
            this.pronouns = userPronouns;
            return this;
        }


        public GetZodiacRequest build(){
            return new GetZodiacRequest(this);
        }
    }





}
