package com.example.secureshield20;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<Account> accountList = new ArrayList<>();
    private static int nextId;

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}