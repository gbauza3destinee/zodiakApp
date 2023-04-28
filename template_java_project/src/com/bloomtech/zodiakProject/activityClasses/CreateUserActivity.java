package com.bloomtech.zodiakProject.activityClasses;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomtech.zodiakProject.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.Results.CreateUserResult;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.UserDao;
import com.bloomtech.zodiakProject.UserGeneratorService;

import javax.naming.Context;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateUserActivity implements RequestHandler <CreateUserRequest, CreateUserResult> {

    UserDao userDao;


    // DONE: Updated Logic to Assign new ID generator

    public CreateUserActivity(UserDao userDao) {

        this.userDao = userDao;
    }


    /**
     * Request Handler method that works with APi requests made by a user,
     * gathers 3 fields and saves to a User generated instance with a unique Id.
     * @param input - represents the incoming data provided by user
     * @param context - represents server side functions
     * @return result - results in a program saved valid instance of an id
     */
    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, Context context) {

        // Gather all incoming user data

        User thisUser = new User();
        String userId = UserGeneratorService.generateUserId();
        thisUser.setUserId(userId);

        String userName = input.getUserName();
        String userPronouns = input.getPronouns();



        // Attempt at adding in logic to grab the correct Zodiac Sign for this given User Date
        HashMap <String, ArrayList<String>> elementalToZodiacMap = new HashMap<>();
        // < Fire, FireSignsArrayList

        // Each Elemental arraylist will have 3 signs stored
        ArrayList fireSignsList = new ArrayList();
        fireSignsList.add("Aries");
        fireSignsList.add("Leo");
        fireSignsList.add("Sagittarius");

        ArrayList airSignsList = new ArrayList();
        airSignsList.add("Gemini");
        airSignsList.add("Libra");
        airSignsList.add("Aquarius");


        ArrayList waterSignsList = new ArrayList();
        waterSignsList.add("Cancer");
        waterSignsList.add("Scorpio");
        waterSignsList.add("Pisces");


        ArrayList earthSignsList = new ArrayList();
        earthSignsList.add("Capricorn");
        earthSignsList.add("Taurus");
        earthSignsList.add("Virgo");


        // Setting my HashMap
        elementalToZodiacMap.put("Fire", fireSignsList);
        elementalToZodiacMap.put("Air", airSignsList);
        elementalToZodiacMap.put("Water", waterSignsList);
        elementalToZodiacMap.put("Earth", earthSignsList);



        // LocalDate -  userBirthdate

        LocalDate userBirthDate = input.getBirthdate();







        /// from previous code- setting these values
        thisUser.setUserName(userName);
        thisUser.setBirthDate(userBirthDate);
        thisUser.setPronouns(userPronouns);




        CreateUserResult result = CreateUserResult.builder().withbirthdate(userBirthDate)
                .withUserName(userName).withUserId(userId).withPronouns(userPronouns).build();

        return result;


    }
}
