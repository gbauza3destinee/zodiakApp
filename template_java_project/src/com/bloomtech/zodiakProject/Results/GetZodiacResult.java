package com.bloomtech.zodiakProject.Results;

import com.bloomtech.zodiakProject.Requests.GetZodiacRequest;
import com.bloomtech.zodiakProject.UserGeneratorService;

import java.time.LocalDate;

public class GetZodiacResult {


    private UserGeneratorService userGeneratorService;
    private String userId;
    private LocalDate birthdate;
    private String elementalSign;
    private String zodiacSign;

    public GetZodiacResult(GetZodiacResult.Builder builder) {


        this.userId = builder.userId;
        this.birthdate = builder.birthdate;
        this.elementalSign = builder.elementalSign;
        this.zodiacSign = builder.zodiacSign;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getBirthDate() {
        return birthdate;
    }

    public void setBirthDate(LocalDate userBirthDate) {
        this.birthdate = userBirthDate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getElementalSign() {
        return elementalSign;
    }

    public void setElementalSign(String userElementalSign) {
        this.elementalSign = userElementalSign;
    }

    public static GetZodiacResult.Builder builder() {
        return new GetZodiacResult.Builder();
    }

    public static final class Builder {

        private String userId;
        private LocalDate birthdate;
        private String elementalSign;
        private String zodiacSign;



        public GetZodiacResult.Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
            return this;
        }

        public GetZodiacResult.Builder withUserBirthDateString( LocalDate userBirthDate) {
            this.birthdate = userBirthDate;
            return this;
        }


        public GetZodiacResult.Builder withElementalSign(String userElementalSign) {
            this.elementalSign = userElementalSign;
            return this;
        }


        public GetZodiacResult.Builder withZodiacSign(String userZodiacSign) {
            this.zodiacSign = userZodiacSign;
            return this;
        }



        public Builder() {
        }


        public GetZodiacResult build() {
            return new GetZodiacResult(this);


        }

    }



}
