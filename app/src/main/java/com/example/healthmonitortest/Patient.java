package com.example.healthmonitortest;

import org.bson.types.ObjectId;
import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import io.realm.internal.RealmObjectProxy;

public class Patient extends RealmObject {
    @PrimaryKey
    private ObjectId _id = new ObjectId();
    @Required
    private String password;
    @Required
    private String email;
    @Required
    private String name;

    private int phoneNr;

    private RealmList<ObjectId> activities;

    private RealmList<Integer> biometricData;

    public Patient() {
    }

    public Patient(String password, String email, String name, int phoneNr) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.phoneNr = phoneNr;
        this.activities = new RealmList<>();
        this.biometricData = new RealmList<>();
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    public RealmList<ObjectId> getActivities() {
        return activities;
    }

    public void setActivities(RealmList<ObjectId> activities) {
        this.activities = activities;
    }

    public RealmList<Integer> getBiometricData() {
        return biometricData;
    }

    public void setBiometricData(RealmList<Integer> biometricData) {
        this.biometricData = biometricData;
    }
}
