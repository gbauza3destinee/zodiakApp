package com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses;

import com.bloomtech.zodiakProject.dynamoDBClasses.Entity.Zodiac;

public class ZodiacModel {

        public String elemental;
        public String description;
        public String sign;

        public ZodiacModel() {

        }

        public ZodiacModel(String elemental, String description, String sign){
            this.elemental = elemental;
            this.description = description;
            this.sign = sign;
        }
        public ZodiacModel(Builder builder ){
            this.elemental = elemental;
            this.description = description;
            this.sign = sign;
        }

        public static final class Builder {

            private String elemental;
            private String description;
            private String sign;


            public static Builder builder() {
                return new ZodiacModel.Builder();
            }

            public ZodiacModel.Builder withElemental(String elemental) {
                this.elemental = elemental;
                return this;
            }

            public ZodiacModel.Builder withDescription(String description) {
                this.description = description;
                return this;
            }

            public ZodiacModel.Builder withSign(String sign) {
                this.sign = sign;
                return this;
            }



            public ZodiacModel build() {
                return new ZodiacModel(this);
            }





        }



}
