package com.bloomtech.zodiakProject.Results;
import com.bloomtech.zodiakProject.UserGeneratorService;


public class GetZodiacResult {

    //5.1 Take out all fields but userId

    @Autowire
    private UserGeneratorService userGeneratorService;
    private String userId;
    private String elementalSign;
    private String zodiacSign;

    public GetZodiacResult(GetZodiacResult.Builder builder) {

        this.userId = builder.userId;
        this.elementalSign = builder.elementalSign;
        this.zodiacSign = builder.zodiacSign;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

        private String userId;
        private String elementalSign;
        private String zodiacSign;



        public GetZodiacResult.Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
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
