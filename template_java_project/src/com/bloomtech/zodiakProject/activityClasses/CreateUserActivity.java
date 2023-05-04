package com.bloomtech.zodiakProject.activityClasses;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomtech.zodiakProject.ServiceProviders.DateCalculator;
import com.bloomtech.zodiakProject.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.Results.CreateUserResult;
import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.User;
import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import com.bloomtech.zodiakProject.ServiceProviders.UserGeneratorService;

import java.time.LocalDate;


public class CreateUserActivity implements RequestHandler <CreateUserRequest, CreateUserResult> {

    @Autowired
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
        String userPronouns = input.getPronouns();
        LocalDate userBirthdate = input.getBirthdate();
        String userName = input.getUserName();



        /// Set User's general fields
        String userId = UserGeneratorService.generateUserId();
        thisUser.setUserId(userId);
        thisUser.setUserName(userName);
        thisUser.setBirthDate(input.getBirthdate().toString());
        thisUser.setPronouns(String.format("%s / %s", userPronouns, userPronouns));
        DateCalculator dateCalculator = new DateCalculator();



        // THIS LOGIC WILL CHANGE AFTER DateCalculator Class changes from switchcase to if/else ladder


            String = dateCalculator.findUserZodiacAndElementalSign(input.getBirthdate());
// leave return type as a stirng.
//        String [] signsArray =  zodiacAndElementalSign.split(",", 2);
//        String zodiac = signsArray[0];
//        String elemental = signsArray[1];


        // TODO : Set thisUser. (elemental), (zodiac)
        //TODO: SAVE USERDAO here.


        CreateUserResult result = CreateUserResult.builder().withbirthdate(userBirthdate)
                .withUserName(userName).withUserId(userId).withPronouns(userPronouns).build();

        return result;


    }
}
