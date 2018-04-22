package com.paazl.utils;

public class StatusUtils {

    //method for constructing serverAswer for GUI
    public static String succeedServerAnswer(String responseForBalanceRequest, String responseForSheepConditionsRequest) {

        return "Your current balance: " + responseForBalanceRequest + '\n' + responseForSheepConditionsRequest+'\n';
    }
}
