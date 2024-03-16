package com.bloomtech.zodiakProject.dynamoDBClasses.Entity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "zodiac")
public class Zodiac {

    public String name;
    public String elemental;
    public String description;

    public String startDate;
    public String endDate;

    public Zodiac(){
        this.elemental = elemental;
        this.description = description;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getElemental() {
        return elemental;
    }

    public void setElemental(String elemental) {
        this.elemental = elemental;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBHashKey
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
