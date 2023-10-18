package com.bloomtech.zodiakProject.activityClasses;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomtech.zodiakProject.ServiceProviders.DateCalculator;
import com.bloomtech.zodiakProject.ServiceProviders.UserGeneratorService;
import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.User;
import com.bloomtech.zodiakProject.Requests.GetZodiacRequest;
import com.bloomtech.zodiakProject.Results.GetZodiacResult;
import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import dagger.Component;

import javax.inject.Inject;
import javax.naming.Context;
import java.time.LocalDate;


public class GetZodiacActivity implements RequestHandler<GetZodiacRequest, GetZodiacResult> {


    public UserDao userDao;

    @Inject
    public GetZodiacActivity(UserDao userDao) {

        this.userDao = userDao;

    }


    // THIS METHOD Was about retrieving an existing saved user, but I am making it more about
    // retrieving just the Zodiac String sign for a user.



    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return GetZodiacResult a program created result that provides elemental and zodiac sign information for user's birthdate.
     */
    @Override
    public GetZodiacResult handleRequest(GetZodiacRequest input, com.amazonaws.services.lambda.runtime.Context context) {

        // 1. Access this user's instance information added to DDB by Dao
        // 2. Access by userId the User instance
        // 3. Save user's birthdate
        // 4. Pass user's birthdate to DateCalculator .findUserZodiacAndElementalSign(LocalDate userBirthDate);

        //Id was Already generated in Create User Activity
        // TODO: Oct 18, for the new 1 action service, I will generate

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


        String zodiac = new DateCalculator().calculateZodiac(input.getBirthdate());
        String elemental = new DateCalculator().findZodiacElementalGroup(zodiac);

        // SET Zodiac + Elemental
        thisUser.setZodiac(zodiac);
        thisUser.setElemental(elemental);

        // Save this User instance and information
        UserDao userDao = new UserDao();
        userDao.saveUser(thisUser);



//        String userId = UserGeneratorService.generateUserId();
//
//        // String userId = input.getUserId();
//        UserDao userDao = new UserDao();
//        User thisUser = userDao.getUser(userId);
//
//        String zodiac = thisUser.getZodiac();
//        String elemental = thisUser.getElemental();
//
//        // Deleted Logic for Calculating DateCalculator's find zodiac
//        // since CreateActivity parses and sets these signs.
//
//        userDao.saveUser(thisUser);

        GetZodiacResult result = GetZodiacResult.builder().withUserId(userId)
                .withZodiacSign(zodiac).withElementalSign(elemental).build();

        return result;


        /**
         * Create method logic -> I dont need to create a
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


         String zodiac = new DateCalculator().calculateZodiac(input.getBirthdate());
         String elemental = new DateCalculator().findZodiacElementalGroup(zodiac);

         // SET Zodiac + Elemental
         thisUser.setZodiac(zodiac);
         thisUser.setElemental(elemental);

         // Save this User instance and information
         UserDao userDao = new UserDao();
         userDao.saveUser(thisUser);

         */



    }
}