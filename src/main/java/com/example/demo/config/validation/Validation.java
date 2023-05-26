package com.example.demo.config.validation;

public class Validation {
    public static boolean checkPhone(String phone){
        boolean firstNum = false;
        boolean checkNum = false;
        boolean len = false;
        final int PHONE_LEN = 11;
        char[] num = phone.toCharArray();

        String firstNumString = "010";

        for(int i=0; i<num.length; ++i){
            num[0] = '0';
            num[1] = '1';
            num[2] = '0';

            firstNum = true;
        }

        for(int i=0; i<phone.length(); ++i){
            char ch = phone.charAt(i);
            if(ch >= '0' && ch <= '9'){
                checkNum = true;
            }
        }

        if(phone.length() == PHONE_LEN){
            len = true;
        }

        if(firstNum && checkNum && len){
            return true;
        }else{
            return false;
        }
    }


}
