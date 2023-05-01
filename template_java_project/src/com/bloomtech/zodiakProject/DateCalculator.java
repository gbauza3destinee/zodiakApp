package com.bloomtech.zodiakProject;

import com.bloomtech.zodiakProject.ModelClasses.UserModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

//TODO: Change Switch Case into If/Else Ladder 5/1

public final class DateCalculator {

    UserDao userDao;
    UserModel userModel = new UserModel();
    LocalDate usersBirthDate;
    public HashMap<String, ArrayList<String>> elementalToZodiacMap;
    public ArrayList <String> fireSignsList;
    public ArrayList <String> airSignsList;
    public ArrayList <String> waterSignsList;
    public ArrayList <String> earthSignsList;

    public DateCalculator(){


    }

    /**
     * Provides Access to all program, an organized list of each Element and their corresponding
     * Elemental values.
     * No return but populates the program's loaded HashMap containing the corresponding elementals + zodiac signs
     */
    public final void loadHashMapUtils(){


        // Setting my HashMap

        HashMap <String, ArrayList<String>> elementalToZodiacMap = new HashMap<>();
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



    }


    public final HashMap<String, ArrayList<String>> getElementalToZodiacMap() {
        return elementalToZodiacMap;
    }


    //TODO: EDIT Syntax for cases & formatting a Date Range -- with oversight by more experienced developer!
    public void findUserZodiacAndElementalSign(LocalDate userBirthDate){
        // LocalDate -  userBirthdate

        if(LocalDate.parse("2020-19-03").compareTo(userBirthDate)<=1 && LocalDate.parse("2020-21-03").compareTo(userBirthDate)== -1 ){
        // checking if birthdate falls in certain range ^ (lower range / upper range)

            // Don't use usermodel in this class!
            // Return String: (Zodiac, Element Sign)
            // When we need to access this, use .split()
            // Since this is a utility class - do not let it modify objects (setting), just let it provide something
            // In Activity Class we can call this method + provide it to user instance (not user model)


        switch (userBirthDate) {
            case 3/19/2020 - 3/19/2020:

                //TODO FIX DATE!

                userModel.setZodiac("Aries");
                ArrayList<String> fireSignsList = elementalToZodiacMap.get("Fire");
                String userFireElemental = fireSignsList.get(1);
                userModel.setElemental(userFireElemental);

                //TODO: Review why these would not work for retrieving both Key And Value!
                //elementalToZodiacMap.get("Aries");
                //thisUser.setElemental(fireSignsList.get(1)));
                System.out.println("Your Zodiac Sign is Aries");
                break;

            case 04/20/2020 - 5/20/2020:
                userModel.setZodiac("Taurus");
                //thisUser.setElemental(elementalToZodiacMap.get("Earth","Taurus"));
                ArrayList<String> earthSignsList = elementalToZodiacMap.get("Earth");
                String userEarthElemental = earthSignsList.get(2);
                userModel.setElemental(userEarthElemental);
                System.out.println(userEarthElemental); //for testing values

                System.out.println("Your Zodiac Sign is Taurus");
                break;

            case 05/21/2020 - 06/20/2020:
                userModel.setZodiac("Gemini");
                ArrayList<String> airSignsList = elementalToZodiacMap.get("Air");
                String userAirElemental = fireSignsList.get(1);
                userModel.setElemental(userAirElemental);

                //TODO: Review why these would not work for retrieving both Key And Value!
                //elementalToZodiacMap.get("Aries");
                //thisUser.setElemental(elementalToZodiacMap.get("Air","Gemini"));
                System.out.println("Your Zodiac Sign is Gemini");
                break;

            case 06/21/2020 - 07/22/2020:

                userModel.setZodiac("Cancer");
                ArrayList<String> waterSignsList = elementalToZodiacMap.get("Water");
                String userWaterElemental = waterSignsList.get(1);
                userModel.setElemental(userWaterElemental);
                //thisUser.setElemental(elementalToZodiacMap.get("Water","Cancer"));
                System.out.println("Your Zodiac Sign is Cancer!");
                break;

            case 07/23/2020 - 08/22/2020:
                userModel.setZodiac("Leo");
                fireSignsList = elementalToZodiacMap.get("Fire");
                String userFireLeoElemental = fireSignsList.get(2);
                userModel.setElemental(userFireLeoElemental);

                //thisUser.setElemental(elementalToZodiacMap.get("Fire","Leo"));
                System.out.println("Your Zodiac Sign is Leo");
                break;

            case 08/23/2020 - 09/22/2020:
                userModel.setZodiac("Virgo");
                earthSignsList = elementalToZodiacMap.get("Earth");
                String userVirgoEarthElemental = fireSignsList.get(3);
                userModel.setElemental(userVirgoEarthElemental);

                //thisUser.setElemental(elementalToZodiacMap.get("Earth","Virgo"));
                System.out.println("Your Zodiac Sign is Virgo");
                break;

            case 09/23/2020 - 10/22/2020:
                userModel.setZodiac("Libra");
                airSignsList = elementalToZodiacMap.get("Air");
                String userLibraAirElemental = fireSignsList.get(2);
                userModel.setElemental(userLibraAirElemental);
                //thisUser.setElemental(elementalToZodiacMap.get("Air","Libra"));
                System.out.println("Your Zodiac Sign is Libra");
                break;

            case 10/23/2020 - 11/21/2020:
                userModel.setZodiac("Scorpio");
                waterSignsList = elementalToZodiacMap.get("Water");
                String userScorpioWaterElemental = waterSignsList.get(2);
                userModel.setElemental(userScorpioWaterElemental);
                //thisUser.setElemental(elementalToZodiacMap.get("Water","Scorpio"));
                System.out.println("Your Zodiac Sign is Scorpio");
                break;

            case 11/22/2020 - 12/21/2020:
                userModel.setZodiac("Sagittarius");
                fireSignsList = elementalToZodiacMap.get("Fire");
                String userSagFireElemental = fireSignsList.get(3);
                userModel.setElemental(userSagFireElemental);

                //thisUser.setElemental(elementalToZodiacMap.get("Fire","Sagittarius"));
                System.out.println("Your Zodiac Sign is Sagittarius");
                break;

            case 12/22/2020 - 01/19/2021:
                userModel.setZodiac("Capricorn");
                earthSignsList = elementalToZodiacMap.get("Earth");
                String userCapEarthElemental = earthSignsList.get(1);
                userModel.setElemental(userCapEarthElemental);

                //thisUser.setElemental(elementalToZodiacMap.get("Earth","Capricorn"));
                System.out.println("Your Zodiac Sign is Capricorn");
                break;

            case 1/20/2021 - 2/18/2021:
                userModel.setZodiac("Aquarius");
                airSignsList = elementalToZodiacMap.get("Air");
                String userAquaAirElemental = airSignsList.get(3);
                userModel.setElemental(userAquaAirElemental);

                //thisUser.setElemental(elementalToZodiacMap.get("Air","Aquarius"));
                System.out.println("Your Zodiac Sign is Aquarius");
                break;

            case 02/19/2021 - 03/20/2021:
                userModel.setZodiac("Pisces");
                waterSignsList = elementalToZodiacMap.get("Water");
                String userPiscesWaterElemental = fireSignsList.get(3);
                userModel.setElemental(userPiscesWaterElemental);

                //thisUser.setElemental(elementalToZodiacMap.get("Water","Pisces"));
                System.out.println("Your Zodiac Sign is Pisces");
                break;

            default:
                System.out.println("Sorry, you entered an invalid date range! Please choose a date from" +
                        "01/01/2020 onwards.");


        }


    }


    public static void main(String[] args) {

        // Potential instructions + hello prompts

        //! For testing with Console print outputs

    }

}
