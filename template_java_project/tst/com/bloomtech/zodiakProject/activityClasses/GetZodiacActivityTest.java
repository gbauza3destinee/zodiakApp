//package com.bloomtech.zodiakProject.activityClasses;
//import com.bloomtech.zodiakProject.Requests.GetZodiacRequest;
//import com.bloomtech.zodiakProject.Results.GetZodiacResult;
//import com.bloomtech.zodiakProject.ServiceProviders.UserGeneratorService;
//import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.User;
//import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.UserModel;
//import com.bloomtech.zodiakProject.dynamoDBClasses.UserDao;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import java.time.MonthDay;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//// TODO: Fix error
//public class GetZodiacActivityTest {
//
//    @Mock
//    UserDao userDao;
//
//    @InjectMocks
//    GetZodiacActivity getZodiacActivity;
//
//    @Mock
//    GetZodiacRequest input;
//    @BeforeEach
//    void setUp(){
//        initMocks(this);
//        input = new GetZodiacRequest();
//
//    }
//
//    // Happy Case
//    @Test
//    void handleRequest_UserProvidesValidInput_ZodiacReturned() {
//
//        User thisUser = new User();
//        thisUser.setUserName("Holly");
//        thisUser.setPronouns("he him");
//        String zodiac = "Aries";
//        String elemental = "Fire";
//
//        MonthDay monthDay = MonthDay.of(03,31);
//
//        GetZodiacRequest input = new GetZodiacRequest();
//
//        // when(getZodiacActivity.handleRequest(input, null)).thenReturn()==;
//
//        GetZodiacResult result =
//                GetZodiacResult.builder().withZodiacSign(zodiac).withElementalSign(elemental).build();
//
//        assertSame(result.getZodiacSign(), zodiac);
//        assertSame(result.getZodiacSign(), elemental );
//
//    }
//
//
//    // Edge Case
//    @Test
//    void handleRequest_InvalidUserId_ResultsInvalidFormatExceptionThrown() {
//
//        User thisUser = new User();
//        MonthDay invalidUserBirthDate = MonthDay.parse("03-79");
//
//        String zodiac = "Aries";
//        String elemental = "Fire";
//
//        when(getZodiacActivity.handleRequest(input, null )).thenThrow(IllegalArgumentException.class);
//        GetZodiacResult result =
//                GetZodiacResult.builder().withZodiacSign(zodiac).withElementalSign(elemental).build();
//
//        // THEN
//        assertNull(thisUser.getBirthDate());
//        assertNull(result.getZodiacSign());
//
//
//    }
//}