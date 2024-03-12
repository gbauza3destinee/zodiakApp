package com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

public class User{
    private String userId;

    private String userName;
    private String birthDate;
    private String zodiac;

    private String elemental;


    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId(){
        return userId;

    }

    public void setUserId( String userId){
        this.userId = userId;

    }


    @DynamoDBAttribute(attributeName = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @DynamoDBAttribute(attributeName = "birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }



    @DynamoDBAttribute(attributeName = "zodiac")
    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }


    @DynamoDBAttribute(attributeName = "elemental")

    public String getElemental() {
        return elemental;
    }

    public void setElemental(String elemental) {
        this.elemental = elemental;
    }







}




