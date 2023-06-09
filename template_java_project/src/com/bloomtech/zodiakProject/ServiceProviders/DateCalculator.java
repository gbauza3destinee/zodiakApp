package com.bloomtech.zodiakProject.ServiceProviders;
import dagger.Component;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public final class DateCalculator {


    UserGeneratorService userGeneratorService;

    LocalDate usersBirthDate;
    public static HashMap<String, ArrayList<String>> elementalToZodiacMap;
    public static ArrayList<String> fireSignsList;
    public static ArrayList<String> airSignsList;
    public static ArrayList<String> waterSignsList;
    public static ArrayList<String> earthSignsList;


    @Inject
    public DateCalculator() {


    }

    /**
     * Provides Access to all program, an organized list of each Element and their corresponding
     * Elemental values.
     * No return but populates the program's loaded HashMap containing the corresponding elementals + zodiac signs
     */
    public final void loadHashMapUtils() {


        // Setting my HashMap

        HashMap<String, ArrayList<String>> elementalToZodiacMap = new HashMap<>();
        ArrayList <String> fireSignsList = new ArrayList<>();
        fireSignsList.add("Aries");
        fireSignsList.add("Leo");
        fireSignsList.add("Sagittarius");

        ArrayList <String> airSignsList = new ArrayList<String>();
        airSignsList.add("Gemini");
        airSignsList.add("Libra");
        airSignsList.add("Aquarius");


        ArrayList <String >waterSignsList = new ArrayList<String>();
        waterSignsList.add("Cancer");
        waterSignsList.add("Scorpio");
        waterSignsList.add("Pisces");


        ArrayList <String> earthSignsList = new ArrayList<String>();
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


    /**
     * A method that takes in a User's birthdate and matches it to the correct Astrological Sun Sign
     *
     * @param userBirthDate
     * @return String consisting of (Zodiac, Elemental)
     */

    public static String findUserZodiacAndElementalSign(LocalDate userBirthDate) throws IllegalArgumentException{
        // Logic: DateForSeason vs  userBirthdate
        // checking if birthdate falls in certain range ^ (lower range / upper range)

        //Catch: Invalid Birthdate

        try{
            boolean validDate = UserGeneratorService.isValidString(userBirthDate.toString());
            if (!validDate){
                throw new IllegalArgumentException("Please format your date using - symbols and in YYYY - MM - DD format!");
            }

        } catch (IllegalArgumentException e){
            System.out.println("Sorry, you entered an invalid date format! Please only use the YYYY-MM-DD formaf");

        }


            //Clause 1 Aries
        if (LocalDate.parse("2020-19-03").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-21-04").compareTo(userBirthDate) == -1) {

            ArrayList<String> fireSignsList = elementalToZodiacMap.get("Fire");

            String fireZodiac = fireSignsList.get(1);

            String userZodiacAndElementalString = "Aries, Fire";

            return "Aries, Fire";

        } else if (LocalDate.parse("2020-20-04").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-20-05").compareTo(userBirthDate) == -1) {

            //Clause 2 :Taurus
            earthSignsList = elementalToZodiacMap.get("Earth");
            String earthZodiac = earthSignsList.get(2);

            String userZodiacAndElementalString = "Taurus, Earth";
            System.out.println(userZodiacAndElementalString);
            return userZodiacAndElementalString;
        } else if (LocalDate.parse("2020-21-05").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-20-06").compareTo(userBirthDate) == -1) {

            //Clause 3 - Gemini
            ArrayList<String> airSignsList = elementalToZodiacMap.get("Air");
            String airZodiac = airSignsList.get(1);

            return "Gemini, Air";

        } else if (LocalDate.parse("2020-21-06").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-22-07").compareTo(userBirthDate) == -1) {
            //Clause 4- Cancer
            ArrayList<String> waterSignsList = elementalToZodiacMap.get("Water");
            String waterZodiac = waterSignsList.get(1);

            return "Cancer, Water";

        } else if (LocalDate.parse("2020-23-07").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-22-08").compareTo(userBirthDate) == -1) {
            // Clause 5- Leo
            fireSignsList = elementalToZodiacMap.get("Fire");
            String fireZodiac = fireSignsList.get(2);
            return "Leo, Fire";
        } else if (LocalDate.parse("2020-23-08").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-22-09").compareTo(userBirthDate) == -1) {

            // Clause 6- Virgo
            earthSignsList = elementalToZodiacMap.get("Earth");
            String userVirgoEarthElemental = earthSignsList.get(3);
            return "Virgo, Earth";

        } else if (LocalDate.parse("2020-23-09").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-22-10").compareTo(userBirthDate) == -1) {
            //Clause 7 - Libra
            airSignsList = elementalToZodiacMap.get("Air");
            String userLibraAirElemental = fireSignsList.get(2);
            return "Libra, Air";

        } else if (LocalDate.parse("2020-23-10").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-21-11").compareTo(userBirthDate) == -1) {
            //Clause 8 - Scorpio
            waterSignsList = elementalToZodiacMap.get("Water");
            String userScorpioWaterElemental = waterSignsList.get(2);
            return "Scorpio, Water";

        } else if (LocalDate.parse("2020-22-11").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-21-12").compareTo(userBirthDate) == -1) {
            //Clause 9 - Sagittarrius

            fireSignsList = elementalToZodiacMap.get("Fire");
            String userSagFireElemental = fireSignsList.get(3);
            return "Sagittarius, Fire";

        } else if (LocalDate.parse("2020-22-12").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-19-01").compareTo(userBirthDate) == -1) {
            //Clause 10 - Capricorn

            earthSignsList = elementalToZodiacMap.get("Earth");
            String userCapEarthElemental = earthSignsList.get(1);
            return "Capricorn, Earth";
        } else if (LocalDate.parse("2021-20-01").compareTo(userBirthDate) <= 1 && LocalDate.parse("2021-18-02").compareTo(userBirthDate) == -1) {

            //Clause 11 - Aquarius
            airSignsList = elementalToZodiacMap.get("Air");
            String userAquaAirElemental = airSignsList.get(3);
            return "Aquarius, Air";
        } else if (LocalDate.parse("2021-19-02").compareTo(userBirthDate) <= 1 && LocalDate.parse("2021-20-03").compareTo(userBirthDate) == -1) {
            //Clause 12 - Pisces

            waterSignsList = elementalToZodiacMap.get("Water");
            String userPiscesWaterElemental = waterSignsList.get(3);
            return "Pisces, Water";

        }

        return "Sorry, you entered an invalid date range! Please choose a date from" +
                "01/01/2020 onwards!";

    }


    public static void main(String[] args) {

        // Potential instructions + hello prompts

        //! For testing with Console print outputs

    }

}

