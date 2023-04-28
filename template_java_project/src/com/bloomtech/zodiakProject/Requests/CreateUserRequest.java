package com.bloomtech.zodiakProject.Requests;

import com.amazonaws.internal.config.Builder;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**\
 * A Class representing a new server requested entry made by a User.
 */


public class CreateUserRequest {


    private String userName;
    private LocalDate birthdate;
    private String pronouns;


    // TODO: Change DateFormat to LocalDate Us 9 after researching how it works
    public CreateUserRequest( String userName, LocalDate birthdate, String pronouns){
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
        CreateUserRequest that = (CreateUserRequest) o;
        return userName.equals(that.userName) && birthdate.equals(that.birthdate) && pronouns.equals(that.pronouns);
    }

    @Override
    public int hashCode() {
        return Objects.hash( userName, birthdate, pronouns);
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                ", userName='" + userName + '\'' +
                ", birthdate=" + birthdate +
                ", pronouns='" + pronouns + '\'' +
                '}';
    }


    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{

        private String userName;
        private LocalDate birthdate;
        private String pronouns;

        private Builder (){
        }



        private Builder withUserName(String userNameToUse){
            this.userName = userNameToUse;
            return this;
        }


        private Builder withBirthDate(LocalDate userBirthDateToUse){
            this.birthdate = userBirthDateToUse;
            return this;
        }
        private Builder withPronouns(String userPronouns){
            this.pronouns = userPronouns;
            return this;
        }


        public CreateUserRequest build(){
            return new CreateUserRequest(this);
        }
    }


}


