package com.snsdevelop.nasa.disaster.Entities;

public class Disaster
{
    private string Title;

    private string Image;

    private List<Step> Steps;

    public void setTitle(string title) {
        Title = title;
    }

    public void setImage(string image) {
        Image = image;
    }

    public void setSteps(List<Step> steps) {
        Steps = steps;
    }

    public string getTitle() {
        return Title;
    }

    public string getImage() {
        return Image;
    }

    public List<Step> getSteps() {
        return Steps;
    }
}
