package com.bloomtech.zodiakProject.activityClasses;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomtech.zodiakProject.ServiceProviders.DateCalculator;
import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.User;
import com.bloomtech.zodiakProject.Requests.GetZodiacRequest;
import com.bloomtech.zodiakProject.Results.GetZodiacResult;
import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import dagger.Component;

import javax.naming.Context;
import java.time.LocalDate;


// TODO: Fix Activity Classes' Spring Annotations + RequestHandler + @Override Red Lines 5/11

@Component
public class GetZodiacActivity implements RequestHandler<GetZodiacRequest, GetZodiacResult> {


    public UserDao userDao;

    public GetZodiacActivity(UserDao userDao) {

        this.userDao = userDao;

    }




    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return
     */
    @Override
    public GetZodiacResult handleRequest(GetZodiacRequest input, com.amazonaws.services.lambda.runtime.Context context) {

        // 1. Access this user's instance information added to DDB by Dao
        // 2. Access by userId the User instance
        // 3. Save user's birthdate
        // 4. Pass user's birthdate to DateCalculator .findUserZodiacAndElementalSign(LocalDate userBirthDate);

        //Id was Already generated in Create User Activity
        String userId = input.getUserId();
        UserDao userDao = new UserDao();
        User thisUser = userDao.getUser(userId);

        String zodiac = thisUser.getZodiac();
        String elemental = thisUser.getElemental();

        // Deleted Logic for Calculating DateCalculator's find zodiac
        // since CreateActivity parses and sets these signs.

        userDao.saveUser(thisUser);

        GetZodiacResult result = GetZodiacResult.builder().withUserId(userId)
                .withZodiacSign(zodiac).withElementalSign(elemental).build();

        return result;




    }
}