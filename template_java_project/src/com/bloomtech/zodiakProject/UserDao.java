package com.bloomtech.zodiakProject;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.ModelClasses.UserModel;
import com.bloomtech.zodiakProject.ModelClasses.UserSign;
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


        // TODO: Should this DAO Class also save Elemental Sign + ZodiacSign, rather than have two separate DAO Classes?




    public User getUser(String userId){

       // UserGeneratorService.generateUserId();

        User thisUser = dynamoDbMapper.load(User.class, userId);

        //UserSignModel


        return thisUser;
    }


    // TODO: Check syntax here for saving under this User Table.
    public void saveUser(User user){

        String userId = user.getUserId();
        User saveThisUser = dynamoDbMapper.save(User.class, userId);

    }


    // Loading Instantiation : AmazonDynamoDB dynamoDBClient = DynamoDbClientProvider.getDynamoDBClient();




}









