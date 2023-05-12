package com.bloomtech.zodiakProject.activityClasses;
import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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



    // TODO: Test case- validate the GetZodiac result! 5/11
    @Test
    void handleRequest_UserProvidesValidAttributesInInput_UserValuesSaved() {




    }



    @Test
    void handleRequest_InvalidUserId_ResultsInvalidFormatExceptionThrown() {




    }
}