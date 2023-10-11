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

import javax.naming.Context;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class CreateUserActivityTest {

    @InjectMocks
    CreateUserActivity createUserActivity;

    @Mock
    CreateUserResult result;



    @Mock
    UserDao userDao;

    @Mock
    UserGeneratorService userGeneratorService;

    @Mock
    DateCalculator dateCalculator;

    @BeforeEach
    void setUp() {
        initMocks(this);



        CreateUserRequest input = new CreateUserRequest();

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

        String userEntryBirthDate = "1994-04-24";
        when(UserGeneratorService.isValidString(userEntryBirthDate)).thenReturn(true);

        String userName = "lalaloopsie";
        String userPronouns = "they / them";

        when(UserGeneratorService.isValidString(userName)).thenReturn(true);
        when(UserGeneratorService.isValidString(userPronouns)).thenReturn(true);

        // WHEN: BirthDate is passed to the DateCalculator method

        String validZodiac = "Sagittarius";

        when(dateCalculator.calculateZodiac(MonthDay.parse(userEntryBirthDate))).thenReturn(validZodiac);

        // THEN: The result should be a valid instance


        //TODO : REDO the last part of test ->
        CreateUserRequest input = new CreateUserRequest();
        input.setUserName(userName);
        input.setPronouns(userPronouns);
        input.setBirthdate(MonthDay.parse(userEntryBirthDate));

        result = CreateUserResult.builder().withUserId(UserGeneratorService.generateUserId()).withUserName(userName).withbirthdate(MonthDay.parse(userEntryBirthDate)).withPronouns(userPronouns).build();

        Context context = null;

        when(createUserActivity.handleRequest(input, null)).thenReturn(result);

        // CAll handleRequest and it should return result

        // Validate result generated
        assertNotNull(result);


        // 1. Create a CreateResult
        // 2. Create a builder



    }


    /**
     * Edge Case 1 User  is valid and set and saved  -- DONE
     */
    @Test
    void handleRequest_receivesInvalidUserName_AssertIllegalArgumentThrown() {
        //GIVEN
        String userEntryBirthDate = "1994-04-24";

       //WHEN
        when(UserGeneratorService.isValidString(userEntryBirthDate)).thenReturn(true);

        String invalidUserName = "//eiu_*love!";
        String userPronouns = "they / them";

        when(UserGeneratorService.isValidString(invalidUserName)).thenThrow(IllegalArgumentException.class);

        //Then- assert that this result cannot be generated.

        CreateUserRequest input = new CreateUserRequest();
        input.setUserName(invalidUserName);
        input.setPronouns(userPronouns);
        input.setBirthdate(MonthDay.parse(userEntryBirthDate));

        result = CreateUserResult.builder().withUserId(UserGeneratorService.generateUserId()).withUserName(invalidUserName).withbirthdate(MonthDay.parse(userEntryBirthDate)).withPronouns(userPronouns).build();

        Context context = null;

        when(createUserActivity.handleRequest(input, null)).thenThrow(IllegalArgumentException.class);

        // CAll handleRequest and it should return result

        // Validate result generated
        assertNull(result.getUserName());

    }


    /**
     * Edge Case 2 User  is valid and set and saved  -- DONE
     */
    @Test
    void handleRequest_receivesInValidBirthDateFormat_AssertIllegalArgumentThrown() {

        //GIVEN
        String invalidBirthDate = "2094-02-30";
        when(UserGeneratorService.isValidString(invalidBirthDate)).thenReturn(false);

        //WHEN
        when(dateCalculator.calculateZodiac(MonthDay.parse(invalidBirthDate))).thenThrow(IllegalArgumentException.class);

        //THEN


        //TODO : REDO the last part of test ->
        CreateUserRequest input = new CreateUserRequest();

        String userName = "Barbara";
        String pronouns = "he/him";

        result = CreateUserResult.builder().withUserId(UserGeneratorService.generateUserId()).withUserName(userName).withbirthdate(MonthDay.parse(invalidBirthDate)).withPronouns(pronouns).build();

        Context context = null;

        when(createUserActivity.handleRequest(input, null)).thenReturn(result);

       assertNull(input.getBirthdate());





    }

}
