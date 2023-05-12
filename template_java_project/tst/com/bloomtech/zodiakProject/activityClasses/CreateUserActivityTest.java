package com.bloomtech.zodiakProject.activityClasses;

import com.bloomtech.zodiakProject.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.Results.CreateUserResult;
import com.bloomtech.zodiakProject.ServiceProviders.DateCalculator;
import com.bloomtech.zodiakProject.ServiceProviders.UserGeneratorService;
import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class CreateUserActivityTest {

    @InjectMocks
    CreateUserActivity createUserActivity;


    // TODO: Are these 2  necessary? Adding into scope the Request
    // and Result Classes in order to mimic the "Result"


    @Mock
    UserDao userDao;

    @Mock
    UserGeneratorService userGeneratorService;

    @Mock
    DateCalculator dateCalculator;

    @BeforeEach
    void setUp() {
        initMocks(this);


        CreateUserRequest createUserRequest = new CreateUserRequest();
        CreateUserResult createUserResult = new CreateUserResult();

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


    /**
     * Happy Case where User Entry information is valid and set and saved  -- DONE
     */

    @Test
    void handleRequest_receivesValidUserInput_AssertUserResultIsValid() {

        // GIVEN: Checking validity of  User Entry

        String userEntryBirthDate = "1994-24-04";
        when(UserGeneratorService.isValidString(userEntryBirthDate)).thenReturn(true);

        String userName = "lalaloopsie";
        String userPronouns = "they / them";

        when(UserGeneratorService.isValidString(userName)).thenReturn(true);
        when(UserGeneratorService.isValidString(userPronouns)).thenReturn(true);

        // WHEN: BirthDate is passed to the DateCalculator method

        String validZodiac = "Sagittarius, Fire";

        when(DateCalculator.findUserZodiacAndElementalSign(LocalDate.parse(userEntryBirthDate))).thenReturn(validZodiac);

        // THEN: The result should be a valid instance


        //TODO : REDO the last part of test ->

        // CAll handleRequest and it should return result

        // Validate result generated
        assertNotNull(userEntryBirthDate & validZodiac & userName & userPronouns);


        // 1. Create a CreateResult
        // 2. Create a builder



    }


    /**
     * Edge Case 1 User  is valid and set and saved  -- DONE
     */
    @Test
    void handleRequest_receivesInvalidUserName_AssertIllegalArgumentThrown() {
        //GIVEN
        String userEntryBirthDate = "1994-24-04";

       //WHEN
        when(UserGeneratorService.isValidString(userEntryBirthDate)).thenReturn(true);

        String userName = "//eiu_*love!";
        String userPronouns = "they / them";

        when(UserGeneratorService.isValidString(userName)).thenThrow(IllegalArgumentException);

        //Then- assert that this result cannot be generated.

      AssertNull(userName);
      AssertNull(createUserResult);
    }


    /**
     * Edge Case 2 User  is valid and set and saved  -- DONE
     */
    @Test
    void handleRequest_receivesInValidBirthDateFormat_AssertIllegalArgumentThrown() {

        //GIVEN
        String userEntryBirthDate = "2094-30-02";
        when(UserGeneratorService.isValidString(userEntryBirthDate)).thenReturn(false);

        //WHEN
        when(DateCalculator.findUserZodiacAndElementalSign(LocalDate.parse(userEntryBirthDate))).thenThrow(IllegalArgumentException);

        //THEN

        // TODO: Q Does this suffice for proving the failed
        // execution of this method due to invalid birthdate.
       AssertNull(userEntryBirthDate);
       AssertNull(createUserResult);



    }

}
