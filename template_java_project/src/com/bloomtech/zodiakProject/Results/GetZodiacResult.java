package com.bloomtech.zodiakProject.Results;

public class GetZodiacResult {


    private String zodiacSign;
    private String elementalSign;

    public GetZodiacResult(GetZodiacResult.Builder builder) {

        this.zodiacSign = builder.zodiacSign;

    }


    public String getElementalSign() {
        return elementalSign;
    }

    public void setElementalSign(String userElementalSign) {
        this.elementalSign = userElementalSign;
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(String userZodiacSign) {
        this.zodiacSign = userZodiacSign;
    }

    public static GetZodiacResult.Builder builder() {
        return new GetZodiacResult.Builder();
    }

    public static final class Builder {

        private String elementalSign;
        private String zodiacSign;



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
