package com.bloomtech.zodiakProject;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.ModelClasses.UserModel;
import com.bloomtech.zodiakProject.ModelClasses.UserSignModel;
import javax.inject.Inject;

public class UserDao {
    private final DynamoDBMapper dynamoDbMapper;
    private UserModel userModel;




    @Inject
    public UserDao(DynamoDBMapper dynamoDbMapper){
        //AmazonDynamoDB dynamoDBClient = DynamoDbClientProvider.getDynamoDBClient();
        this.dynamoDbMapper = dynamoDbMapper;


        }



    //TODO: NEXT- Implement Service Util class that generates real ids, so that this variable is not carrying null.


    public User getUser(String userId){



        User thisUser = dynamoDbMapper.load(User.class, userId);

        //UserSignModel


        return thisUser;
    }


    // TODO: Check syntax here for saving.
    public void saveUser(User user){

        String userId = user.getUserId();
        User saveThisUser = dynamoDbMapper.save(User.class, userId);

    }


    // Loading Instantiation : AmazonDynamoDB dynamoDBClient = DynamoDbClientProvider.getDynamoDBClient();




}









