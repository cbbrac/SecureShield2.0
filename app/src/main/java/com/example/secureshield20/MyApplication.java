package com.example.secureshield20;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {


    private static List<String> accountList = new ArrayList<>();
    private static int nextId = 0;                          // This variable should start on 0

    public static List<String> getAccountList() {
        return accountList;
    }

    public static void setAccountList(List<String> accountList) {
        MyApplication.accountList = accountList;
    }

    public static String getNameTxt() {
        return nameTxt;
    }

    public static String setNameTxt(String nameTxt) {
        MyApplication.nameTxt = nameTxt;
        return nameTxt;
    }

    private static String nameTxt = "";



    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
