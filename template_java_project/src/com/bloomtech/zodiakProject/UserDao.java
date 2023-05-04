package com.bloomtech.zodiakProject;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.ModelClasses.UserModel;

@Repository
public class UserDao {



    private final DynamoDBMapper dynamoDbMapper;
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

        String userId = user.getUserId();
        User saveThisUser = dynamoDbMapper.save(User.class, userId);

    }


    // Loading Instantiation : AmazonDynamoDB dynamoDBClient = DynamoDbClientProvider.getDynamoDBClient();




}









