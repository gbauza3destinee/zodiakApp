package com.bloomtech.zodiakProject.ServiceProviders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;


public class UserGeneratorServiceTest {

    @InjectMocks
    UserGeneratorService userGeneratorService;

    @BeforeEach
    void setUp(){
        initMocks(this);

    }


    @Test
    void isValidString_CustomerProvidesValidUserId_AssertResultIsTrue(final String stringToValidate) {

    }


    @Test
    void isValidString_InvalidUserId_AssertResultIsFalse(final String stringToValidate) {
    }


}
