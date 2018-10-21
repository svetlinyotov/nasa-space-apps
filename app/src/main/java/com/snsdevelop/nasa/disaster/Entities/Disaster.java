package com.snsdevelop.nasa.disaster.Entities;

import java.util.List;

public class Disaster
{
    private String Title;

    private String Image;

    private List<Step> Steps;

    public void setTitle(String title) {
        Title = title;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setSteps(List<Step> steps) {
        Steps = steps;
    }

    public String getTitle() {
        return Title;
    }

    public String getImage() {
        return Image;
    }

    public List<Step> getSteps() {
        return Steps;
    }
}
