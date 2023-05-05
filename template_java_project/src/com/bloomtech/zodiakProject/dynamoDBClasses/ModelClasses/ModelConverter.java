package com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses;

import java.beans.BeanProperty;
import java.beans.JavaBean;
import java.time.LocalDate;


public class ModelConverter {


    // DONE: Implement Logic for Both Model Class
    public UserModel toUserModel(User user){

        UserModel userModel = UserModel.Builder.builder().withPronouns(user.getPronouns())
                .withBirthdate(LocalDate.parse(user.getBirthDate())).withUserId(user.getUserId()).withName(user.getUserName()).build();

        return userModel;

    }


}
