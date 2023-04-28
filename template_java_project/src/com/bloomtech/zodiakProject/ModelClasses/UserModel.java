package com.bloomtech.zodiakProject.ModelClasses;

import java.util.Objects;


/**
 * A "User" Class that represents the real time instance of a User instance within the program.
 *
 */

public class UserModel {

    private String userName;
    private String birthDate;
    private String pronouns;
    private String zodiac;
    private String elemental;


    public UserModel() {

    }

    public UserModel(Builder builder) {
        this.userName = userName;
        this.birthDate = birthDate;
        this.pronouns = pronouns;
        this.zodiac = zodiac;
        this.elemental = elemental;

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


    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public String getElemental() {
        return elemental;
    }

    public void setElemental(String elemental) {
        this.elemental = elemental;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), userName, birthDate, pronouns, zodiac, elemental);
    }







    @Override
    public boolean equals(Object o) {

        return false;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "UserModel{" +

                "userName='" + userName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", pronouns='" + pronouns + '\'' +
                ", zodiacSign='" + zodiac + '\'' +
                ", elementalSign='" + elemental + '\'' +
                '}';
    }


    public static final class Builder {

        private String userName;
        private String birthDate;
        private String pronouns;
        private String zodiac;
        private String elemental;

        public static Builder builder() {
            return new Builder();
        }



        public Builder withName(String nameToUse) {
            this.userName = nameToUse;
            return this;
        }

        public Builder withBirthdate(String customerBirthDate) {
            this.birthDate = customerBirthDate;
            return this;
        }

        public Builder withPronouns(String customerPronouns) {
            this.pronouns = customerPronouns;
            return this;
        }


        public Builder withZodiacSign(String zodiacSignToUse) {
            this.zodiac = zodiacSignToUse;
            return this;
        }

        public Builder withElementalSign(String elementalSignToUse) {
            this.elemental = elementalSignToUse;
            return this;
        }


        public UserModel build() {
            return new UserModel(this);
        }
    }

}


