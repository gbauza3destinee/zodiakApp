package com.bloomtech.zodiakProject.activityClasses;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomtech.zodiakProject.ModelClasses.Requests.CreateUserRequest;
import com.bloomtech.zodiakProject.ModelClasses.Results.CreateUserResult;
import com.bloomtech.zodiakProject.ModelClasses.User;
import com.bloomtech.zodiakProject.UserDao;

import java.text.DateFormat;

public class CreateUserEntryActivity implements RequestHandler<CreateUserRequest, CreateUserResult> {

    UserDao userDao;


    public CreateUserEntryActivity(UserDao userDao) {

    }


    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, Context context) {

        // Gather all incoming user data
        String userId = input.getUserId();
        String userName = input.getUserName();
        String userPronouns = input.getPronouns();
        DateFormat userBirthDate = input.getBirthdate();


        User user = new User();
        user.setUserId();
        user.setUserName(userName);
        user.setBirthDate(userBirthDate.toString());
        user.setPronouns(userPronouns);


        CreateUserResult result = CreateUserResult.builder().withbirthdate(userBirthDate)
                .withUserName(userName).withUserId(userId).withPronouns(userPronouns).build();

        return result;


    }
}
