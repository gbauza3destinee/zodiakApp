package com.bloomtech.zodiakProject.dynamoDBClasses.Entity;

public class Zodiac {

    public String elemental;
    public String description;
    public String sign;

    public Zodiac(){
        this.elemental = elemental;
        this.description = description;
        this.sign = sign;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
