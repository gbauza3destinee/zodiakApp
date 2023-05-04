package com.bloomtech.zodiakProject.ModelClasses;

import java.time.LocalDate;


@Service
public class ModelConverter {


    // DONE: Implement Logic for Both Model Class
    public UserModel toUserModel(User user){

        UserModel userModel = UserModel.Builder.builder().withPronouns(user.getPronouns())
                .withBirthdate(LocalDate.parse(user.getBirthDate())).withUserId(user.getUserId()).withName(user.getUserName()).build();

        return userModel;

    }


}
