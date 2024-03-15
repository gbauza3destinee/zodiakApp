package com.bloomtech.zodiakProject.ServiceProviders;
import com.bloomtech.zodiakProject.dynamoDBClasses.Entity.Zodiac;
import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.MonthlyZodiacModel;

import java.util.*;


// In this class,
// I receive a user input birthdate
// then I match it up with the right zodiac sign

// See if the map works
// Populate all the other signs into the map
// Draft a database design for Zodiac and MonthlyZodiacModel

// Delete all annotations and start with Spring Framework
//


public final class DateCalculator {
    // add MonthlyZodiacModel model

    public static Map<Integer, ArrayList <MonthlyZodiacModel>>  monthMap = new HashMap<>();


    public DateCalculator() {
        monthMap = new HashMap<>();
    }


    // TODO:
    // - Hardcode all zodiac signs by month into map
    // - Fill in the zodiac object's attributes
    // - MonthlyZodiacModel getter setter/ builder.
    public static final void loadHashMapUtils() {

        // 1 - Month
        // Capricorn : 1-01 - 1-19
        // ******************************************** Capricorn ****************************************************//
        Zodiac capricornSecondHalf = new Zodiac();
        capricornSecondHalf.setDescription("Ruled by Saturn, Capricorns are ambitious and determined initiators. If commanding a room with their authoritative presence alone isn’t Capricorn’s biggest strength, their self-discipline just might be. " +
                "They comfortably and successfully know how to delegate to others and with the vision to lead.\n");
        capricornSecondHalf.setElemental("Earth");
        capricornSecondHalf.setSign("Capricorn");

        MonthlyZodiacModel janZodiac1 = new MonthlyZodiacModel(1,19 , 01, capricornSecondHalf);
        // ******************************************** Aquarius ****************************************************//
        // Aquarius : 01 - 20 - 01-31
        Zodiac aquariusFirstHalf = new Zodiac();
        aquariusFirstHalf.setSign("Aquarius");
        aquariusFirstHalf.setElemental("Air");
        aquariusFirstHalf.setDescription("Independent and enigmatical, Aquarians are unique. There is no one quite like an Aquarius, and because each is so incredibly individual, it can be tough to describe them as a group. Aquarians don't like labels, and may shy away from any adjective—even the good ones you might bestow upon them. Aquarians believe in the nature of change and evolution");
        MonthlyZodiacModel januaryZodiac2 = new MonthlyZodiacModel(20, 31,1, aquariusFirstHalf);

        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> janZodiacs = new ArrayList<>();
        janZodiacs.add(janZodiac1);
        janZodiacs.add(januaryZodiac2);
        monthMap.put(1, janZodiacs);


        // 2-
        // Aquarius 2-1 - 18
        // ******************************************** Aquarius ****************************************************//
        Zodiac aquariusSecondHalf = new Zodiac();
        aquariusSecondHalf.setSign("Aquarius");
        aquariusSecondHalf.setElemental("Air");
        aquariusSecondHalf.setDescription("Independent and enigmatical, Aquarians are unique. There is no one quite like an Aquarius, and because each is so incredibly individual, it can be tough to describe them as a group. Aquarians don't like labels, and may shy away from any adjective—even the good ones you might bestow upon them. Aquarians believe in the nature of change and evolution");

        MonthlyZodiacModel febZodiac1 = new MonthlyZodiacModel(1, 18, 2, aquariusSecondHalf);
        // Pisces 2-19 - 29
        // ******************************************** Pisces ****************************************************//
        Zodiac piscesFirstHalf = new Zodiac();
        piscesFirstHalf.setElemental("Water");
        piscesFirstHalf.setSign("Pisces");
        piscesFirstHalf.setDescription("Pisces is the sign of imagination, art and empathy. Pisces are the last sign of the zodiac, an old soul with mystical powers should they choose to develop them. Pisces is the dreamer and healer of the horoscope family. A mutable water sign, Pisces energy awakens compassion, imagination and artistry, dissolving the boundaries that divide us.");

        MonthlyZodiacModel febZodiac2 = new MonthlyZodiacModel(19, 29, 2, piscesFirstHalf);

        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> febZodiacs = new ArrayList<>();
        febZodiacs.add(febZodiac1);
        febZodiacs.add(febZodiac2);
        monthMap.put(2, febZodiacs);

        // 3 -
        // Pisces 03 01- 20
        // Aries 03 21 - 31
        // ******************************************** Pisces ****************************************************//

        Zodiac piscesSecondHalf = new Zodiac();
        piscesSecondHalf.setElemental("Water");
        piscesSecondHalf.setSign("Pisces");
        piscesSecondHalf.setDescription("Pisces is the sign of imagination, art and empathy. Pisces are the last sign of the zodiac, an old soul with mystical powers should they choose to develop them. Pisces is the dreamer and healer of the horoscope family. A mutable water sign, Pisces energy awakens compassion, imagination and artistry, dissolving the boundaries that divide us.");

        MonthlyZodiacModel marZodiac1 = new MonthlyZodiacModel(1,20,03,piscesSecondHalf);

        // ******************************************** Aries ****************************************************//

        Zodiac ariesFirstHalf = new Zodiac();
        ariesFirstHalf.setDescription("Aries's masculine nature is forthright with vigor, a trait further amplified by its planetary ruler, Mars. Aries is known to be vivacious, enthusiastic, childish, and a bit selfish. Although this sign is impulsive and hotheaded, nobody can deny the\" +\n" +
                "                 quick-thinking and intense call-to-action innate in any Aries. Expressed as the Ram, Aries can be counted on to headbutt its way through anything!\\n\" +\n" +
                "                \"\\n\"");
        ariesFirstHalf.setSign("Aries");
        ariesFirstHalf.setElemental("Fire");
        MonthlyZodiacModel marZodiac2 = new MonthlyZodiacModel(21,31, 03, ariesFirstHalf);

        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> marZodiacs = new ArrayList<>();
        marZodiacs.add(marZodiac1);
        marZodiacs.add(marZodiac2);
        monthMap.put(3, marZodiacs);

        // 4 -
        // Aries 04 -01 , 04-19
        // Taurus 04-20 , 04-30
        // ******************************************** Aries ****************************************************//

        Zodiac ariesSecondHalf = new Zodiac();
        ariesSecondHalf.setDescription("\"Aries's masculine nature is forthright with vigor, a trait further amplified by its planetary ruler, Mars. Aries is known to be vivacious, enthusiastic, childish, and a bit selfish. Although this sign is impulsive and hotheaded, nobody can deny the\\\" +\\n\" +\n" +
                "                \"                 quick-thinking and intense call-to-action innate in any Aries. Expressed as the Ram, Aries can be counted on to headbutt its way through anything!\\\\n\\\" +\\n\" +\n" +
                "                \"                \\\"\\\\n\\\"\"");
        ariesSecondHalf.setSign("Aries");
        ariesSecondHalf.setElemental("Fire");
        MonthlyZodiacModel aprilZodiac1 = new MonthlyZodiacModel(1,19,04,ariesSecondHalf);

        // ******************************************** Taurus ****************************************************//
        Zodiac taurusFirstHalf = new Zodiac();
        taurusFirstHalf.setDescription("Smart, ambitious, and trustworthy, Taurus is the anchor of the Zodiac. Amazing friends, colleagues, and partners, Taureans value honesty above all else and are proud that their personal relationships tend to be drama free. Bulls get the reputation of being stubborn, but they're not always stuck in their ways");
        taurusFirstHalf.setSign("Taurus");
        taurusFirstHalf.setElemental("Earth");
        MonthlyZodiacModel aprilZodiac2 = new MonthlyZodiacModel(20, 30, 4, taurusFirstHalf);

        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> aprilZodiacs = new ArrayList<>();
        aprilZodiacs.add(aprilZodiac1);
        aprilZodiacs.add(aprilZodiac2);
        monthMap.put(4, aprilZodiacs);

        // 5-
        // Taurus 05 -01, 05,20
        // Gemini 05 -21, 05-31
        // ******************************************** Taurus ****************************************************//
        Zodiac taurusSecondHalf = new Zodiac();
        taurusSecondHalf.setDescription("Smart, ambitious, and trustworthy, Taurus is the anchor of the Zodiac. Amazing friends, colleagues, and partners, Taureans value honesty above all else and are proud that their personal relationships tend to be drama free. Bulls get the reputation of being stubborn, but they're not always stuck in their ways");
        taurusSecondHalf.setSign("Taurus");
        taurusSecondHalf.setElemental("Earth");


        MonthlyZodiacModel mayZodiac1 = new MonthlyZodiacModel(1,20,05,taurusSecondHalf);
        // ******************************************** Gemini ****************************************************//

        Zodiac geminiFirstHalf = new Zodiac();
        geminiFirstHalf.setDescription("Gemini is an air sign with a ton of superpowers, including multitasking, since they’re multifaceted and live outside of the box. Recognized as the sacred duality present in the universe, Gemini is an intellectual and versatile sign with an endless curiosity and a bright, quick-witted mind.");
        geminiFirstHalf.setSign("Gemini");
        geminiFirstHalf.setElemental("Air");
        MonthlyZodiacModel mayZodiac2 = new MonthlyZodiacModel(21, 31, 5, geminiFirstHalf);

        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> mayZodiacs = new ArrayList<>();
        mayZodiacs.add(mayZodiac1);
        mayZodiacs.add(mayZodiac2);
        monthMap.put(5, mayZodiacs);


        // 6-
        // Gemini 06 - 01, 06-20
        // Cancer 06-21, 06-30
        // ******************************************** Gemini ****************************************************//

        Zodiac geminiSecondHalf = new Zodiac();
        geminiSecondHalf.setDescription("Gemini is an air sign with a ton of superpowers, including multitasking, since they’re multifaceted and live outside of the box. Recognized as the sacred duality present in the universe, Gemini is an intellectual and versatile sign with an endless curiosity and a bright, quick-witted mind.");
        geminiSecondHalf.setSign("Gemini");
        geminiSecondHalf.setElemental("Air");
        MonthlyZodiacModel juneZodiac1 = new MonthlyZodiacModel(1,20,6, geminiSecondHalf);

        // ******************************************** Cancer ****************************************************//

        Zodiac cancerFirstHalf = new Zodiac();
        cancerFirstHalf.setDescription("One of Cancer’s strongest assets is their capacity for love—and the lengths they’ll go to for the people they care about. Intuitive and tenacious, this sign sticks to their roots and excels at getting what it wants to protect their family and loved ones,a Cancer sign will give you the world, as long as you give it right back.");
        cancerFirstHalf.setElemental("Water");
        cancerFirstHalf.setSign("Cancer");
        MonthlyZodiacModel juneZodiac2 = new MonthlyZodiacModel(21, 30, 6, cancerFirstHalf);

        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> juneZodiacs = new ArrayList<>();
        juneZodiacs.add(juneZodiac1);
        juneZodiacs.add(juneZodiac2);
        monthMap.put(6, juneZodiacs);


        // 7-
        // Cancer 07-01 - 07-22
        // Leo 07-23, 07-31

        // ******************************************** Cancer ****************************************************//

        Zodiac cancerSecondHalf = new Zodiac();
        cancerSecondHalf.setDescription("One of Cancer’s strongest assets is their capacity for love—and the lengths they’ll go to for the people they care about. Intuitive and tenacious, this sign sticks to their roots and excels at getting what it wants to protect their family and loved ones,a Cancer sign will give you the world, as long as you give it right back.");
        cancerSecondHalf.setElemental("Water");
        cancerSecondHalf.setSign("Cancer");
        MonthlyZodiacModel julyZodiac1 = new MonthlyZodiacModel(1,22,7,cancerSecondHalf);

        // ******************************************** Leo ****************************************************//

        Zodiac leoFirstHalf = new Zodiac();
        leoFirstHalf.setElemental("Fire");
        leoFirstHalf.setSign("Leo");
        leoFirstHalf.setDescription("This king of the jungle has a lust for life. Leo can be bold and fearless, allowing them to take risks and pursue their dreams with vigor. If you know a Leo, then you probably also know that making a good impression is their number one priority. This sign’s creativity and fiery magnetism puts them at the center stage of life.");
        MonthlyZodiacModel julyZodiac2 = new MonthlyZodiacModel(23,31, 7, leoFirstHalf);

        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> julyZodiacs = new ArrayList<>();
        julyZodiacs.add(julyZodiac1);
        julyZodiacs.add(julyZodiac2);
        monthMap.put(7, julyZodiacs);

        // 8 -
        // Leo 08-01, 08-22
        // Virgo 08-23, 08 -31
        // ******************************************** Leo ****************************************************//

        Zodiac leoSecondHalf = new Zodiac();
        leoSecondHalf.setElemental("Fire");
        leoSecondHalf.setSign("Leo");
        leoSecondHalf.setDescription("This king of the jungle has a lust for life. Leo can be bold and fearless, allowing them to take risks and pursue their dreams with vigor. If you know a Leo, then you probably also know that making a good impression is their number one priority. This sign’s creativity and fiery magnetism puts them at the center stage of life.");
        MonthlyZodiacModel augZodiac1 = new MonthlyZodiacModel(1,22, 8, leoSecondHalf);

        // ******************************************** Virgo ****************************************************//

        Zodiac virgoFirstHalf = new Zodiac();
        virgoFirstHalf.setDescription("Virgo is capable of taking on high levels of responsibility, which fills them with a great sense of duty in the world. They’re used to wearing multiple hats at the same time and are often under the impression that they’re the best person to do it all.");
        virgoFirstHalf.setSign("Virgo");
        virgoFirstHalf.setElemental("Earth");
        MonthlyZodiacModel augZodiac2 = new MonthlyZodiacModel(23, 31, 8, virgoFirstHalf);

        // *** Place in hashmap
        ArrayList<MonthlyZodiacModel> augustZodiacs = new ArrayList<>();
        augustZodiacs.add(augZodiac1);
        augustZodiacs.add(augZodiac2);
        monthMap.put(8, augustZodiacs);

        // 9 -
        // Virgo 09- 01 - 09-22
        // Libra 09-23, 09-30
        // ******************************************** Virgo ****************************************************//

        Zodiac virgoSecondHalf = new Zodiac();
        virgoSecondHalf.setDescription("Virgo is capable of taking on high levels of responsibility, which fills them with a great sense of duty in the world. They’re used to wearing multiple hats at the same time and are often under the impression that they’re the best person to do it all.");
        virgoSecondHalf.setSign("Virgo");
        virgoSecondHalf.setElemental("Earth");
        MonthlyZodiacModel septZodiac1 = new MonthlyZodiacModel(1, 22, 9, virgoSecondHalf);

        // ******************************************** Libra ****************************************************//

        Zodiac libraFirstHalf = new Zodiac();
        libraFirstHalf.setSign("Libra");
        libraFirstHalf.setElemental("Air");
        libraFirstHalf.setDescription("Libras are experts at keeping the peace (they are represented by the scales of justice, after all), but there’s nothing stronger than Libra’s congeniality. This sign seeks to be a source of joy for others. They’re basically the epitome of beauty, balance, harmony, and a sense of fair play");
        MonthlyZodiacModel septZodiac2 = new MonthlyZodiacModel(23, 30, 9, libraFirstHalf);

        ArrayList<MonthlyZodiacModel> septZodiacs = new ArrayList<>();
        septZodiacs.add(septZodiac1);
        septZodiacs.add(septZodiac2);
        monthMap.put(9, septZodiacs);

        //10
        // Libra 10-01, 10-22
        // Scorpio 10-23, 10-31

        // ******************************************** Libra ****************************************************//

        Zodiac libraSecondHalf = new Zodiac();
        libraSecondHalf.setSign("Libra");
        libraSecondHalf.setElemental("Air");
        libraSecondHalf.setDescription("Libras are experts at keeping the peace (they are represented by the scales of justice, after all), but there’s nothing stronger than Libra’s congeniality. This sign seeks to be a source of joy for others. They’re basically the epitome of beauty, balance, harmony, and a sense of fair play");
        MonthlyZodiacModel octZodiac1 = new MonthlyZodiacModel(1, 22, 10, libraSecondHalf);

        // ******************************************** Scorpio ****************************************************//

        Zodiac scorpioFirstHalf = new Zodiac();
        scorpioFirstHalf.setDescription("Scorpio knows how to trigger other people and push their buttons behind limits. Yet, they also love hard, so you can expect a Scorpio to fight till the end for the people they care about. As a fixed modality, they tend to be determined and stable, which also makes Scorpios super independent.");
        scorpioFirstHalf.setElemental("Water");
        scorpioFirstHalf.setSign("Scorpio");
        MonthlyZodiacModel octZodiac2 = new MonthlyZodiacModel(23, 31, 10, scorpioFirstHalf);

        ArrayList<MonthlyZodiacModel> octZodiacs = new ArrayList<>();
        octZodiacs.add(octZodiac1);
        octZodiacs.add(octZodiac2);
        monthMap.put(10, octZodiacs);


        //11
        // Scorpio 11-01, 11-21
        // Sagitarrius 11-22. 11-31
        // ******************************************** Scorpio ****************************************************//


        Zodiac scorpioSecondHalf = new Zodiac();
        scorpioSecondHalf.setDescription("Scorpio knows how to trigger other people and push their buttons behind limits. Yet, they also love hard, so you can expect a Scorpio to fight till the end for the people they care about. As a fixed modality, they tend to be determined and stable, which also makes Scorpios super independent.");
        scorpioSecondHalf.setElemental("Water");
        scorpioSecondHalf.setSign("Scorpio");

        MonthlyZodiacModel novZodiac1 = new MonthlyZodiacModel(1, 21, 11, scorpioSecondHalf);

        // ******************************************** Sagitarrius ****************************************************//

        Zodiac sagFirstHalf = new Zodiac();
        sagFirstHalf.setSign("Sagitarrius");
        sagFirstHalf.setElemental("Fire");
        sagFirstHalf.setDescription("These thrill-seekers rely on their luck and natural positivity to move them from one adventure to the next because they’re so focused on seeing the benefits of exploring new places and trying new experiences. They’re also truth-seekers, and the best way for them to get answers is to seek out tons of connections with others\n");
        MonthlyZodiacModel novZodiac2 = new MonthlyZodiacModel(22, 31, 11, sagFirstHalf);

        ArrayList<MonthlyZodiacModel> novZodiacs = new ArrayList<>();
        novZodiacs.add(novZodiac1);
        novZodiacs.add(novZodiac2);

        monthMap.put(11, novZodiacs);


        // 12
        // Sagitarrius 12-01, 12-21
        // Capricorn 12-22, 12-31
        // ******************************************** Sagitarrius ****************************************************//
        Zodiac sagSecondHalf = new Zodiac();
        sagSecondHalf.setSign("Sagitarrius");
        sagSecondHalf.setElemental("Fire");
        sagSecondHalf.setDescription("These thrill-seekers rely on their luck and natural positivity to move them from one adventure to the next because they’re so focused on seeing the benefits of exploring new places and trying new experiences. They’re also truth-seekers, and the best way for them to get answers is to seek out tons of connections with others\n");
        MonthlyZodiacModel decZodiac1 = new MonthlyZodiacModel(1, 21, 12, sagSecondHalf);

        // ******************************************** Capricorn ****************************************************//
        Zodiac capFirstHalf = new Zodiac();
        capFirstHalf.setDescription("Ruled by Saturn, Capricorns are ambitious and determined initiators. If commanding a room with their authoritative presence alone isn’t Capricorn’s biggest strength, their self-discipline just might be. " +
                "They comfortably and successfully know how to delegate to others and with the vision to lead.\n");
        capFirstHalf.setSign("Capricorn");
        capFirstHalf.setElemental("Earth");
        MonthlyZodiacModel decZodiac2 = new MonthlyZodiacModel(22, 31, 12, capFirstHalf);
        ArrayList<MonthlyZodiacModel> decZodiacs = new ArrayList<>();
        monthMap.put(12, decZodiacs);



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
     * Takes
     * @param args
     */

    // TODO: Testing logic for "Aries" date range "03-31"  --> routes to "Aquarius" if statement ?
    public static void main(String[] args) {
        // For testing with Console print outputs

        loadHashMapUtils();



    }

}

