package com.snsdevelop.nasa.disaster.Entities;

import java.util.List;

public class Disaster
{
    private String id;
    private String Title;
    private String description;
    private String expectedIn;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpectedIn() {
        return expectedIn;
    }

    public void setExpectedIn(String expectedIn) {
        this.expectedIn = expectedIn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
