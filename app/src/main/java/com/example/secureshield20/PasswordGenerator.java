package com.example.secureshield20;

/**Class that generates an encrypted password using the SecureRandom library, combining randomly
 * different characters. It returns a password as a String.
 */

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final SecureRandom random = new SecureRandom();
    private static final String caps="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String small_caps="abcdefghijklmnopqrstuvwxyz";
    private static final String Numeric="1234567890";
    private static final String special_char="~!@#$%^&*(_+{}|:_[?]>=<";
    private static final String dic = caps + small_caps + Numeric + special_char;
    private String passwordStr;

    //Method that takes a parameter that will define the length of the password.
    //It loops through the length, generating a random character taken from the caps, small_caps,
    //numeric and special_character variables. Then, it appends that character to the StringBuilder
    //and finally it converts it to a String and returns it.
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