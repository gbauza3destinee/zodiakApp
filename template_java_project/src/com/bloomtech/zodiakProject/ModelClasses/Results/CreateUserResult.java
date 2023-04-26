package com.bloomtech.zodiakProject.ModelClasses.Results;

import com.amazonaws.internal.config.Builder;
import com.bloomtech.zodiakProject.ModelClasses.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.ModelClasses.UserModel;

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

        public Builder withUser(UserModel user) {
            this.user = user;
            return this;
        }

        public CreateUserResult build() {
            return new CreateUserResult(this);
        }


    }
}
