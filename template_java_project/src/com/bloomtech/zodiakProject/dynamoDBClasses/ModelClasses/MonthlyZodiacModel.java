package com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses;

import com.bloomtech.zodiakProject.dynamoDBClasses.Entity.Zodiac;


// API side object
// MZModel represents our API Gateway's API definition and is what the clients will interact with,
public class MonthlyZodiacModel {



    public int startDay;
    public int endDay;
    public int month;
    public Zodiac zodiac;

    public MonthlyZodiacModel(){

    }

    public MonthlyZodiacModel(int startDay, int endDay, int month, Zodiac zodiac){
        this.startDay = startDay;
        this.endDay = endDay;
        this.month = month;
        this.zodiac  = zodiac;
    }
    public MonthlyZodiacModel(Builder builder ){
        this.startDay = startDay;
        this.endDay = endDay;
        this.month = month;
        this.zodiac  = zodiac;
    }

    public static final class Builder {

        private int startDay;
        private int endDay;
        private int month;
        private Zodiac zodiac;


        public static MonthlyZodiacModel.Builder builder() {
            return new Builder();
        }



        public MonthlyZodiacModel.Builder withStartDay(int startDay) {
            this.startDay = startDay;
            return this;
        }

        public MonthlyZodiacModel.Builder withEndday(int endDay) {
            this.endDay = endDay;
            return this;
        }
        public MonthlyZodiacModel.Builder withMonth(int month) {
            this.month = month;
            return this;
        }

        public MonthlyZodiacModel.Builder withZodiac(Zodiac zodiacSign) {
            this.zodiac = zodiacSign;
            return this;
        }



        public MonthlyZodiacModel build() {
            return new MonthlyZodiacModel(this);
        }
    }



}
