package com.bloomtech.zodiakProject.activityClasses;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomtech.zodiakProject.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.Results.CreateUserResult;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.UserDao;
import com.bloomtech.zodiakProject.UserGeneratorService;

import javax.naming.Context;
import java.text.DateFormat;

public class CreateUserActivity implements RequestHandler <CreateUserRequest, CreateUserResult> {

    UserDao userDao;


    // DONE: Updated Logic to Assign new ID generator

    public CreateUserActivity(UserDao userDao) {

        this.userDao = userDao;
    }


    /**
     * Request Handler method that works with APi requests made by a user,
     * gathers 3 fields and saves to a User generated instance with a unique Id.
     * @param input - represents the incoming data provided by user
     * @param context - represents server side functions
     * @return result - results in a program saved valid instance of an id
     */
    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, Context context) {

        // Gather all incoming user data

        User thisUser = new User();
        String userId = UserGeneratorService.generateUserId();
        thisUser.setUserId(userId);

        String userName = input.getUserName();
        String userPronouns = input.getPronouns();
        DateFormat userBirthDate = input.getBirthdate();

        thisUser.setUserName(userName);
        thisUser.setBirthDate(userBirthDate.toString());
        thisUser.setPronouns(userPronouns);


        CreateUserResult result = CreateUserResult.builder().withbirthdate(userBirthDate)
                .withUserName(userName).withUserId(userId).withPronouns(userPronouns).build();

        return result;


    }
}
