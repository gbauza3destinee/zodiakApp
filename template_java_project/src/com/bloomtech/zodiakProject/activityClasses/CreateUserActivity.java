package com.bloomtech.zodiakProject.activityClasses;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomtech.zodiakProject.DateGenerator;
import com.bloomtech.zodiakProject.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.Results.CreateUserResult;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.UserDao;
import com.bloomtech.zodiakProject.UserGeneratorService;

import javax.naming.Context;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

//TODO: Review with S, I outsourced the Hashmap + SwitchCase Ladder to the "DateGenerator" Class- go over syntax errors

public class CreateUserActivity implements RequestHandler <CreateUserRequest, CreateUserResult> {

    UserDao userDao;


    // DONE: Updated Logic to Assign new ID generator

    public CreateUserActivity(UserDao userDao) {

        this.userDao = userDao;
    }


    /**
     * Request Handler method that works with APi requests made by a user,
     * gathers 3 fields and saves to a User generated instance with a unique Id.
     * @param input - represents the incoming data provided by user
     * @param context - represents server side functions
     * @return result - results in a program saved valid instance of an id
     */
    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, Context context) {

        // Gather all incoming user data

        User thisUser = new User();
        String userId = UserGeneratorService.generateUserId();
        String userName = input.getUserName();
        String userPronouns = input.getPronouns();
        LocalDate userBirthdate = input.getBirthdate();


        // TODO: Review - how to use a Hashmap to retrieve both key and value pair
        //TODO: Google how to format a date range in java


        /// Set User's general fields
        thisUser.setUserId(userId);
        thisUser.setUserName(userName);
        thisUser.setBirthDate(input.getBirthdate().toString());
        thisUser.setPronouns(String.format("%s / %s", userPronouns, userPronouns));
        DateGenerator dateGenerator = new DateGenerator();

        // 4/28 Note- Here is where I swapped all the big logic for creating this ElementToZodiac HashMap,
       // and instead moved it into the Static but immutable Class "DateGenerator"
        dateGenerator.findUserZodiacAndElementalSign(input.getBirthdate());



        CreateUserResult result = CreateUserResult.builder().withbirthdate(userBirthdate)
                .withUserName(userName).withUserId(userId).withPronouns(userPronouns).build();

        return result;


    }
}
