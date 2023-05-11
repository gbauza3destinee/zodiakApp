package com.bloomtech.zodiakProject.activityClasses;

import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.MockitoAnnotations.initMocks;
@SpringBootTest

public class CreateUserActivityTest {

    @InjectMocks
    CreateUserActivity createUserActivity;

    @Mock
    CreateUserRequest createUserRequest;


    @Mock
    CreateUserResult createUserResult;

    @Mock
    UserDao userDao;

    @Mock
    UserGeneratorService userGeneratorService;

    @Mock
    DateCalculator dateCalculator;

    @BeforeEach
    void setUp() {
        initMocks(this);



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

        // GIVEN: The User Entry Details provided are checked against the UserGeneratorService ValidString()

        when(userGeneratorService.isValidString(userEntryBirthDate)).thenReturn(true);

        // WHEN: Date is passed to DateCalculator method
        String userEntryBirthDate = "1998-30-06";

        String userName = "lalaloopsie";

        String userPronouns = "they / them";

        when(dateCalculator.findUserZodiacAndElementalSign()).thenReturn(validZodiac);

        // THEN: Assert result returned is Valid!
        String validZodiac = "Cancer, Water";

        String userName = "lalaloopsie";

        //TODO : If I do not have access to the CreateUserResult Class, how can I prove this method returns all fields
        AssertNotNull(userEntryBirthDate & validZodiac & userName & userPronouns);



    }


    /**
     * Edge Case 1 User  is valid and set and saved  -- DONE
     */

    // TODO : Implement EdgeCase UserName


    @Test
    void handleRequest_receivesInvalidUserName_AssertIllegalArgumentThrown() {


    }


    /**
     * Edge Case 2 User  is valid and set and saved  -- DONE
     */


   // TODO: Implement EdgeCase UserBirthDate

    @Test
    void handleRequest_receivesInValidBirthDateFormat_AssertIllegalArgumentThrown() {


    }

}
