package com.bloomtech.zodiakProject.activityClasses;
import com.bloomtech.zodiakProject.Requests.GetZodiacRequest;
import com.bloomtech.zodiakProject.Results.GetZodiacResult;
import com.bloomtech.zodiakProject.ServiceProviders.UserGeneratorService;
import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.User;
import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.UserModel;
import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


// TODO: Q*** Since the logic is done in CreateUSerActivityTest
// and this API endpoint just fetches with getters()
// already established elemental values-- do I need to implement
// tests for this file?
public class GetZodiacActivityTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    GetZodiacActivity getZodiacActivity;

    @BeforeEach
    void setUp(){
        initMocks(this);



    }


    /**
     *
     */



    @Test
    void handleRequest_UserProvidesValidAttributesInInput_UserValuesSaved() {

        User thisUser = new User();
        String userId =  UserGeneratorService.generateUserId();
        thisUser.setUserId(userId);

        String zodiac = "Aries";
        String elemental = "Fire";

        GetZodiacRequest input = new GetZodiacRequest(userId);
        input.setUserId(userId);


        when(userDao.getUser(userId)).thenReturn(thisUser);
        GetZodiacResult result =
                GetZodiacResult.builder().withUserId(userId).withZodiacSign(zodiac).withElementalSign(elemental).build();

        assertSame(result.getZodiacSign(), zodiac);
        assertSame(result.getZodiacSign(), elemental );

    }



    @Test
    void handleRequest_InvalidUserId_ResultsInvalidFormatExceptionThrown() {

        User thisUser = new User();
        String invalidUserId =  "13_ds*er!_s!!";
        thisUser.setUserId(invalidUserId);

        String zodiac = "Aries";
        String elemental = "Fire";

        GetZodiacRequest input = new GetZodiacRequest(invalidUserId);
        input.setUserId(invalidUserId);

        when(userDao.getUser(invalidUserId)).thenThrow(IllegalArgumentException.class);
        GetZodiacResult result =
                GetZodiacResult.builder().withUserId(invalidUserId).withZodiacSign(zodiac).withElementalSign(elemental).build();

        // THEN
        assertNull(result.getUserId());
        assertFalse(UserGeneratorService.isValidString(invalidUserId));




    }
}