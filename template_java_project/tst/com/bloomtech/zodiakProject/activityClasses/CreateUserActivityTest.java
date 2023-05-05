package com.bloomtech.zodiakProject.activityClasses;

import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

public class CreateUserActivityTest {


    @Mock
    UserDao userDao;

    @BeforeEach
    void setUp() {


        ArrayList<String> fireSignsList = new ArrayList<String>();
        fireSignsList.add("Aries");
        fireSignsList.add("Leo");
        fireSignsList.add("Sagittarius");

        ArrayList <String> airSignsList = new ArrayList<String>();
        airSignsList.add("Gemini");
        airSignsList.add("Libra");
        airSignsList.add("Aquarius");


        ArrayList <String> waterSignsList = new ArrayList<String>();
        waterSignsList.add("Cancer");
        waterSignsList.add("Scorpio");
        waterSignsList.add("Pisces");


        ArrayList<String> earthSignsList = new ArrayList<String>();
        earthSignsList.add("Capricorn");
        earthSignsList.add("Taurus");
        earthSignsList.add("Virgo");




    }


    @Test
    void handleRequest_receivesValidUserInput_AssertCreateUserResultIsValid() {


    }

    @Test
    void handleRequest_receivesInValidUserId_AssertInvalidFormatExceptionThrown() {


    }

    @Test
    void handleRequest_receivesInValidBirthDateFormat_AssertInvalidFormatExceptionThrown() {


    }


    @Test
    void handleRequest_dateCalculatorDoesNotProvideZodiac_AssertEmptySignsThrowNullPointerException() {


    }


}
