package com.example.healthmonitortest;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class AppUser extends RealmObject {
    @PrimaryKey
    private ObjectId _id = new ObjectId();
    @Required
    private String username;
    @Required
    private String password;
    @Required
    private String email;
    private int phoneNr;

    public AppUser() {
    }

    public AppUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public AppUser(String username, String password, String email, int phoneNr) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNr = phoneNr;
    }

    public ObjectId get_id() {
        return _id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }
}
