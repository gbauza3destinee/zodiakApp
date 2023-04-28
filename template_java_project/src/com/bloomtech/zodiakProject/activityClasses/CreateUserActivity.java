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

        // TODO: How to use a Hashmap to retrieve both key and value pair
        //TODO: Google how to format a date range in java

        switch (userBirthDate){
            case 3/21/2020 - 3/19/2020:
                thisUser.setZodiac("Aries");
               //TODO: Review HashMap retrieving both Key And Value!
                //elementalToZodiacMap.get("Aries");
                //thisUser.setElemental(fireSignsList.get(1)));
                System.out.println("Your Zodiac Sign is Aries");
                break;

            case 04/20 - 5/20:
                thisUser.setZodiac("Taurus");
                //thisUser.setElemental(elementalToZodiacMap.get("Earth","Taurus"));
                System.out.println("Your Zodiac Sign is Taurus");
                break;

            case 05/21 - 06/20:
                thisUser.setZodiac("Gemini");
                //thisUser.setElemental(elementalToZodiacMap.get("Air","Gemini"));
                System.out.println("Your Zodiac Sign is Gemini");
                break;

            case 06/21 - 07/22:
                thisUser.setZodiac("Cancer!");
                //thisUser.setElemental(elementalToZodiacMap.get("Water","Cancer"));
                System.out.println("Your Zodiac Sign is Cancer!");
                break;

            case 07/23 - 08/22:
                thisUser.setZodiac("Leo");
                //thisUser.setElemental(elementalToZodiacMap.get("Fire","Leo"));
                System.out.println("Your Zodiac Sign is Leo");
                break;

            case 08/23 - 09/22:
                thisUser.setZodiac("Virgo");
                //thisUser.setElemental(elementalToZodiacMap.get("Earth","Virgo"));
                System.out.println("Your Zodiac Sign is Virgo");
                break;

            case 09/23 - 10/22:
                thisUser.setZodiac("Libra");
                //thisUser.setElemental(elementalToZodiacMap.get("Air","Libra"));
                System.out.println("Your Zodiac Sign is Libra");
                break;

            case 10/23 - 11/21:
                thisUser.setZodiac("Scorpio");
                //thisUser.setElemental(elementalToZodiacMap.get("Water","Scorpio"));
                System.out.println("Your Zodiac Sign is Scorpio");
                break;

            case 11/22 - 12/21:
                thisUser.setZodiac("Sagittarius");
                //thisUser.setElemental(elementalToZodiacMap.get("Fire","Sagittarius"));
                System.out.println("Your Zodiac Sign is Sagittarius");
                break;

            case 12/22 - 01/19:
                thisUser.setZodiac("Capricorn");
                //thisUser.setElemental(elementalToZodiacMap.get("Earth","Capricorn"));
                System.out.println("Your Zodiac Sign is Capricorn");
                break;

            case 1/20- 2/18:
                thisUser.setZodiac("Aquarius");
                //thisUser.setElemental(elementalToZodiacMap.get("Air","Aquarius"));
                System.out.println("Your Zodiac Sign is Aquarius");
                break;

            case 02/19 - 03/20:
                thisUser.setZodiac("Pisces");
                //thisUser.setElemental(elementalToZodiacMap.get("Water","Pisces"));
                System.out.println("Your Zodiac Sign is Pisces");
                break;


        }




        /// from previous code- setting these values
        thisUser.setUserName(userName);
        thisUser.setBirthDate(userBirthDate.toString());
        thisUser.setPronouns(String.format("%s / %s", userPronouns, userPronouns));




        CreateUserResult result = CreateUserResult.builder().withbirthdate(userBirthDate)
                .withUserName(userName).withUserId(userId).withPronouns(userPronouns).build();

        return result;


    }
}
