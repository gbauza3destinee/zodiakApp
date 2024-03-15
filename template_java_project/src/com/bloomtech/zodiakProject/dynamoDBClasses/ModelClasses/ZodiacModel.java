package com.bloomtech.zodiakProject.dynamoDBClasses.ModelClasses;

import com.bloomtech.zodiakProject.dynamoDBClasses.Entity.Zodiac;

public class ZodiacModel {

        public String elemental;
        public String description;
        public String sign;

        public String startDate;
        public String endDate;

        public ZodiacModel() {

        }

        public ZodiacModel(String elemental, String description, String sign, String startDate,
        String endDate){
            this.elemental = elemental;
            this.description = description;
            this.sign = sign;
            this.startDate = startDate;
            this.endDate = endDate;
        }
        public ZodiacModel(Builder builder ){
            this.elemental = elemental;
            this.description = description;
            this.sign = sign;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public static final class Builder {

            private String elemental;
            private String description;
            private String sign;

            private String startDate;

            private String endDate;


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

            public ZodiacModel.Builder withStartDate(String startDate) {
                this.startDate = startDate;
                return this;
            }

            public ZodiacModel.Builder withEndDate(String endDate) {
                this.endDate = endDate;
                return this;
            }


            public ZodiacModel build() {
                return new ZodiacModel(this);
            }





        }



}
