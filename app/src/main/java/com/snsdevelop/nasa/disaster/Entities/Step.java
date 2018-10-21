package com.snsdevelop.nasa.disaster.Entities;

public class Step {
    private String Time;

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
}