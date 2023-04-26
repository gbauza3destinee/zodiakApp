package com.bloomtech.zodiakProject.ModelClasses.Results;

import com.amazonaws.internal.config.Builder;
import com.bloomtech.zodiakProject.ModelClasses.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.ModelClasses.UserModel;

import java.text.DateFormat;

public class CreateUserResult {


    private String userId;
    private String userName;
    private DateFormat birthdate;
    private String pronouns;

    public CreateUserResult(Builder builder) {
        this.userId= builder.userId;
        this.userName = builder.userName;
        this.birthdate = builder.birthdate;
        this.pronouns = builder.pronouns;

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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userId;
        private String userName;
        private DateFormat birthdate;
        private String pronouns;


        public Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
            return this;
        }

        public Builder withUserName(String userNameToUse) {
            this.userName = userNameToUse;
            return this;
        }


        public Builder withbirthdate(DateFormat userBirthDateToUse) {
            this.birthdate = userBirthDateToUse;
            return this;
        }

        public Builder withPronouns(String userPronouns) {
            this.pronouns = userPronouns;
            return this;
        }

        public Builder() {
        }


        public CreateUserResult build() {
            return new CreateUserResult(this);


        }

    }
}

