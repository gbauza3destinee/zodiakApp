package com.bloomtech.zodiakProject;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomtech.zodiakProject.ModelClasses.UserSign;

public class UserSignDao {



    public UserSignDao(DynamoDBMapper dynamoDBMapper){

        this.dynamoDBMapper = dynamoDBMapper;
    }


    // TODO : For this table the primary key is UserId.
    // Q: on creation of datatype "Zodiac" and "Elemental" - should I keep these as Strings or
    // implement my Super Interface Class Zodiac and Elemental Subclasses this early on here?




    public UserSign getUserZodiacSign(UserSign userSign){


        String zodiacSign = userSign.getZodiacSign();
        String userId = userSign.getUserId();
        UserSign thisUserSignInformation = dynamoDBMapper.load(UserSign.class, userId, zodiacSign);

        // TODO: Should I return an object or String this early on in the program?
        return zodiacSign;
    }



    public UserSign getUserElementalSign(UserSign userSign){


        String elementalSign = userSign.getElementalSign();
        String userId = userSign.getUserId();
        UserSign thisUserSignInformation = dynamoDBMapper.load(UserSign.class, userId, elementalSign);

        // TODO: Should I return an object or String this early on in the program?
        return elementalSign;
    }




    public void saveUserZodiacSign(String userId){

        dynamoDBMapper.save(UserSign.class, userSign.getUserId());


    }


    public void saveUserElementalSign(UserSign userSign){

        String userElementalSign = userSign.getElementalSign();

        dynamoDBMapper.save(UserSign.class, userSign.getUserId(), userElementalSign);






    }




}
