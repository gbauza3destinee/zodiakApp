package com.bloomtech.zodiakProject;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomtech.zodiakProject.ModelClasses.User;

import javax.inject.Inject;

public class UserDao {
    private final DynamoDBMapper dynamoDbMapper;



    // TODO: 4/27 When dealing with this class, we want to pass around a User Model or User(db tags) class ?

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









