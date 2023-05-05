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

public class DateCalculatorTest {


    @InjectMocks
    DateCalculator dateCalculator;

    @Mock
    LocalDate validBirthDate;

    @Mock
    LocalDate misMatchBirthDate;

    @Mock
    LocalDate invalidBirthDate;
    @Mock
    ArrayList<String> earthSignsList;

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

    // Test : Happy Case 1 Test Case Done

    @Test
    public void findUserZodiacAndElementalSign_UserProvidesValidBirthDate_correctZodiacAndElementalReturned(LocalDate validBirthDate) throws InvalidFormatException {

        //Given


        ArrayList<String> earthSignsList = new ArrayList<String>();
        earthSignsList.add("Capricorn");
        earthSignsList.add("Taurus");
        earthSignsList.add("Virgo");
        String validZodiacAndElemental = "Capricorn, Earth";


        //When

        Assert.assertTrue(LocalDate.parse("2020-22-12").compareTo(validBirthDate) <= 1 &&
                LocalDate.parse("2020-19-01").compareTo(validBirthDate) == -1);

        String zodiacSign = earthSignsList.get(1);
        String elemental = "Earth";
        String zodiacElemental = zodiacSign + elemental;


        when(dateCalculator.findUserZodiacAndElementalSign(validBirthDate)).thenReturn(zodiacElemental);

        //Then


    }


    //TODO: Implement this test case
    @Test
    public void findUserZodiacAndElementalSign_ProgramProvidesWrongZodiac(LocalDate localDate) throws InvalidFormatException {

        //Given

        String wrongZodiacElemental = "Capricorn, Earth";
        String correctZodiacElemental = "Virgo, Earth";

        //When

        // LocalDate.parse("2020-19-03").compareTo(validBirthDate) <= 1 && LocalDate.parse("2020-21-04").compareTo(validBirthDate) == -1))
        when(dateCalculator.findUserZodiacAndElementalSign(misMatchBirthDate)).thenReturn(wrongZodiacElemental);

        //Then


        // Assert.assertFalse(!wrongZodiacElemental.equals(correctZodiacElemental));


    }


    //TODO: Implement this test case

    // Test : Edge Case 1
    @Test
    public void findUserZodiacAndElementalSign_UserProvidesInvalidBirthDate(LocalDate userBirthDate) throws InvalidFormatException {

        //Given


        //When


        //Then


    }

    // Test : Edge Case 2


    //TODO: Implement this test case

    @Test
    public void findUserZodiacAndElementalSign_UserProvidesInvalidCharacters(LocalDate userBirthDate) throws InvalidFormatException {


        when(UserGeneratorService.isValidString(invalidBirthDate.toString())).thenThrow(InvalidFormatException.class);


    }


}
