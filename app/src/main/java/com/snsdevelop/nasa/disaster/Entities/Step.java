package com.snsdevelop.nasa.disaster.Entities;

public class Step {
    private String Time;
    private String image;
    private String Step;

    public String GetTime() {
        return Time;
    }

    public String GetStep() {
        return Step;
    }

    public void SetTime(String time) {
        Time = time;
    }

    public void SetStep(String step) {
        Step = step;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}