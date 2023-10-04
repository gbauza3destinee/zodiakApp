package com.bloomtech.zodiakProject.ServiceProviders;
import dagger.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public final class DateCalculator {


    UserGeneratorService userGeneratorService;

    LocalDate usersBirthDate;
    public static HashMap<String, ArrayList<String>> elementalToZodiacMap;
    public static ArrayList<String> fireSignsList;
    public static ArrayList<String> airSignsList;
    public static ArrayList<String> waterSignsList;
    public static ArrayList<String> earthSignsList;



    //TODO: Fix Dagger tag dependency error




    /*  October 4th Update
        User Story : We are given a birthdate in MM/DD/YYYY format
            - If this date falls into a time span -> we get the sign first
            - Then, we check if this sign falls into an Elemental's HashMap
     */

    @Inject
    public DateCalculator() {


    }

    /**
     * Provides Access to all program, an organized list of each Element and their corresponding
     * Elemental values.
     * No return but populates the program's loaded HashMap containing the corresponding elementals + zodiac signs
     */
    public final void loadHashMapUtils() {

        // FIRE, ARIES, SAG, LEO,
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
     * 1st Step in the User's request, provided a BirthDate
     * identify the correct sun sign for this date range
     *
     * @param userBirthDate
     * @return String consisting of (Zodiac, Elemental)
     */

    public static String calculateZodiac(LocalDate userBirthDate) throws IllegalArgumentException{
        // Logic: DateForSeason vs  userBirthdate
        // checking if birthdate falls in certain range ^ (lower range / upper range)
        try{
            boolean validDate = UserGeneratorService.isValidString(userBirthDate.toString());
            if (!validDate){
                throw new IllegalArgumentException("Please format your date using - symbols and in YYYY - MM - DD format!");
            }

        } catch (IllegalArgumentException e){
            System.out.println("Sorry, you entered an invalid date format! Please only use the YYYY-MM-DD formaf");

        }

        // TODO: OCT 4 - EDIT removed hardwiring of Element & Zodiac
        if (LocalDate.parse("2020-19-03").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-21-04").compareTo(userBirthDate) == -1) {
            //Clause 1 Aries
            ArrayList<String> fireSignsList = elementalToZodiacMap.get("Fire");
            String fireZodiac = fireSignsList.get(1);

            return fireZodiac;

        } else if (LocalDate.parse("2020-20-04").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-20-05").compareTo(userBirthDate) == -1) {

            //Clause 2 :Taurus
            earthSignsList = elementalToZodiacMap.get("Earth");
            String earthZodiac = earthSignsList.get(2);
            return earthZodiac;

        } else if (LocalDate.parse("2020-21-05").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-20-06").compareTo(userBirthDate) == -1) {

            //Clause 3 - Gemini
            ArrayList<String> airSignsList = elementalToZodiacMap.get("Air");
            String airZodiac = airSignsList.get(1);
            return airZodiac;

        } else if (LocalDate.parse("2020-21-06").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-22-07").compareTo(userBirthDate) == -1) {
            //Clause 4- Cancer
            ArrayList<String> waterSignsList = elementalToZodiacMap.get("Water");
            String waterZodiac = waterSignsList.get(1);

            return waterZodiac;

        } else if (LocalDate.parse("2020-23-07").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-22-08").compareTo(userBirthDate) == -1) {
            // Clause 5- Leo
            fireSignsList = elementalToZodiacMap.get("Fire");
            String fireZodiac = fireSignsList.get(2);
            return fireZodiac;
        } else if (LocalDate.parse("2020-23-08").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-22-09").compareTo(userBirthDate) == -1) {
            // Clause 6- Virgo
            earthSignsList = elementalToZodiacMap.get("Earth");
            String userVirgoEarthElemental = earthSignsList.get(3);
            return userVirgoEarthElemental;

        } else if (LocalDate.parse("2020-23-09").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-22-10").compareTo(userBirthDate) == -1) {
            //Clause 7 - Libra
            airSignsList = elementalToZodiacMap.get("Air");
            String userLibraAirElemental = fireSignsList.get(2);
            return userLibraAirElemental;

        } else if (LocalDate.parse("2020-23-10").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-21-11").compareTo(userBirthDate) == -1) {
            //Clause 8 - Scorpio
            waterSignsList = elementalToZodiacMap.get("Water");
            String userScorpioWaterElemental = waterSignsList.get(2);
            return userScorpioWaterElemental;

        } else if (LocalDate.parse("2020-22-11").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-21-12").compareTo(userBirthDate) == -1) {
            //Clause 9 - Sagittarrius
            fireSignsList = elementalToZodiacMap.get("Fire");
            String userSagFireElemental = fireSignsList.get(3);
            return userSagFireElemental;

        } else if (LocalDate.parse("2020-22-12").compareTo(userBirthDate) <= 1 && LocalDate.parse("2020-19-01").compareTo(userBirthDate) == -1) {
            //Clause 10 - Capricorn
            earthSignsList = elementalToZodiacMap.get("Earth");
            String userCapEarthElemental = earthSignsList.get(1);
            return userCapEarthElemental;

        } else if (LocalDate.parse("2021-20-01").compareTo(userBirthDate) <= 1 && LocalDate.parse("2021-18-02").compareTo(userBirthDate) == -1) {

            //Clause 11 - Aquarius
            airSignsList = elementalToZodiacMap.get("Air");
            String userAquaAirElemental = airSignsList.get(3);
            return userAquaAirElemental;
        } else if (LocalDate.parse("2021-19-02").compareTo(userBirthDate) <= 1 && LocalDate.parse("2021-20-03").compareTo(userBirthDate) == -1) {
            //Clause 12 - Pisces
            waterSignsList = elementalToZodiacMap.get("Water");
            String userPiscesWaterElemental = waterSignsList.get(3);
            return "Pisces, Water";

        }

        return "Sorry, you entered an invalid date range! Please choose a date from" +
                "01/01/2020 onwards!";

    }


    /**
     * 2nd Step in the process of returning customer information.
     * Iterate through our hashmap data structure to identify the sign's elemental group
     * Where the "entry" refers to -> each element type (1/4)
     * Where value refers to the arraylist of 3 elements of each ArrayList.
     * @param zodiac
     * @return
     */
    public static String findZodiacElementalGroup(String zodiac) throws IllegalArgumentException{

        StringBuilder zodiacStringBuilding = new StringBuilder();
        zodiacStringBuilding.append(" ");
        // For Each 1/4 Element Groups, begin moving through entries
       for(Map.Entry<String, ArrayList<String>> entry : elementalToZodiacMap.entrySet()){

           // For each Sign in This 1 Element's arraylist
           for(String sign : entry.getValue()) {

               if (zodiac == sign) {
                   zodiacStringBuilding.append(entry.getKey());
                   //return entry.getKey();
               } else{
                   if(!elementalToZodiacMap.containsValue(zodiac)){
                       throw new IllegalArgumentException("The Zodiac could not be found in our DataSet!");
                   }
               }

           }

       }

        // Used a String Builder to be able to have access to String from outside the loop.
        return zodiacStringBuilding.toString();

    }
    public static void main(String[] args) {

        String elemental = findZodiacElementalGroup("Aries");
        System.out.println("The assigned elemental was: " + elemental);
        System.out.println("The expected elemental for Aries was: Fire");



        // Potential instructions + hello prompts

        //! For testing with Console print outputs

    }

}

