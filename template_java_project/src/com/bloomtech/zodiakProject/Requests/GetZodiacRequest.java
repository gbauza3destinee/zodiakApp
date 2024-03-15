package com.bloomtech.zodiakProject.Requests;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Objects;

public class GetZodiacRequest {


    private String userName;
    private MonthDay birthdate;



    public GetZodiacRequest( String userId){
        this.userName = userName;
        this.birthdate = birthdate;


    }

    public GetZodiacRequest(){

    }

    public GetZodiacRequest(GetZodiacRequest.Builder builder){
        this.userName = userName;
        this.birthdate = birthdate;

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MonthDay getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(MonthDay birthdate) {
        this.birthdate = birthdate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetZodiacRequest that = (GetZodiacRequest) o;
        return userName.equals(that.userName) && birthdate.equals(that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash( userName, birthdate);
    }

    @Override
    public String toString() {
        return "GetZodiacRequest{" +
                ", userName='" + userName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }


    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{

        private String userName;
        private LocalDate birthdate;

        private Builder (){
        }


        private GetZodiacRequest.Builder withUserName(String userNameToUse){
            this.userName = userNameToUse;
            return this;
        }


        private GetZodiacRequest.Builder withBirthDate(LocalDate userBirthDateToUse){
            this.birthdate = userBirthDateToUse;
            return this;
        }

        public GetZodiacRequest build(){
            return new GetZodiacRequest(this);
        }
    }





}
