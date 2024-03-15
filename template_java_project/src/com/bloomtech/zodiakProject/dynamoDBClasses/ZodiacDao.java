package com.bloomtech.zodiakProject.dynamoDBClasses;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomtech.zodiakProject.dynamoDBClasses.Entity.Zodiac;

import java.awt.*;

public class ZodiacDao {


    private final DynamoDBMapper dynamoDBMapper;

    public ZodiacDao(DynamoDBMapper dynamoDBMapper){
        this.dynamoDBMapper = new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion(Regions.US_WEST_2)
                .build());

    }


    /// Load all Zodiac Signs



}
