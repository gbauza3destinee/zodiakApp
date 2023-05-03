package com.bloomtech.zodiakProject.activityClasses;

import com.bloomtech.zodiakProject.DateCalculator;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.Requests.GetZodiacRequest;
import com.bloomtech.zodiakProject.Results.CreateUserResult;
import com.bloomtech.zodiakProject.Results.GetZodiacResult;
import com.bloomtech.zodiakProject.UserDao;

import javax.naming.Context;
import java.sql.SQLOutput;
import java.time.LocalDate;



// DONE: Review String Split Logic

public class GetZodiacActivity implements RequestHandler <GetZodiacRequest, GetZodiacResult> {

    public UserDao userDao;

    public GetZodiacActivity(UserDao userDao) {

        this.userDao = userDao;

    }




    /**
     * Request Handler method that works with API requests made by a user,
     * to save to their UserID, their corresponding ElementalSign, ZodiacSign
     *
     * @param input   - represents the incoming data provided by user
     * @param context - represents server side functions
     * @return result - results in a program saved valid instance of an id
     */
    @Override
    public GetZodiacResult handleRequest(GetZodiacRequest input, Context context) {


        // 1. Access this user's instance information added to DDB by Dao
        // 2. Access by userId the User instance
        // 3. Save user's birthdate
        // 4. Pass user's birthdate to DateCalculator .findUserZodiacAndElementalSign(LocalDate userBirthDate);

        String userId = input.getUserId();
        UserDao userDao = new UserDao();
        User thisUser = userDao.getUser(userId);

        LocalDate userBirthDate = LocalDate.parse(thisUser.getBirthDate());
        DateCalculator dateCalculator = new DateCalculator();
        String zodiacAndElementalSign = dateCalculator.findUserZodiacAndElementalSign(userBirthDate);


        // If you use split, you must be ready to store the 2 parts into an array!
        // Note, advanced use of this method allows for a # to be added to specify how many String pieces
        // should be output as individual elements in your String array

        String [] signsArray =  zodiacAndElementalSign.split(",", 2);

        String zodiac = signsArray[0];
        String elemental = signsArray[1];


        GetZodiacResult result = GetZodiacResult.builder().withUserId(userId)
                .withZodiacSign(zodiac).withElementalSign(elemental).build();

        return result;


    }
}