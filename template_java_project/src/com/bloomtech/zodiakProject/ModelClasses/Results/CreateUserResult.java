package com.bloomtech.zodiakProject.ModelClasses.Results;

import com.amazonaws.internal.config.Builder;
import com.bloomtech.zodiakProject.ModelClasses.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.ModelClasses.UserModel;

import java.text.DateFormat;

public class CreateUserResult {

    private UserModel user;

    public CreateUserResult(Builder builder) {
        this.user = builder.user;

    }


    public UserModel getPlaylist() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserModel user;
        private String userId;
        private String userName;
        private DateFormat birthdate;
        private String pronouns;

        public Builder withUser(UserModel user) {
            this.user = user;
            return this;
        }


        private Builder() {
        }


        private CreateUserResult.Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
            return this;
        }

        private CreateUserResult.Builder withUserName(String userNameToUse) {
            this.userName = userNameToUse;
            return this;
        }


        private CreateUserResult.Builder withbirthdate(DateFormat userBirthDateToUse) {
            this.birthdate = userBirthDateToUse;
            return this;
        }


        public CreateUserResult build() {
            return new CreateUserResult(this);


        }

    }
}

