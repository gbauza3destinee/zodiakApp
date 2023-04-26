package com.bloomtech.zodiakProject.ModelClasses;

import java.util.Objects;

public class UserSignModel{
    private String userId;
    private String birthDate;
    private String zodiacSign;
    private String elementalSign;

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






}