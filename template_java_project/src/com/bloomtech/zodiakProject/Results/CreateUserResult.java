package com.bloomtech.zodiakProject.Results;

import com.bloomtech.zodiakProject.ServiceProviders.UserGeneratorService;

import java.time.LocalDate;

public class CreateUserResult {


    private UserGeneratorService userGeneratorService;
    private String userId;
    private String userName;
    private LocalDate birthdate;
    private String pronouns;

    public CreateUserResult(Builder builder) {
        UserGeneratorService userGeneratorService = new UserGeneratorService();

        this.userId = UserGeneratorService.generateUserId();
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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userId;
        private String userName;
        private LocalDate birthdate;
        private String pronouns;


        public Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
            return this;
        }

        public Builder withUserName(String userNameToUse) {
            this.userName = userNameToUse;
            return this;
        }


        public Builder withbirthdate(LocalDate userBirthDateToUse) {
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

