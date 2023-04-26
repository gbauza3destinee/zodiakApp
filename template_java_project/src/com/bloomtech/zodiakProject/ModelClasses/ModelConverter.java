package com.bloomtech.zodiakProject.ModelClasses;

public class ModelConverter {

    public UserModel toUserModel(User user){

        // TODO : Add in all .with methods for User fields.
        return UserModel.builder();
    }



    //TODO: Create builder for UserSign Model Class
    public UserSignModel toUserSignModel(UserSign userSign){
        return UserSignModel.builder();
    }

}
