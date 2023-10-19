package com.bloomtech.zodiakProject.ServiceProviders;
import javax.inject.Inject;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public final class DateCalculator {

    public static HashMap<String, ArrayList<String>> elementalToZodiacMap;
    public static ArrayList<String> fireSignsList;
    public static ArrayList<String> airSignsList;
    public static ArrayList<String> waterSignsList;
    public static ArrayList<String> earthSignsList;



    @Inject
    public DateCalculator() {
        elementalToZodiacMap = new HashMap<>();
    }

    /**
     * Provides Access to all program, an organized list of each Element and their corresponding
     * Elemental values.
     * No return but populates the program's loaded HashMap containing the corresponding elementals + zodiac signs
     */
    public final void loadHashMapUtils() {

        // FIRE, ARIES, SAG, LEO,
        // Setting my HashMap

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

    /***
     *  LOGIC of Method is to Check if birthdate falls in certain range ^ (lower range / upper range)
     * @param userBirthDate
     * @return the String representative of this user's zodiac sign.
     * @throws IllegalArgumentException
     */

    public String calculateZodiac(MonthDay userBirthDate) throws IllegalArgumentException{

        loadHashMapUtils(); // setting up lists & hashmaps to refer to later

        try{
            boolean validDate = UserGeneratorService.isValidString(userBirthDate.toString());
            if (!validDate){
                throw new IllegalArgumentException("Please format your date using - symbols and in MM - DD format!");
            }

        } catch (IllegalArgumentException e){
            System.out.println("Sorry, you entered an invalid date format! Please only use the MM-DD format");

        }

        // TODO : Oct 6 Swap Date to look like 1998 - 03 - 31 (date) *************************************
        // TODO : OCT 6  In order to remove year, I will be using the Java object "MonthDay" and .of() method since .parse() seems to not read symhols "-" well
        // TODO : Review Trade offs of MonthDay method .of() vs .parse()  ---->  User input will use normal format that works with parse method, whereas


        if (MonthDay.of(03, 21).compareTo(userBirthDate) <= 1 && MonthDay.of(04, 19).compareTo(userBirthDate) == -1) {
            //Clause 1 Aries
            ArrayList<String> fireSignsList = elementalToZodiacMap.get("Fire");
            String fireZodiac = fireSignsList.get(1);

            return fireZodiac;

        } else if (MonthDay.of(04,20 ).compareTo(userBirthDate) <= 1 && MonthDay.of(5,20).compareTo(userBirthDate) == -1) {

            //Clause 2 :Taurus
            earthSignsList = elementalToZodiacMap.get("Earth");
            String earthZodiac = earthSignsList.get(2);
            return earthZodiac;

        } else if (MonthDay.of(05, 21).compareTo(userBirthDate) <= 1 && MonthDay.of(06, 20).compareTo(userBirthDate) == -1) {

            //Clause 3 - Gemini
            ArrayList<String> airSignsList = elementalToZodiacMap.get("Air");
            String airZodiac = airSignsList.get(1);
            return airZodiac;

        } else if (MonthDay.of(06,21).compareTo(userBirthDate) <= 1 && MonthDay.of(07,22).compareTo(userBirthDate) == -1) {
            //Clause 4- Cancer
            ArrayList<String> waterSignsList = elementalToZodiacMap.get("Water");
            String waterZodiac = waterSignsList.get(1);

            return waterZodiac;

        } else if (MonthDay.of(07,23).compareTo(userBirthDate) <= 1 && MonthDay.of(8, 22).compareTo(userBirthDate) == -1) {
            // Clause 5- Leo
            fireSignsList = elementalToZodiacMap.get("Fire");
            String fireZodiac = fireSignsList.get(2);
            return fireZodiac;
        } else if (MonthDay.of(8, 23).compareTo(userBirthDate) <= 1 && MonthDay.of(9,22).compareTo(userBirthDate) == -1) {
            // Clause 6- Virgo
            earthSignsList = elementalToZodiacMap.get("Earth");
            String userVirgoEarthElemental = earthSignsList.get(3);
            return userVirgoEarthElemental;

        } else if (MonthDay.of(9,23).compareTo(userBirthDate) <= 1 && MonthDay.of(10,22).compareTo(userBirthDate) == -1) {
            //Clause 7 - Libra
            airSignsList = elementalToZodiacMap.get("Air");
            String userLibraAirElemental = fireSignsList.get(2);
            return userLibraAirElemental;

        } else if (MonthDay.of(10,23).compareTo(userBirthDate) <= 1 && MonthDay.of(11,21).compareTo(userBirthDate) == -1) {
            //Clause 8 - Scorpio
            waterSignsList = elementalToZodiacMap.get("Water");
            String userScorpioWaterElemental = waterSignsList.get(2);
            return userScorpioWaterElemental;

        } else if (MonthDay.of(11,22).compareTo(userBirthDate) <= 1 && MonthDay.of(12, 21).compareTo(userBirthDate) == -1) {
            //Clause 9 - Sagittarrius
            fireSignsList = elementalToZodiacMap.get("Fire");
            String userSagFireElemental = fireSignsList.get(3);
            return userSagFireElemental;

        } else if (MonthDay.of(12, 22).compareTo(userBirthDate) <= 1 && MonthDay.of(01, 19).compareTo(userBirthDate) == -1) {
            //Clause 10 - Capricorn
            earthSignsList = elementalToZodiacMap.get("Earth");
            String userCapEarthElemental = earthSignsList.get(1);
            return userCapEarthElemental;

        } else if (MonthDay.of(01, 20).compareTo(userBirthDate) <= 1 && MonthDay.of(02,18).compareTo(userBirthDate) == -1) {

            // TODO: when debugging the date " 03-31" takes me to AQUARIUS if statement for entry " 03-31"
            //Clause 11 - Aquarius
            airSignsList = elementalToZodiacMap.get("Air");
            String userAquaAirElemental = airSignsList.get(airSignsList.size()-1);
            return userAquaAirElemental;
        } else if (MonthDay.of(02, 19).compareTo(userBirthDate) <= 1 && MonthDay.of(03,20).compareTo(userBirthDate) == -1) {
            //Clause 12 - Pisces
            waterSignsList = elementalToZodiacMap.get("Water");
            String userPiscesWaterElemental = waterSignsList.get(3);
            return "Pisces, Water";

        }

        return "Sorry, you entered an invalid date range! Please choose a date from" +
                "01/01 onwards!";

    }


    /**
     * 2nd Step in the process of returning customer information.
     * Iterate through our hashmap data structure to identify the sign's elemental group
     * Where the "entry" refers to -> each element type (1/4)
     * Where value refers to the arraylist of 3 elements of each ArrayList.
     * @param zodiac
     * @return
     */
    public String findZodiacElementalGroup(String zodiac) throws IllegalArgumentException{

        StringBuilder zodiacStringBuilding = new StringBuilder();
        zodiacStringBuilding.append(" ");
        // For Each 1/4 Element Groups, begin moving through entries
       for(Map.Entry<String, ArrayList<String>> entry : elementalToZodiacMap.entrySet()){

           // For each Sign in This 1 Element's arraylist
           for(String sign : entry.getValue()) {

               if (zodiac.equals(sign)) {
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



    // TODO: Testing logic for "Aries" date range "03-31"  --> routes to "Aquarius" if statement ?
    public static void main(String[] args) {
        // For testing with Console print outputs

        String expectedOutPut = "Aries";

        String actualOutput= new DateCalculator().calculateZodiac(MonthDay.of(03,31));

        System.out.println("The assigned elemental was: " + actualOutput);
        System.out.println("The expected elemental for Aries was:" + expectedOutPut);



    }

}

