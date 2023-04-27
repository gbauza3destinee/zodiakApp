package com.bloomtech.zodiakProject.ZodiacClasses;

import com.bloomtech.zodiakProject.ModelClasses.UserSign;
import com.bloomtech.zodiakProject.UserDao;

import java.util.HashMap;

public class Elemental implements Zodiac{

    private UserDao userDao;

    private HashMap < Elemental, Zodiac> elementalToZodiacHashMap = new HashMap<>();


    // TODO: Patch this up once I problemshoot with Swastik on how best to convert String to object

    public Elemental(UserSign userSign){
       Elemental elemental = userSign.getElementalSign();


    }




    @Override public void printUserZodiacInformation(){

    }


    @Override public void printUserElementalInformation(){

    }

}
