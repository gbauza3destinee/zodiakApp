package com.bloomtech.zodiakProject.ServiceProviders;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;



public class UserGeneratorServiceTest {

    @InjectMocks
    UserGeneratorService userGeneratorService;

    @BeforeEach
    void setUp(){
        initMocks(this);

    }


    @Test
    void isValidString_ValidUserIdGenerated_AssertResultIsTrue() {
        String validUserId = UserGeneratorService.generateUserId();
        when(UserGeneratorService.isValidString(validUserId)).thenReturn(true);



    }


    @Test
    void isValidString_BlankUserId_AssertResultIsFalse() {
        String validUserId = UserGeneratorService.generateUserId();
        String invalidUserId = " ";
        when(UserGeneratorService.isValidString(invalidUserId)).thenReturn(false);

        assertTrue(StringUtils.isBlank(invalidUserId));

    }




}
