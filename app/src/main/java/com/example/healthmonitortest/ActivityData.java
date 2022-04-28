package com.example.healthmonitortest;

import org.bson.types.ObjectId;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ActivityData extends RealmObject {

    @PrimaryKey
    private ObjectId _id = new ObjectId();

    private double distanceKm;

    private double duration;

    private int calories;

    private long endDate;

    private int steps;

    private int avgHeartrate;

    private int minHeartrate;

    private int maxHeartrate;

    private int restingHeartrate;

    private int vo2Max;

    private int respiratoryRate;

    private double temperatureCelsius;

    private long date;

    public ActivityData() {
    }

    public ActivityData(double distanceKm, double duration, int calories, long endDate, int steps,
                        int avgHeartrate, int minHeartrate, int maxHeartrate, int restingHeartrate,
                        int vo2Max, int respiratoryRate, double temperatureCelsius, long date) {
        this.distanceKm = distanceKm;
        this.duration = duration;
        this.calories = calories;
        this.endDate = endDate;
        this.steps = steps;
        this.avgHeartrate = avgHeartrate;
        this.minHeartrate = minHeartrate;
        this.maxHeartrate = maxHeartrate;
        this.restingHeartrate = restingHeartrate;
        this.vo2Max = vo2Max;
        this.respiratoryRate = respiratoryRate;
        this.temperatureCelsius = temperatureCelsius;
        this.date = date;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getAvgHeartrate() {
        return avgHeartrate;
    }

    public void setAvgHeartrate(int avgHeartrate) {
        this.avgHeartrate = avgHeartrate;
    }

    public int getMinHeartrate() {
        return minHeartrate;
    }

    public void setMinHeartrate(int minHeartrate) {
        this.minHeartrate = minHeartrate;
    }

    public int getMaxHeartrate() {
        return maxHeartrate;
    }

    public void setMaxHeartrate(int maxHeartrate) {
        this.maxHeartrate = maxHeartrate;
    }

    public int getRestingHeartrate() {
        return restingHeartrate;
    }

    public void setRestingHeartrate(int restingHeartrate) {
        this.restingHeartrate = restingHeartrate;
    }

    public int getVo2Max() {
        return vo2Max;
    }

    public void setVo2Max(int vo2Max) {
        this.vo2Max = vo2Max;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public void setTemperatureCelsius(double temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
