package com.bloomtech.zodiakProject.ServiceProviders;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.IDynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.bloomtech.zodiakProject.dynamoDBClasses.Entity.Zodiac;
import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.MonthlyZodiacModel;

import java.sql.Array;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

// TODO: Clean up the logic in the loop iterating thru all 12 signs. I need to populate an arraylist but not 12

/**
 * * Program starts -> fetch from database  -> populate hashmap -> user request enters -> hashmap fetched
 *    Load list of zodiacs from database. Then populate MonthlyZodiac with description, etc.
 */
public final class DateCalculator {
    // add MonthlyZodiacModel model

    public static Map<Integer, ArrayList <MonthlyZodiacModel>>  monthMap = new HashMap<>();

    @Autowired
    private static DynamoDBMapper dynamoDBMapper;



    public DateCalculator() {
        monthMap = new HashMap<>();
        dynamoDBMapper = new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion(Regions.US_WEST_2)
                .build());

    }



    /**
     * From database,
     * Populates all zodiac signs by month into hashmap
     *
     */
    public static final void populateMonthlyZodiac() {

        // We won't call each sign by name because it is a pricy transaction.
        // 1 - Month
        // Capricorn : 1-01 - 1-19
        // TODO: Load all values from database and
        //

        // ******************************  INSTRUCTIONS        *******************************//
        Zodiac capricornSecondHalf = new Zodiac();
        String name = "Capricorn"; // fetch zodiac object where name is

        // Load by name
        Zodiac capricorn = dynamoDBMapper.load(Zodiac.class, name);
        capricornSecondHalf.setDescription(capricorn.getDescription());
        capricornSecondHalf.setElemental(capricorn.getElemental());
        capricornSecondHalf.setEndDate(capricorn.endDate);
        capricornSecondHalf.setStartDate(capricorn.startDate);

        // The SCAN method
        // take all of the zodiacs and
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        PaginatedScanList <Zodiac> zodiacList = dynamoDBMapper.scan(Zodiac.class, scanExpression);


        // For each zodiac sign, get the month
        // add it to map
        for( Zodiac thisZodiac : zodiacList){
                String startDate = thisZodiac.getStartDate();
                String[] monthAndDay = startDate.split("-");
                int month = Integer.valueOf(monthAndDay[0]);
                // Add month to map
                ArrayList<MonthlyZodiacModel> allZodiacsFromMonth = new ArrayList<>();
                MonthlyZodiacModel monthZodiac = new MonthlyZodiacModel();
                allZodiacsFromMonth.add(monthZodiac);
                monthMap.put(month, allZodiacsFromMonth);
        }


        // Search in list of zodiac for each zodiac sign
        // - find the description
        // - find the elemental


       String placeFirstDate =  capricornSecondHalf.getStartDate();
       String[] monthAndDay = placeFirstDate.split("-");
       int month =Integer.parseInt(monthAndDay[0]);

       ArrayList<MonthlyZodiacModel> janZodiacs = new ArrayList<>();
        MonthlyZodiacModel janZodiac1 = new MonthlyZodiacModel(1,19 , 01, capricornSecondHalf);
        janZodiacs.add(janZodiac1);
       monthMap.put(month, janZodiacs);




        // ********************************************  1- Capricorn ****************************************************//

        // MonthlyZodiacModel janZodiac1 = new MonthlyZodiacModel(1,19 , 01, capricornSecondHalf);
        // ******************************************** 1- Aquarius ****************************************************//
        // Aquarius : 01 - 20 - 01-31
        Zodiac aquariusFirstHalf = new Zodiac();
        MonthlyZodiacModel januaryZodiac2 = new MonthlyZodiacModel(20, 31,1, aquariusFirstHalf);

//        // *** Place in hashmap
        janZodiacs.add(januaryZodiac2);
        monthMap.put(1, janZodiacs);
//
//
//        // 2-
//        // Aquarius 2-1 - 18
//        // ******************************************** 2- Aquarius ****************************************************//
        Zodiac aquariusSecondHalf = new Zodiac();
        MonthlyZodiacModel febZodiac1 = new MonthlyZodiacModel(1, 18, 2, aquariusSecondHalf);
//        // Pisces 2-19 - 29
//        // ******************************************** 2- Pisces ****************************************************//
        Zodiac piscesFirstHalf = new Zodiac();
        MonthlyZodiacModel febZodiac2 = new MonthlyZodiacModel(19, 29, 2, piscesFirstHalf);

//        // *** Place in hashmap
//        ArrayList<MonthlyZodiacModel> febZodiacs = new ArrayList<>();
//        febZodiacs.add(febZodiac1);
//        febZodiacs.add(febZodiac2);
//        monthMap.put(2, febZodiacs);
//
//        // 3 -
//        // Pisces 03 01- 20
//        // Aries 03 21 - 31
//        // ******************************************** Pisces ****************************************************//
//
//        Zodiac piscesSecondHalf = new Zodiac();
//        MonthlyZodiacModel marZodiac1 = new MonthlyZodiacModel(1,20,03,piscesSecondHalf);
//
//        // ******************************************** Aries ****************************************************//
//
//        Zodiac ariesFirstHalf = new Zodiac();
//        MonthlyZodiacModel marZodiac2 = new MonthlyZodiacModel(21,31, 03, ariesFirstHalf);
//
//        // *** Place in hashmap
//        ArrayList<MonthlyZodiacModel> marZodiacs = new ArrayList<>();
//        marZodiacs.add(marZodiac1);
//        marZodiacs.add(marZodiac2);
//        monthMap.put(3, marZodiacs);
//
//        // 4 -
//        // Aries 04 -01 , 04-19
//        // Taurus 04-20 , 04-30
//        // ******************************************** Aries ****************************************************//
//
//        Zodiac ariesSecondHalf = new Zodiac();
//        MonthlyZodiacModel aprilZodiac1 = new MonthlyZodiacModel(1,19,04,ariesSecondHalf);
//
//        // ******************************************** Taurus ****************************************************//
//        Zodiac taurusFirstHalf = new Zodiac();
//        MonthlyZodiacModel aprilZodiac2 = new MonthlyZodiacModel(20, 30, 4, taurusFirstHalf);
//
//        // *** Place in hashmap
//        ArrayList<MonthlyZodiacModel> aprilZodiacs = new ArrayList<>();
//        aprilZodiacs.add(aprilZodiac1);
//        aprilZodiacs.add(aprilZodiac2);
//        monthMap.put(4, aprilZodiacs);
//
//        // 5-
//        // Taurus 05 -01, 05,20
//        // Gemini 05 -21, 05-31
//        // ******************************************** Taurus ****************************************************//
//        Zodiac taurusSecondHalf = new Zodiac();
//        MonthlyZodiacModel mayZodiac1 = new MonthlyZodiacModel(1,20,05,taurusSecondHalf);
//        // ******************************************** Gemini ****************************************************//
//
//        Zodiac geminiFirstHalf = new Zodiac();
//        MonthlyZodiacModel mayZodiac2 = new MonthlyZodiacModel(21, 31, 5, geminiFirstHalf);
//
//        // *** Place in hashmap
//        ArrayList<MonthlyZodiacModel> mayZodiacs = new ArrayList<>();
//        mayZodiacs.add(mayZodiac1);
//        mayZodiacs.add(mayZodiac2);
//        monthMap.put(5, mayZodiacs);
//
//
//        // 6-
//        // Gemini 06 - 01, 06-20
//        // Cancer 06-21, 06-30
//        // ******************************************** Gemini ****************************************************//
//
//        Zodiac geminiSecondHalf = new Zodiac();
//        MonthlyZodiacModel juneZodiac1 = new MonthlyZodiacModel(1,20,6, geminiSecondHalf);
//
//        // ******************************************** Cancer ****************************************************//
//
//        Zodiac cancerFirstHalf = new Zodiac();
//        MonthlyZodiacModel juneZodiac2 = new MonthlyZodiacModel(21, 30, 6, cancerFirstHalf);
//
//        // *** Place in hashmap
//        ArrayList<MonthlyZodiacModel> juneZodiacs = new ArrayList<>();
//        juneZodiacs.add(juneZodiac1);
//        juneZodiacs.add(juneZodiac2);
//        monthMap.put(6, juneZodiacs);
//
//
//        // 7-
//        // Cancer 07-01 - 07-22
//        // Leo 07-23, 07-31
//
//        // ******************************************** Cancer ****************************************************//
//
//        Zodiac cancerSecondHalf = new Zodiac();
//        MonthlyZodiacModel julyZodiac1 = new MonthlyZodiacModel(1,22,7,cancerSecondHalf);
//
//        // ******************************************** Leo ****************************************************//
//
//        Zodiac leoFirstHalf = new Zodiac();
//        MonthlyZodiacModel julyZodiac2 = new MonthlyZodiacModel(23,31, 7, leoFirstHalf);
//
//        // *** Place in hashmap
//        ArrayList<MonthlyZodiacModel> julyZodiacs = new ArrayList<>();
//        julyZodiacs.add(julyZodiac1);
//        julyZodiacs.add(julyZodiac2);
//        monthMap.put(7, julyZodiacs);
//
//        // 8 -
//        // Leo 08-01, 08-22
//        // Virgo 08-23, 08 -31
//        // ******************************************** Leo ****************************************************//
//
//        Zodiac leoSecondHalf = new Zodiac();
//        MonthlyZodiacModel augZodiac1 = new MonthlyZodiacModel(1,22, 8, leoSecondHalf);
//
//        // ******************************************** Virgo ****************************************************//
//
//        Zodiac virgoFirstHalf = new Zodiac();
//        MonthlyZodiacModel augZodiac2 = new MonthlyZodiacModel(23, 31, 8, virgoFirstHalf);
//
//        // *** Place in hashmap
//        ArrayList<MonthlyZodiacModel> augustZodiacs = new ArrayList<>();
//        augustZodiacs.add(augZodiac1);
//        augustZodiacs.add(augZodiac2);
//        monthMap.put(8, augustZodiacs);
//
//        // 9 -
//        // Virgo 09- 01 - 09-22
//        // Libra 09-23, 09-30
//        // ******************************************** Virgo ****************************************************//
//
//        Zodiac virgoSecondHalf = new Zodiac();
//        MonthlyZodiacModel septZodiac1 = new MonthlyZodiacModel(1, 22, 9, virgoSecondHalf);
//
//        // ******************************************** Libra ****************************************************//
//
//        Zodiac libraFirstHalf = new Zodiac();
//        MonthlyZodiacModel septZodiac2 = new MonthlyZodiacModel(23, 30, 9, libraFirstHalf);
//
//        ArrayList<MonthlyZodiacModel> septZodiacs = new ArrayList<>();
//        septZodiacs.add(septZodiac1);
//        septZodiacs.add(septZodiac2);
//        monthMap.put(9, septZodiacs);
//
//        //10
//        // Libra 10-01, 10-22
//        // Scorpio 10-23, 10-31
//
//        // ******************************************** Libra ****************************************************//
//
//        Zodiac libraSecondHalf = new Zodiac();
//        MonthlyZodiacModel octZodiac1 = new MonthlyZodiacModel(1, 22, 10, libraSecondHalf);
//
//        // ******************************************** Scorpio ****************************************************//
//
//        Zodiac scorpioFirstHalf = new Zodiac();
//        MonthlyZodiacModel octZodiac2 = new MonthlyZodiacModel(23, 31, 10, scorpioFirstHalf);
//
//        ArrayList<MonthlyZodiacModel> octZodiacs = new ArrayList<>();
//        octZodiacs.add(octZodiac1);
//        octZodiacs.add(octZodiac2);
//        monthMap.put(10, octZodiacs);
//
//
//        //11
//        // Scorpio 11-01, 11-21
//        // Sagitarrius 11-22. 11-31
//        // ******************************************** Scorpio ****************************************************//
//
//
//        Zodiac scorpioSecondHalf = new Zodiac();
//        MonthlyZodiacModel novZodiac1 = new MonthlyZodiacModel(1, 21, 11, scorpioSecondHalf);
//
//        // ******************************************** Sagitarrius ****************************************************//
//
//        Zodiac sagFirstHalf = new Zodiac();
//        MonthlyZodiacModel novZodiac2 = new MonthlyZodiacModel(22, 31, 11, sagFirstHalf);
//
//        ArrayList<MonthlyZodiacModel> novZodiacs = new ArrayList<>();
//        novZodiacs.add(novZodiac1);
//        novZodiacs.add(novZodiac2);
//
//        monthMap.put(11, novZodiacs);
//
//
//        // 12
//        // Sagitarrius 12-01, 12-21
//        // Capricorn 12-22, 12-31
//        // ******************************************** Sagitarrius ****************************************************//
//        Zodiac sagSecondHalf = new Zodiac();
//        MonthlyZodiacModel decZodiac1 = new MonthlyZodiacModel(1, 21, 12, sagSecondHalf);
//
//        // ******************************************** Capricorn ****************************************************//
//        Zodiac capFirstHalf = new Zodiac();
//        MonthlyZodiacModel decZodiac2 = new MonthlyZodiacModel(22, 31, 12, capFirstHalf);
//        ArrayList<MonthlyZodiacModel> decZodiacs = new ArrayList<>();
//        monthMap.put(12, decZodiacs);



        System.out.println(monthMap);
        /**
         * Aries (03 21 – 04 19)
         * Taurus (04 20 – 05 20)
         * Gemini (05 21 – 06 20)
         * Cancer (06 21 – 07 22)
         * Leo (07 23 – 08 22)
         * Virgo (08 23 – 09 22)
         * Libra (09 23 – 10 22)
         * Scorpio (10 23 – 11 21)
         * Sagittarius (11 22 – 12 21)
         * Capricorn (12 22 – 01 19)
         * Aquarius (01 20 – 02 18)
         * Pisces (02 19 – 03 20)
         */


    }


    /**
     * Program starts -> fetch from database  -> populate hashmap -> user request enters -> hashmap fetched
     */

    /***
     * Takes in a User's Month value and User's Day value
     * Matches the correct zodiac sign using the monthmap
     * returns a zodiac object
     * @param
     */

    public static Zodiac findZodiacSign(int month, int day){

        // 1. Check for entries that start with user's month

        // 2. Iterate through list of zodiac signs found

        // 3. Compare the day value
    return null;
    }





    // TODO: Testing logic for "Aries" date range "03-31"  --> routes to "Aquarius" if statement ?
    public static void main(String[] args) {
        // For testing with Console print outputs

        populateMonthlyZodiac();

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();





    }

}

