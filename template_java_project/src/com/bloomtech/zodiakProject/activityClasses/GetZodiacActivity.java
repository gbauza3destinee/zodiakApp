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


// TODO: Does this class need a UserDao passed into constructor? Reference Music Playlist Service and If not, delete


@Component
public class GetZodiacActivity implements RequestHandler <GetZodiacRequest, GetZodiacResult> {


    public UserDao userDao;

    public GetZodiacActivity(UserDao userDao) {

        this.userDao = userDao;

    }



    /** Request Handler method that works with API requests made by a user,
     * to save to their UserID, their corresponding ElementalSign, ZodiacSign
     * @param input  represents the incoming data provided by user
     * @param context represents server side functions
     * @return results in a program saved valid instance of an id
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

        String zodiac = thisUser.getZodiac();
        String elemental = thisUser.getElemental();

        userDao.saveUser(thisUser);

        GetZodiacResult result = GetZodiacResult.builder().withUserId(userId)
                .withZodiacSign(zodiac).withElementalSign(elemental).build();

        return result;


    }
}