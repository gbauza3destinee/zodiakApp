package com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses;

import com.bloomtech.zodiakProject.dynamoDBClasses.Entity.Zodiac;


// API side object - what the application is using
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

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Zodiac getZodiac() {
        return zodiac;
    }

    public void setZodiac(Zodiac zodiac) {
        this.zodiac = zodiac;
    }
}



