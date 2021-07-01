package com.example.secureshield20;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<Account> accountList = new ArrayList<>();
    private static int nextId = 0;                          // This variable should start on 0

    public MyApplication() {
        //fillAccountList();
    }

    /*private void fillAccountList() {
        Account acc0 = new Account(0, "Facebook", "facebook_username", "facebook_password",
                "https" +
                "://www.facebook.com", "androidapp://com.facebook");
        Account acc1 = new Account(1, "Google", "google_username", "google_password", "https" +
                "://www.google.com", "androidapp://com.google");
        Account acc2 = new Account(2, "Zoom", "zoom_username", "zoom_password", "https" +
                "://www.zoom.com", "androidapp://com.zoom");

        accountList.addAll(Arrays.asList(new Account[] {acc0, acc1, acc2}));
    }*/

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
