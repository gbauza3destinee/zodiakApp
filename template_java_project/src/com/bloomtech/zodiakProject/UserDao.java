package com.bloomtech.zodiakProject;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomtech.zodiakProject.User;

import javax.inject.Inject;

public class UserDao {
    private final DynamoDBMapper dynamoDbMapper;


    // TODO : Do I not need my instantiation statement because i have imported the com file path?

    @Inject
    public UserDao(DynamoDBMapper dynamoDbMapper){
        //AmazonDynamoDB dynamoDBClient = DynamoDbClientProvider.getDynamoDBClient();
        this.dynamoDbMapper = dynamoDbMapper;


        }


    public User getUser(String userId){

        return null;
    }

    public void saveUser(User user){

    }


    // Loading Instantiation : AmazonDynamoDB dynamoDBClient = DynamoDbClientProvider.getDynamoDBClient();





}









