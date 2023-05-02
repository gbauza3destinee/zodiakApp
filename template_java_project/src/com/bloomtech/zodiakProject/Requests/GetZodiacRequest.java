package com.bloomtech.zodiakProject.Requests;

import java.time.LocalDate;
import java.util.Objects;

public class GetZodiacRequest {

    //5.1 deleted all fields but userId.
    private String userId;


    public GetZodiacRequest( String userId){
        this.userId = userId;

    }

    public GetZodiacRequest(){

    }

    public GetZodiacRequest(GetZodiacRequest.Builder builder){
        this.userId = userId;

    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetZodiacRequest that = (GetZodiacRequest) o;
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "GetZodiacRequest{" +
                "userId='" + userId + '\'' +
                '}';
    }

    public static GetZodiacRequest.Builder builder(){
        return new GetZodiacRequest.Builder();
    }


    // TODO: Update fields to just add userId.

    // -

    public static final class Builder{

        private String userId;


        private Builder (){
        }


        private GetZodiacRequest.Builder withUserId(String userId){
            this.userId = userId;
            return this;
        }


        public GetZodiacRequest build(){
            return new GetZodiacRequest(this);
        }
    }





}
