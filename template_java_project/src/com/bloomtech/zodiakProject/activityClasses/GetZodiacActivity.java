package com.bloomtech.zodiakProject.activityClasses;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomtech.zodiakProject.Requests.GetZodiacRequest;
import com.bloomtech.zodiakProject.Results.GetZodiacResult;
import com.bloomtech.zodiakProject.dynamoDBClasses.Entity.Zodiac;
import com.bloomtech.zodiakProject.dynamoDBClasses.ZodiacDao;


public class GetZodiacActivity implements RequestHandler<GetZodiacRequest, GetZodiacResult> {


    public ZodiacDao zodiacDao;

    public GetZodiacActivity(ZodiacDao zodiacDao) {

        this.zodiacDao = zodiacDao;

    }

    /**
     * A method that processes the request received from user. Should take a user's birthdate and then send out
     * the correct string zodiac sign and elemental
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return GetZodiacResult a program created result that provides elemental and zodiac sign information for user's birthdate.
     */
    public GetZodiacResult handleRequest(GetZodiacRequest input, com.amazonaws.services.lambda.runtime.Context context) {

        // 1. Access this user's instance information added to DDB by Dao
        // 2. Access by userId the User instance
        // 3. Save user's birthdate
        // 4. Pass user's birthdate to DateCalculator .findUserZodiacAndElementalSign(LocalDate userBirthDate);






        return null;
    }


}