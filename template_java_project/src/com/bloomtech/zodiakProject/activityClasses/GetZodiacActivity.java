package com.bloomtech.zodiakProject.activityClasses;

import com.bloomtech.zodiakProject.DateCalculator;
import com.bloomtech.zodiakProject.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.Requests.GetZodiacRequest;
import com.bloomtech.zodiakProject.Results.CreateUserResult;
import com.bloomtech.zodiakProject.Results.GetZodiacResult;
import com.bloomtech.zodiakProject.UserDao;

import javax.naming.Context;
import java.time.LocalDate;


//TODO: My logic for this class, consists of an existing user made by CreateUserRequest
// my goal is to find a way to tie up the new data (sign information) to the existing userId + user.

// Q: Which would I be adding logic to user (data facing)  or user model (program facing)?

public class GetZodiacActivity implements RequestHandler <GetZodiacRequest, GetZodiacResult> {

    public UserDao userDao;

    public GetZodiacActivity(UserDao userDao) {

        this.userDao = UserDao;

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



        // TODO: Access UserDAO Class getUserById() method

        // 1. Take in birthdate
        // 2. perform logic to find the elemental and zodiac sign

        LocalDate usersBirthDate = input.getBirthdate();

        DateCalculator dateCalculator = new DateCalculator();
        dateCalculator.findUserZodiacAndElementalSign(usersBirthDate);
        // the date calculator method will find the zodiak + elemental signs and set them to this user's profile.


        // Gets an existing by UserId
        input.getUserId();





        return null;


    }
}