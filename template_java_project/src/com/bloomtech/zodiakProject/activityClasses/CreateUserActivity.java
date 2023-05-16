package com.bloomtech.zodiakProject.activityClasses;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomtech.zodiakProject.ServiceProviders.DateCalculator;
import com.bloomtech.zodiakProject.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.Results.CreateUserResult;
import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.User;
import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import com.bloomtech.zodiakProject.ServiceProviders.UserGeneratorService;
import dagger.Component;

import javax.inject.Inject;
import javax.naming.Context;


public class CreateUserActivity implements RequestHandler<CreateUserRequest, CreateUserResult> {

    public UserDao userDao;


@Inject
    public CreateUserActivity(UserDao userDao) {

        this.userDao = userDao;
    }




    /**
     *
     * @param input The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return CreateUserResult a valid, instance of a customer result.
     */
    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, com.amazonaws.services.lambda.runtime.Context context) {

        //  GET - Gather all incoming user data
        UserGeneratorService userGeneratorService;
        User thisUser = new User();

        boolean validPronoun = UserGeneratorService.isValidString(input.getPronouns());
        boolean validBirthDate = UserGeneratorService.isValidString(input.getBirthdate().toString());
        boolean validUserName = UserGeneratorService.isValidString(input.getUserName().toString());

        // Catch Illegal Strings sent by User
        String userId;
        if (!validPronoun || !validBirthDate || !validUserName) {
            throw new IllegalArgumentException("Please re-enter your pronoun, " +
                    "birthdate and username, using no / signs and using a date earlier than 2020");
        } else {
            // User information is Valid and can be set in program.
            thisUser.setUserName(input.getUserName());
            thisUser.setPronouns(String.format("%s / %s", input.getPronouns(), input.getPronouns()));
            thisUser.setBirthDate(input.getBirthdate().toString());

            /// Generate UserId
            userId = UserGeneratorService.generateUserId();
            thisUser.setUserId(userId);
        }

        String zodiacAndElementalSign = DateCalculator.findUserZodiacAndElementalSign(input.getBirthdate());

        // Use Split = Array, and Set each User Sign ( Zodiac, Elemental)
        String[] signsArray = zodiacAndElementalSign.split(",", 2);
        String zodiac = signsArray[0];
        String elemental = signsArray[1];


        // SET Zodiac + Elemental
        thisUser.setZodiac(zodiac);
        thisUser.setElemental(elemental);

        // Save this User instance and information
        UserDao userDao = new UserDao();
        userDao.saveUser(thisUser);


        CreateUserResult result = CreateUserResult.builder().withbirthdate(input.getBirthdate())
                .withUserName(input.getUserName()).withUserId(userId).withPronouns(input.getPronouns()).build();

        return result;

    }
}
