package com.snsdevelop.nasa.disaster.Entities;

public class Step
{
    private string Time;

    private string Step;

    public string GetTime()
    {
        return Time;
    }

    public string GetStep()
    {
        return Step;
    }

    public void SetTime(string time)
    {
        Time = time;
    }

    public void SetStep(string step)
    {
        Step = step;
    }
}