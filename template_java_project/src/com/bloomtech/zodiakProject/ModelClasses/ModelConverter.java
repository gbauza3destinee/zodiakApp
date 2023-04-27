package com.bloomtech.zodiakProject.ModelClasses;

public class ModelConverter {

    public UserModel toUserModel(User user){

        // TODO : Add in all .with methods for User fields.


        UserModel userModel = UserModel.Builder.builder().withPronouns(user.getPronouns())
                .withBirthdate(user.getBirthDate()).withId(user.getUserId()).withName(user.getUserName()).build();

        return userModel;

    }



    //DONE: Create builder in UserSignModel Class
    // DONE: Implement Logic for toUserSignModel Class
    public UserSignModel toUserSignModel(UserSign userSign){
      //  return UserSignModel.builder();

        UserSignModel userSignModel = UserSignModel.builder().withUserId().withBirthDate().withZodiacSign().w.build()
        userSign.getUserId();
        userSign.getElementalSign();
        userSign.getZodiacSign();




        return null;

    }

}
