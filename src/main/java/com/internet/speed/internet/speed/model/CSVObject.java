package com.internet.speed.internet.speed.model;

public class CSVObject {

    public double speed;
    public String currentDateTime;

    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "CSVObject{" +
                "speed=" + speed +
                ", currentDateTime='" + currentDateTime + '\'' +
                '}';
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }
}
