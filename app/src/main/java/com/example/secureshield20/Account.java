package com.example.secureshield20;
/**Abstract class to create Account objects. It has seven variables: the id (int), the name,
 * username, password, website, uri and iconUrl strings. It contains the getters and setters for
 * each variable.
 */

import java.util.Comparator;

public class Account {

    private int id;
    private String name;
    private String username;
    private String password;
    private String website;
    private String uri = "";
    private String iconUrl = "https://www.google.com/s2/favicons?domain=";

    //Constructor for the Account class.
    public Account(int id, String name, String username, String password, String website,
                   String uri) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.website = website;
        this.uri = uri;
        this.iconUrl += website;
    }

    public static Comparator<Account> AccountsSortAZ = new Comparator<Account>() {
        @Override
        public int compare(Account acc1, Account acc2) {
            return acc1.getName().compareTo(acc2.getName());
        }
    };

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", website='" + website + '\'' +
                ", uri='" + uri + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
