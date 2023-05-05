package com.bloomtech.zodiakProject.activityClasses;

import com.bloomtech.zodiakProject.Requests.GetZodiacRequest;
import com.bloomtech.zodiakProject.Results.GetZodiacResult;
import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class GetZodiacActivityTest {

    @Mock
    UserDao userDao;


    @BeforeEach
    void setUp(){

    }


    @Test
    void handleRequest_UserProvidesValidAttributesInInput_UserValuesSaved() {




    }



    @Test
    void handleRequest_InvalidUserId_ResultsInvalidFormatExceptionThrown() {




    }
}