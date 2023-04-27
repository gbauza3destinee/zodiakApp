package com.bloomtech.zodiakProject.ModelClasses;

import java.util.Objects;

public class UserSignModel{
    private String userId;
    private String birthDate;
    private String zodiacSign;
    private String elementalSign;

    public UserSignModel(Builder builder) {
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(String zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public String getElementalSign() {
        return elementalSign;
    }

    public void setElementalSign(String elementalSign) {
        this.elementalSign = elementalSign;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        UserSignModel that = (UserSignModel) object;
        return userId.equals(that.userId) && java.util.Objects.equals(birthDate, that.birthDate) && java.util.Objects.equals(zodiacSign, that.zodiacSign) && elementalSign.equals(that.elementalSign);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, birthDate, zodiacSign, elementalSign);
    }


    //Builder

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String userId;
        private String birthDate;
        private String zodiacSign;
        private String elemental;

        public Builder withUserId(String idToUse) {
            this.userId = idToUse;
            return this;
        }

        public Builder withBirthDate(String birthDateToUse) {
            this.birthDate = birthDateToUse;
            return this;
        }

        //TODO: I know the POJO Class that faces the database table needs to have these objects as Strings
        // TODO: However, at this point in the Model Creation, should these values be turned from String to Object?

        public Builder withZodiacSign(String zodiacSignToUse) {
            this.zodiacSign = zodiacSignToUse;
            return this;
        }

        public Builder withElementalSign(String elementalSignToUse) {
            this.elemental = elementalSignToUse;
            return this;
        }

        //TODO: figure out why this instance can't be populated in the parameter
        public UserSignModel build() {return new UserSignModel(this);}
    }
}









