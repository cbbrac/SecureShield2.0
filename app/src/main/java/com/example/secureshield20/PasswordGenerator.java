package com.example.secureshield20;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final SecureRandom random = new SecureRandom();
    private static final String caps="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String small_caps="abcdefghijklmnopqrstuvwxyz";
    private static final String Numeric="1234567890";
    private static final String special_char="~!@#$%^&*(_+{}|:_[?]>=<";
    private static final String dic = caps + small_caps + Numeric + special_char;
    private String passwordStr;

    public void generatePassword(int len) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i <len ; i++) {
            int index = random.nextInt(dic.length());
            password.append(dic.charAt(index));
        }

        passwordStr = password.toString();
    }

    public String getPasswordStr() {
        return passwordStr;
    }

    public void setPasswordStr(String passwordStr) {
        this.passwordStr = passwordStr;
    }

}