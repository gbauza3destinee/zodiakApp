package com.bloomtech.zodiakProject.Requests;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Objects;

public class GetZodiacRequest {


    private String userName;
    private MonthDay birthdate;
    private String pronouns;


    public GetZodiacRequest( String userId){
        this.userName = userName;
        this.birthdate = birthdate;
        this.pronouns = pronouns;

    }

    public GetZodiacRequest(){

    }

    public GetZodiacRequest(GetZodiacRequest.Builder builder){
        this.userName = userName;
        this.birthdate = birthdate;
        this.pronouns = pronouns;

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

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetZodiacRequest that = (GetZodiacRequest) o;
        return userName.equals(that.userName) && birthdate.equals(that.birthdate) && pronouns.equals(that.pronouns);
    }

    @Override
    public int hashCode() {
        return Objects.hash( userName, birthdate, pronouns);
    }

    @Override
    public String toString() {
        return "GetZodiacRequest{" +
                ", userName='" + userName + '\'' +
                ", birthdate=" + birthdate +
                ", pronouns='" + pronouns + '\'' +
                '}';
    }


    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{

        private String userName;
        private LocalDate birthdate;
        private String pronouns;

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
        private GetZodiacRequest.Builder withPronouns(String userPronouns){
            this.pronouns = userPronouns;
            return this;
        }

        public GetZodiacRequest build(){
            return new GetZodiacRequest(this);
        }
    }





}
