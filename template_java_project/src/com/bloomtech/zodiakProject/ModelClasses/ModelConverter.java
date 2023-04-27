package com.bloomtech.zodiakProject.ModelClasses;

public class ModelConverter {


    // DONE: Implement Logic for Both Model Class
    public UserModel toUserModel(User user){

        UserModel userModel = UserModel.Builder.builder().withPronouns(user.getPronouns())
                .withBirthdate(user.getBirthDate()).withId(user.getUserId()).withName(user.getUserName()).build();

        return userModel;

    }



    //DONE: Create builder in UserSignModel Class
    // DONE: Implement Logic for toUserSignModel Class
    public UserSignModel toUserSignModel(UserSign userSign){
      //  return UserSignModel.builder();

        UserSignModel userSignModel = UserSignModel.builder().withUserId(userSign.getUserId()).withBirthDate(userSign.getZodiacSign())
                .withZodiacSign(userSign.getZodiacSign()).withElementalSign( userSign.getElementalSign()).build();

        return userSignModel;

    }

}
