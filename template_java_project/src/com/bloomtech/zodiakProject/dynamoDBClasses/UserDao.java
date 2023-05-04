package com.bloomtech.zodiakProject.dynamoDBClasses;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.User;
import dagger.Component;

import javax.inject.Inject;

@Component
public class UserDao {



    private DynamoDBMapper dynamoDbMapper;
    private User user;



    @Inject

    public UserDao(DynamoDBMapper dynamoDbMapper){
        //AmazonDynamoDB dynamoDBClient = DynamoDbClientProvider.getDynamoDBClient();
        this.dynamoDbMapper = dynamoDbMapper;

        }


        public UserDao(){
        }






    public User getUser(String userId){
        User thisUser = dynamoDbMapper.load(User.class, userId);

        return thisUser;
    }



    public void saveUser(User user){

        //TODO: Review other Dao

        String userId = user.getUserId();
        dynamoDbMapper.save(user);

    }


    // Loading Instantiation : AmazonDynamoDB dynamoDBClient = DynamoDbClientProvider.getDynamoDBClient();




}









