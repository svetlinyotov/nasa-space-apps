package com.snsdevelop.nasa.disaster.Utils;

import android.content.res.Resources;

import com.google.gson.Gson;
import com.snsdevelop.nasa.disaster.Entities.Disaster;
import com.snsdevelop.nasa.disaster.Entities.Disasters;
import com.snsdevelop.nasa.disaster.Entities.Step;
import com.snsdevelop.nasa.disaster.R;

import java.util.ArrayList;
import java.util.List;

public class DisasterInfo {

    private static final String NASA_URL = "http://snsdevelop.com/nasa_img";

    public static Disaster getData(String disaster) {
        //TODO: use JSON from server API
        if (disaster.equals("tornado")) {
            Disaster d = new Disaster();
            d.setTitle("Tornado");
            d.setExpectedIn("6 hours");
            d.setDescription("asdasd");
            d.setImage(NASA_URL + "/tornado.jpg");

            Step step1 = new Step();
            step1.SetStep("Step 1");
            step1.SetTime("12 hours");

            List<Step> steps = new ArrayList<>();
            steps.add(step1);
            d.setSteps(steps);

            return d;
        } else if (disaster.equals("flood")) {
            Disaster d = new Disaster();
            d.setTitle("Flood");
            d.setExpectedIn("24 hours");
            d.setDescription("asdasd");
            d.setImage(NASA_URL + "/flood.jpg");

            Step step1 = new Step();
            step1.SetStep("Step 1");
            step1.SetTime("12 hours");

            List<Step> steps = new ArrayList<>();
            steps.add(step1);
            d.setSteps(steps);

            return d;
        }

        return null;
    }
}
