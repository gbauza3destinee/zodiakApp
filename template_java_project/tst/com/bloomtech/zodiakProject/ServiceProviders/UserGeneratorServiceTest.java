package com.bloomtech.zodiakProject.ServiceProviders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

// TODO: Q T Is this test class even necessary if it uses a built in library "String Utils?"
//  There's not much logic here...

public class UserGeneratorServiceTest {

    @InjectMocks
    UserGeneratorService userGeneratorService;

    @BeforeEach
    void setUp(){
        initMocks(this);

    }


    @Test
    void isValidString_ValidUserIdGenerated_AssertResultIsTrue() {

    }


    @Test
    void isValidString_InvalidUserIdString_AssertResultIsFalse() {
    }


    @Test
    void generateUserId_validStringGenerated_AssertResultIsTrue() {
    }


}
