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

        // 1 -  JANUARY Month Zodicas


        // ********************************************  1 Capricorn ****************************************************//
        // Capricorn : 1-01 - 1-19


        Zodiac capricornSecondHalf = new Zodiac();
        String capricorn = "Capricorn"; // fetch zodiac object where name is

        // Load by name
        Zodiac capricornDb = dynamoDBMapper.load(Zodiac.class, capricorn);
        capricornSecondHalf.setDescription(capricornDb.getDescription());
        capricornSecondHalf.setElemental(capricornDb.getElemental());
        capricornSecondHalf.setEndDate(capricornDb.endDate);
        capricornSecondHalf.setStartDate(capricornDb.startDate);


        // ********************************************  1 JANUARY ****************************************************//

        MonthlyZodiacModel janZodiac1 = new MonthlyZodiacModel(1,19 , 1, capricornSecondHalf);
        ArrayList<MonthlyZodiacModel> janZodiacs = new ArrayList<>();
        janZodiacs.add(janZodiac1);
        monthMap.put(janZodiac1.month, janZodiacs);


        // Retrieve ALL Zodiac items from DB with SCAN method
//        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
//        PaginatedScanList <Zodiac> zodiacList = dynamoDBMapper.scan(Zodiac.class, scanExpression);
//
//
//        // Load the Hashmap
//        for( Zodiac thisZodiac : zodiacList){
//                String startDate = thisZodiac.getStartDate();
//                String[] monthAndDay = startDate.split("-");
//                int month = Integer.valueOf(monthAndDay[0]);
//                // Add month to map
//                ArrayList<MonthlyZodiacModel> allZodiacsFromMonth = new ArrayList<>();
//                MonthlyZodiacModel monthZodiac = new MonthlyZodiacModel();
//                allZodiacsFromMonth.add(monthZodiac);
//                monthMap.put(month, allZodiacsFromMonth);
//        }



        // ******************************************** 1 Aquarius ****************************************************//


        // Aquarius : 01 - 20 - 01-31
        Zodiac aquariusFirstHalf = new Zodiac();
        String aquarius = "Aquarius";
        Zodiac aquariusDb = dynamoDBMapper.load(Zodiac.class, aquarius);
        MonthlyZodiacModel januaryZodiac2 = new MonthlyZodiacModel(20, 31,1, aquariusDb);
        aquariusFirstHalf.setElemental(aquariusDb.getElemental());
        aquariusFirstHalf.setDescription(aquariusDb.getDescription());
        aquariusFirstHalf.setStartDate(aquariusDb.startDate);
        aquariusFirstHalf.setEndDate(aquariusDb.endDate);
        // *** Place in hashmap
        janZodiacs.add(januaryZodiac2);
        monthMap.put(janZodiac1.month, janZodiacs);
//
//
//

        // ********************************************  2 FEBRUARY  ****************************************************//

        //    Aquarius 2-1 - 18

        Zodiac aquariusSecondHalf = new Zodiac();
        MonthlyZodiacModel febZodiac1 = new MonthlyZodiacModel(1, 18, 2, aquariusSecondHalf);
        aquariusSecondHalf.setElemental(aquariusDb.getElemental());
        aquariusSecondHalf.setDescription(aquariusDb.getDescription());
        aquariusSecondHalf.setStartDate(aquariusDb.startDate);
        aquariusSecondHalf.setEndDate(aquariusDb.endDate);
//        // ******************************************** 2- Pisces ****************************************************//

        // Pisces 2-19 - 29

        Zodiac piscesFirstHalf = new Zodiac();
        String pisces = "pisces";
        Zodiac piscesDb = dynamoDBMapper.load(Zodiac.class, pisces);
        MonthlyZodiacModel febZodiac2 = new MonthlyZodiacModel(19, 29, 2, piscesFirstHalf);
        piscesFirstHalf.setName(piscesDb.getName());
        piscesFirstHalf.setElemental(piscesDb.getElemental());
        piscesFirstHalf.setDescription(piscesDb.getDescription());
        piscesFirstHalf.setStartDate(piscesDb.getStartDate());
        piscesFirstHalf.setEndDate(piscesDb.getEndDate());

//        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> febZodiacs = new ArrayList<>();
        febZodiacs.add(febZodiac1);
        febZodiacs.add(febZodiac2);
        monthMap.put(febZodiac1.month, febZodiacs);

        // ********************************************  3 March  ****************************************************//


//        // ******************************************** Pisces ****************************************************//

          // Pisces 03 01- 20

        Zodiac piscesSecondHalf = new Zodiac();
        MonthlyZodiacModel marZodiac1 = new MonthlyZodiacModel(1,20,03,piscesSecondHalf);
        piscesSecondHalf.setName(piscesDb.getName());
        piscesSecondHalf.setElemental(piscesDb.getElemental());
        piscesSecondHalf.setDescription(piscesDb.getDescription());
        piscesSecondHalf.setStartDate(piscesDb.getStartDate());
        piscesSecondHalf.setEndDate(piscesDb.getEndDate());

        // ******************************************** Aries ****************************************************//

        // Aries 03 21 - 31

        String aries = "Aries";
        Zodiac ariesDb = dynamoDBMapper.load(Zodiac.class, aries);
        Zodiac ariesFirstHalf = new Zodiac();
        ariesFirstHalf.setName(ariesDb.getName());
        ariesFirstHalf.setDescription(ariesDb.getDescription());
        ariesFirstHalf.setElemental(ariesDb.getElemental());
        ariesFirstHalf.setStartDate(ariesDb.getStartDate());
        ariesFirstHalf.setEndDate(ariesDb.getEndDate());

        MonthlyZodiacModel marZodiac2 = new MonthlyZodiacModel(21,31, 03, ariesFirstHalf);
//
//        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> marZodiacs = new ArrayList<>();
        marZodiacs.add(marZodiac1);
        marZodiacs.add(marZodiac2);
        monthMap.put(3, marZodiacs);

        // ********************************************  4 APRIL  ****************************************************//


//        // ******************************************** Aries ****************************************************//

          // Aries 04 -01 , 04-19

        Zodiac ariesSecondHalf = new Zodiac();
        MonthlyZodiacModel aprilZodiac1 = new MonthlyZodiacModel(1,19,04,ariesSecondHalf);

        ariesSecondHalf.setName(ariesDb.getName());
        ariesSecondHalf.setDescription(ariesDb.getDescription());
        ariesSecondHalf.setElemental(ariesDb.getElemental());
        ariesSecondHalf.setStartDate(ariesDb.getStartDate());
        ariesSecondHalf.setEndDate(ariesDb.getEndDate());


        // ******************************************** Taurus ****************************************************//

        // Taurus 04-20 , 04-30
        String taurus = "Taurus";
        Zodiac taurusDb = dynamoDBMapper.load(Zodiac.class, taurus);
        Zodiac taurusFirstHalf = new Zodiac();
        taurusFirstHalf.setName(taurusDb.getName());
        taurusFirstHalf.setElemental(taurusDb.getElemental());
        taurusFirstHalf.setDescription(taurusDb.getDescription());
        taurusFirstHalf.setStartDate(taurusDb.getStartDate());
        taurusFirstHalf.setEndDate(taurusDb.getEndDate());

        MonthlyZodiacModel aprilZodiac2 = new MonthlyZodiacModel(20, 30, 4, taurusFirstHalf);

//        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> aprilZodiacs = new ArrayList<>();
        aprilZodiacs.add(aprilZodiac1);
        aprilZodiacs.add(aprilZodiac2);
        monthMap.put(aprilZodiac1.month, aprilZodiacs);


        // ********************************************  5 MAY  ****************************************************//

//        // ******************************************** Taurus ****************************************************//
          // Taurus 05 -01, 05,20

        Zodiac taurusSecondHalf = new Zodiac();
        taurusSecondHalf.setName(taurusDb.getName());
        taurusSecondHalf.setElemental(taurusDb.getElemental());
        taurusSecondHalf.setDescription(taurusDb.getDescription());
        taurusSecondHalf.setStartDate(taurusDb.getStartDate());
        taurusSecondHalf.setEndDate(taurusDb.getEndDate());
        MonthlyZodiacModel mayZodiac1 = new MonthlyZodiacModel(1,20,05,taurusSecondHalf);
//        // ******************************************** Gemini ****************************************************//

        //  Gemini 05 -21, 05-31

        Zodiac geminiFirstHalf = new Zodiac();
        String gemini = "Gemini";
        Zodiac geminiDb = dynamoDBMapper.load(Zodiac.class, gemini);
        geminiFirstHalf.setName(geminiDb.getName());
        geminiFirstHalf.setElemental(geminiDb.getElemental());
        geminiFirstHalf.setDescription(geminiDb.getDescription());
        geminiFirstHalf.setStartDate(geminiDb.getStartDate());
        geminiFirstHalf.setEndDate(geminiDb.getEndDate());

        MonthlyZodiacModel mayZodiac2 = new MonthlyZodiacModel(21, 31, 5, geminiFirstHalf);

//        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> mayZodiacs = new ArrayList<>();
        mayZodiacs.add(mayZodiac1);
        mayZodiacs.add(mayZodiac2);
        monthMap.put(mayZodiac1.month, mayZodiacs);

        // ********************************************  6 JUNE  ****************************************************//

        // ******************************************** Gemini ****************************************************//


        // Gemini 06 - 01, 06-20
       // Cancer 06-21, 06-30

        Zodiac geminiSecondHalf = new Zodiac();
        geminiSecondHalf.setName(geminiDb.getName());
        geminiSecondHalf.setElemental(geminiDb.getElemental());
        geminiSecondHalf.setDescription(geminiDb.getDescription());
        geminiSecondHalf.setStartDate(geminiDb.getStartDate());
        geminiSecondHalf.setEndDate(geminiDb.getEndDate());
        MonthlyZodiacModel juneZodiac1 = new MonthlyZodiacModel(1,20,6, geminiSecondHalf);

//        // ******************************************** Cancer ****************************************************//

        Zodiac cancerFirstHalf = new Zodiac();
        String cancer = "Cancer";
        Zodiac cancerDb = dynamoDBMapper.load(Zodiac.class, cancer);
        cancerFirstHalf.setName(cancerDb.getName());
        cancerFirstHalf.setElemental(cancerDb.getElemental());
        cancerFirstHalf.setDescription(cancerDb.getDescription());
        cancerFirstHalf.setStartDate(cancerDb.getStartDate());
        cancerFirstHalf.setEndDate(cancerDb.getEndDate());


        MonthlyZodiacModel juneZodiac2 = new MonthlyZodiacModel(21, 30, 6, cancerFirstHalf);

//        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> juneZodiacs = new ArrayList<>();
        juneZodiacs.add(juneZodiac1);
        juneZodiacs.add(juneZodiac2);
        monthMap.put(juneZodiac1.month, juneZodiacs);

        // ********************************************  7 JULY  ****************************************************//


//        // ******************************************** Cancer ****************************************************//
         // Cancer 07-01 - 07-22

        Zodiac cancerSecondHalf = new Zodiac();
        cancerSecondHalf.setName(cancerDb.getName());
        cancerSecondHalf.setElemental(cancerDb.getElemental());
        cancerSecondHalf.setDescription(cancerDb.getDescription());
        cancerSecondHalf.setStartDate(cancerDb.getStartDate());
        cancerSecondHalf.setEndDate(cancerDb.getEndDate());
        MonthlyZodiacModel julyZodiac1 = new MonthlyZodiacModel(1,22,7,cancerSecondHalf);

//        // ******************************************** Leo ****************************************************//
        // Leo 07-23, 07-31

        Zodiac leoFirstHalf = new Zodiac();
        String leo = "Leo";
        Zodiac leoDb = dynamoDBMapper.load(Zodiac.class, leo);
        leoFirstHalf.setName(leoDb.getName());
        leoFirstHalf.setDescription(leoDb.getDescription());
        leoFirstHalf.setElemental(leoDb.getElemental());
        leoFirstHalf.setStartDate(leoDb.getStartDate());
        leoFirstHalf.setEndDate(leoDb.getEndDate());

        MonthlyZodiacModel julyZodiac2 = new MonthlyZodiacModel(23,31, 7, leoFirstHalf);

//        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> julyZodiacs = new ArrayList<>();
        julyZodiacs.add(julyZodiac1);
        julyZodiacs.add(julyZodiac2);
        monthMap.put(julyZodiac1.month, julyZodiacs);


        // ********************************************  8 AUGUST  ****************************************************//

//        // ******************************************** Leo ****************************************************//

        // Leo 08-01, 08-22

        Zodiac leoSecondHalf = new Zodiac();
        leoSecondHalf.setName(leoDb.getName());
        leoSecondHalf.setDescription(leoDb.getDescription());
        leoSecondHalf.setElemental(leoDb.getElemental());
        leoSecondHalf.setStartDate(leoDb.getStartDate());
        leoSecondHalf.setEndDate(leoDb.getEndDate());
        MonthlyZodiacModel augZodiac1 = new MonthlyZodiacModel(1,22, 8, leoSecondHalf);

//        // ******************************************** Virgo ****************************************************//

        // Virgo 08-23, 08 -31

        Zodiac virgoFirstHalf = new Zodiac();
        String virgo = "Virgo";
        Zodiac virgoDb = dynamoDBMapper.load(Zodiac.class, virgo);
        virgoFirstHalf.setName(virgoDb.getName());
        virgoFirstHalf.setDescription(virgoDb.getDescription());
        virgoFirstHalf.setElemental(virgoDb.getElemental());
        virgoFirstHalf.setStartDate(virgoDb.getStartDate());
        virgoFirstHalf.setEndDate(virgoDb.getEndDate());


        MonthlyZodiacModel augZodiac2 = new MonthlyZodiacModel(23, 31, 8, virgoFirstHalf);

//        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> augustZodiacs = new ArrayList<>();
        augustZodiacs.add(augZodiac1);
        augustZodiacs.add(augZodiac2);
        monthMap.put(augZodiac1.month, augustZodiacs);

        // ********************************************  9 SEPTEMBER  ****************************************************//


//        // ******************************************** Virgo ****************************************************//

        // Virgo 09- 01 - 09-22

        Zodiac virgoSecondHalf = new Zodiac();
        virgoSecondHalf.setName(virgoDb.getName());
        virgoSecondHalf.setDescription(virgoDb.getDescription());
        virgoSecondHalf.setElemental(virgoDb.getElemental());
        virgoSecondHalf.setStartDate(virgoDb.getStartDate());
        virgoSecondHalf.setEndDate(virgoDb.getEndDate());
        MonthlyZodiacModel septZodiac1 = new MonthlyZodiacModel(1, 22, 9, virgoSecondHalf);

        // ******************************************** Libra ****************************************************//
        // Libra 09-23, 09-30

        Zodiac libraFirstHalf = new Zodiac();
        String libra = "Libra";
        Zodiac libraDb = dynamoDBMapper.load(Zodiac.class, libra);
        libraFirstHalf.setName(libraDb.getName());
        libraFirstHalf.setDescription(libraDb.getDescription());
        libraFirstHalf.setElemental(libraDb.getElemental());
        libraFirstHalf.setStartDate(libraDb.getStartDate());
        libraFirstHalf.setEndDate(libraDb.getEndDate());

        MonthlyZodiacModel septZodiac2 = new MonthlyZodiacModel(23, 30, 9, libraFirstHalf);

        ArrayList<MonthlyZodiacModel> septZodiacs = new ArrayList<>();
        septZodiacs.add(septZodiac1);
        septZodiacs.add(septZodiac2);
        monthMap.put(septZodiac1.month, septZodiacs);

        // ********************************************  10 OCTOBER  ****************************************************//


        // ******************************************** Libra ****************************************************//

        // Libra 10-01, 10-22
        Zodiac libraSecondHalf = new Zodiac();
        libraSecondHalf.setName(libraDb.getName());
        libraSecondHalf.setDescription(libraDb.getDescription());
        libraSecondHalf.setElemental(libraDb.getElemental());
        libraSecondHalf.setStartDate(libraDb.getStartDate());
        libraSecondHalf.setEndDate(libraDb.getEndDate());

        MonthlyZodiacModel octZodiac1 = new MonthlyZodiacModel(1, 22, 10, libraSecondHalf);

//        // ******************************************** Scorpio ****************************************************//

        // Scorpio 10-23, 10-31
        Zodiac scorpioFirstHalf = new Zodiac();
        String scorpio = "Scorpio";
        Zodiac scorpioDb = dynamoDBMapper.load(Zodiac.class, scorpio);
        scorpioFirstHalf.setName(scorpioDb.getName());
        scorpioFirstHalf.setElemental(scorpioDb.getElemental());
        scorpioFirstHalf.setDescription(scorpioDb.getDescription());
        scorpioFirstHalf.setStartDate(scorpioDb.getStartDate());
        scorpioFirstHalf.setEndDate(scorpioDb.getEndDate());

        MonthlyZodiacModel octZodiac2 = new MonthlyZodiacModel(23, 31, 10, scorpioFirstHalf);

        ArrayList<MonthlyZodiacModel> octZodiacs = new ArrayList<>();
        octZodiacs.add(octZodiac1);
        octZodiacs.add(octZodiac2);
        monthMap.put(octZodiac1.month, octZodiacs);


        // ********************************************  11 November  ****************************************************//


       // ******************************************** Scorpio ****************************************************//
        // Scorpio 11-01, 11-21

        Zodiac scorpioSecondHalf = new Zodiac();

        scorpioSecondHalf.setName(scorpioDb.getName());
        scorpioSecondHalf.setElemental(scorpioDb.getElemental());
        scorpioSecondHalf.setDescription(scorpioDb.getDescription());
        scorpioSecondHalf.setStartDate(scorpioDb.getStartDate());
        scorpioSecondHalf.setEndDate(scorpioDb.getEndDate());

        MonthlyZodiacModel novZodiac1 = new MonthlyZodiacModel(1, 21, 11, scorpioSecondHalf);

//        // ******************************************** Sagitarrius ****************************************************//
        // Sagitarrius 11-22. 11-31
        Zodiac sagFirstHalf = new Zodiac();
        String sagitarrius = "Sagitarrius";
        Zodiac sagDb = dynamoDBMapper.load(Zodiac.class, sagitarrius);
        sagFirstHalf.setName(sagDb.getName());
        sagFirstHalf.setElemental(sagDb.getElemental());
        sagFirstHalf.setDescription(sagDb.getDescription());
        sagFirstHalf.setStartDate(sagDb.getStartDate());
        sagFirstHalf.setEndDate(sagDb.getEndDate());

        MonthlyZodiacModel novZodiac2 = new MonthlyZodiacModel(22, 31, 11, sagFirstHalf);

        ArrayList<MonthlyZodiacModel> novZodiacs = new ArrayList<>();
        novZodiacs.add(novZodiac1);
        novZodiacs.add(novZodiac2);
        monthMap.put(novZodiac1.month, novZodiacs);

        // ********************************************  12 December  ****************************************************//

      // ******************************************** Sagitarrius ****************************************************//
        // Sagitarrius 12-01, 12-21
        Zodiac sagSecondHalf = new Zodiac();
        sagSecondHalf.setName(sagDb.getName());
        sagSecondHalf.setElemental(sagDb.getElemental());
        sagSecondHalf.setDescription(sagDb.getDescription());
        sagSecondHalf.setStartDate(sagDb.getStartDate());
        sagSecondHalf.setEndDate(sagDb.getEndDate());
        MonthlyZodiacModel decZodiac1 = new MonthlyZodiacModel(1, 21, 12, sagSecondHalf);

//        // ******************************************** Capricorn ****************************************************//
        // Capricorn 12-22, 12-31
        Zodiac capFirstHalf = new Zodiac();
        MonthlyZodiacModel decZodiac2 = new MonthlyZodiacModel(22, 31, 12, capFirstHalf);

        capFirstHalf.setDescription(capricornDb.getDescription());
        capFirstHalf.setElemental(capricornDb.getElemental());
        capFirstHalf.setStartDate(capricornDb.getStartDate());
        capFirstHalf.setEndDate(capricornDb.getEndDate());
        capFirstHalf.setName(capricornDb.getName());

        ArrayList<MonthlyZodiacModel> decZodiacs = new ArrayList<>();
        monthMap.put(decZodiac1.month, decZodiacs);

        // ********************************************  Print map  ****************************************************//


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

