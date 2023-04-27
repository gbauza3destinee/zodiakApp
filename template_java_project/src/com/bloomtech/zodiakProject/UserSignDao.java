package com.bloomtech.zodiakProject;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomtech.zodiakProject.ModelClasses.UserSign;

public class UserSignDao {



    public UserSignDao(DynamoDBMapper dynamoDBMapper){

        this.dynamoDBMapper = dynamoDBMapper;
    }


    // TODO : Make sure for this table,these are the accurate data keys!
    // TODO: NEXT -- Developing the Zodiak Classes- swap  an object of ZodiakSign for String in this logic



    public UserSign getUserSign(UserSign userSign){

        String zodiacSign = userSign.getZodiacSign();
        String userId = userSign.getUserId();
        UserSign thisUserSign = dynamoDBMapper.load(UserSign.class, userId, zodiacSign);

        return thisUserSign;
    }




    public void saveUserZodiacSign(UserSign userSign){

        String userId = userSign.getUserId();
        String zodiacSign = this.getUserSign(userSign);
      //  ZodiacSign zodiacSign = this.getUserSign(userSign);

        dynamoDBMapper.save(UserSign.class, userSign.getUserId(), zodiacSign );






    }


    public void saveUserSign(UserSign userSign){

        String userId = userSign.getUserId();
        String zodiacSign = this.getUserSign(userSign);
        //  ZodiacSign zodiacSign = this.getUserSign(userSign);

        dynamoDBMapper.save(UserSign.class, userSign.getUserId(), zodiacSign );






    }




}
