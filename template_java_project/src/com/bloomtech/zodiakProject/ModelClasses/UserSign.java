package com.bloomtech.zodiakProject.ModelClasses;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/*
 * Represents a record in the UserSigns' table
 * */
public class UserSign {

    private String userId;
    private String birthDate;
    private String zodiacSign;
    private String elementalSign;


    //TODO: 4/25 FixDynamodb import again

    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @DynamoDBAttribute(attributeName = "color")
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    @DynamoDBAttribute(attributeName = "zodiacSign")
    public String getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(String zodiacSign) {
        this.zodiacSign = zodiacSign;
    }


    @DynamoDBAttribute(attributeName = "elementalSign")
    public String getElementalSign() {
        return elementalSign;
    }

    public void setElementalSign(String elementalSign) {
        this.elementalSign = elementalSign;
    }


}


