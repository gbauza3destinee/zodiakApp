package com.bloomtech.zodiakProject.dynamoDBClasses;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses.User;
import dagger.Component;

import javax.inject.Inject;

@Component
public class UserDao {



    private DynamoDBMapper dynamoDbMapper;




    /**
     * Instantiates a User object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the playlists table
     */
    @Inject
    public UserDao(DynamoDBMapper dynamoDbMapper){
        //AmazonDynamoDB dynamoDBClient = DynamoDbClientProvider.getDynamoDBClient();
        this.dynamoDbMapper = dynamoDbMapper;

        }

        public UserDao(){
        }






    public User getUser(String userId){
        User thisUser =this.dynamoDbMapper.load(User.class, userId);

        if (thisUser == null){
            throw new NullPointerException("Could not find playlist with id " + userId);
        }
        return thisUser;
    }


    /**
     * A method that saves a new User instance in the program, with their found Elemental, Zodiac and User data found
     * @param user retrieved by getUser() a method available across the program.
     */

    public void saveUser(User user){


        dynamoDbMapper.save(user);

        dynamoDbMapper.save(user.getElemental());
        dynamoDbMapper.save(user.getZodiac());
        dynamoDbMapper.save(user.getPronouns());



    }






}









