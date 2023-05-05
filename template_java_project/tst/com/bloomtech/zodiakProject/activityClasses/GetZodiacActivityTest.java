package com.bloomtech.zodiakProject.activityClasses;
import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;

public class GetZodiacActivityTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    GetZodiacActivity getZodiacActivity;

    @BeforeEach
    void setUp(){
        initMocks(this);

    }


    @Test
    void handleRequest_UserProvidesValidAttributesInInput_UserValuesSaved() {




    }



    @Test
    void handleRequest_InvalidUserId_ResultsInvalidFormatExceptionThrown() {




    }
}