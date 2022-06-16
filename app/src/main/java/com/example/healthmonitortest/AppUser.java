package com.example.healthmonitortest;

import org.bson.types.ObjectId;
import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class AppUser extends RealmObject {
    @PrimaryKey
    private ObjectId _id = new ObjectId();
    @Required
    private String password;
    @Required
    private String email;
    @Required
    private String name;

    private int phoneNr;

    private RealmList<ObjectId> utenteList;


    private boolean isAdmin;

    public AppUser() {
    }

    public AppUser(String email, String password, String nome, int phoneNr,boolean isAdmin) {
        this.password = password;
        this.email = email;
        this.name = nome;
        this.phoneNr = phoneNr;
        this.isAdmin = isAdmin;
        this.utenteList = new RealmList();

    }


    public ObjectId get_id() {
        return _id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<ObjectId> getUtenteList() {
        return utenteList;
    }

    public void setUtenteList(RealmList<ObjectId> utenteList) {
        this.utenteList = utenteList;
    }
}
