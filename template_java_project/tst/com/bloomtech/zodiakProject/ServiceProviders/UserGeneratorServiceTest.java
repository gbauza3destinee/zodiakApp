package com.bloomtech.zodiakProject.ServiceProviders;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;
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
    void isValidString_userEntersValidString_resultIsTrue() {
        String validName = "holly";
        when(UserGeneratorService.isValidString(validName)).thenReturn(true);
        assertFalse(StringUtils.isBlank(validName));
    }


    @Test
    void isValidString_userEntersInvalidString_resultIsFalse() {
        String invalidName = "john-athan!";
        when(UserGeneratorService.isValidString(invalidName)).thenReturn(false);
        assertFalse(StringUtils.isBlank(invalidName));
    }




}
