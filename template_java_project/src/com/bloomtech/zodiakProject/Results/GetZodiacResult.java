package com.bloomtech.zodiakProject.Results;

import com.bloomtech.zodiakProject.dynamoDBClasses.Entity.Zodiac;

public class GetZodiacResult {


    private Zodiac zodiacSign;

    public GetZodiacResult(GetZodiacResult.Builder builder) {

        this.zodiacSign = builder.zodiacSign;

    }



    public Zodiac getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(Zodiac userZodiacSign) {
        this.zodiacSign = userZodiacSign;
    }

    public static GetZodiacResult.Builder builder() {
        return new GetZodiacResult.Builder();
    }

    public static final class Builder {

        private Zodiac zodiacSign;

        public GetZodiacResult.Builder withZodiacSign(Zodiac userZodiacSign) {
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
