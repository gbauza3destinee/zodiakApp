package com.bloomtech.zodiakProject.ServiceProviders;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.Assert;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

// import static org.junit.jupiter.api.Assertions;

// @SpringBootTest



// TODO Q T : Is this test Annotations necessary?

public class DateCalculatorTest {


    @InjectMocks
    DateCalculator dateCalculator;

    @Mock
    UserGeneratorService userGeneratorService;


    @BeforeEach
    void setUp() {

        validBirthDate = LocalDate.parse("12-23-1994");
        misMatchBirthDate = LocalDate.parse("09-02-2001");
        invalidBirthDate = LocalDate.parse("13/20/2023");

        initMocks(this);


        earthSignsList = new ArrayList<String>();
        earthSignsList.add("Capricorn");
        earthSignsList.add("Taurus");
        earthSignsList.add("Virgo");


    }


    /**
     * Happy case test for DateCalc Class, where a birthdate is provided, it is checked for validity, and then it is compared
     * @param validBirthDate
     * @throws InvalidFormatException
     */
    @Test
    public void findUserZodiacAndElementalSign_UserProvidesValidBirthDate_correctZodiacAndElementalReturned() throws InvalidFormatException {

        //Given - Check if user date is valid string

        String validBirthDate = "1995-11-09";

        when(dateCalculator.isValidString(validBirthDate)).thenReturn(true);


        //When : Evaluation is done between birthdate + Virgo seasonal date ranges.

        Assert.assertTrue(LocalDate.parse("2020-23-08").compareTo(validBirthDate) <= 1 && LocalDate.parse("2020-22-09").compareTo(validBirthDate) == -1);


        //THEN: Return Correct Answer

        String zodiacSign = earthSignsList.get(3);
        String elemental = "Earth";
        String zodiacElemental = zodiacSign + elemental;

        when(dateCalculator.findUserZodiacAndElementalSign(validBirthDate)).thenReturn(zodiacElemental);


    }



    /**
     * EdgeCase 1 test for DateCalc Class, where an invalid birthdate is provided and exception is throwm
     * @param validBirthDate
     * @throws InvalidFormatException
     */


    @Test
    public void findUserZodiacAndElementalSign_withInvalidBirthDate_ThrowsException() throws IllegalArgumentException {

        //Given - Evaluate validity of String Date
        String invalidBirthDate = "06/04/2002";

        when(dateCalculator.isValidString(invalidBirthDate)).thenReturn(false);

        //When = Comparison is done
        when(dateCalculator.findUserZodiacAndElementalSign(invalidBirthDate)).thenThrow(IllegalArgumentException);

        //Then - Assert answer provided is FALSE

        String wrongZodiacElemental = "Capricorn, Earth";
        String correctZodiacElemental = "Gemini, Air";
        AssertNotEquals(wrongZodiacElemental, correctZodiacElemental);
        AssertThrows(dateCalculator.findUserZodiacAndElementalSign(invalidBirthDate));



    }





    /**
     * EdgeCase 2 test for DateCalc Class, where an valid birthdate is provided but then wrong zodiac is provided.
     * @param validBirthDate
     * @throws InvalidFormatException
     */

    //TODO: Finish implementation tomorrow! 5/11

    @Test
    public void findUserZodiacAndElementalSign_ValidBirthDate_MisMatchZodiacElementalSign() {

        //GIVEN: A user provided birthdate that is valid.

        String validBirthDate = "2002-04-06";
        String wrongZodiacElemental = "Capricorn, Earth";
        String correctZodiacElemental = "Gemini, Air";

        when(dateCalculator.isValidString(validBirthDate)).thenReturn(true);


        //When : Evaluation is done between birthdate + Virgo seasonal date ranges.

        when(dateCalculator.findUserZodiacAndElementalSign).thenReturn(wrongZodiacElemental)

        //THEN: Return WRONG Answer for the user's birthdate!

        AssertNotTrue(invalidBirthDate !=wrongZodiacElemental);


    }


}
