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
            d.setDescription("Some smart description!");
            d.setImage(NASA_URL + "/tornado.jpg");

            Step step1 = new Step();
            step1.SetStep("Step 1");
            step1.SetTime("6 hours");
            step1.setState(1);
            step1.setImage("step1.jpg");

            Step step2 = new Step();
            step2.SetStep("Step 2");
            step2.SetTime("5 hours");
            step2.setState(2);
            step2.setImage("step2.jpg");

            Step step3 = new Step();
            step3.SetStep("Step 3");
            step3.SetTime("4 hours");
            step3.setState(2);
            step3.setImage("step3.jpg");

            Step step4 = new Step();
            step4.SetStep("Step 4");
            step4.SetTime("3 hours");
            step4.setState(2);
            step4.setImage("step4.jpg");

            Step step5 = new Step();
            step5.SetStep("Step 5");
            step5.SetTime("2 hours");
            step5.setState(2);
            step5.setImage("step5.jpg");

            Step step6 = new Step();
            step6.SetStep("Step 6");
            step6.SetTime("1 hours");
            step6.setState(2);
            step6.setImage("step6.jpg");

            Step step7 = new Step();
            step7.SetStep("Step 7");
            step7.SetTime("less than an hour");
            step7.setState(2);
            step7.setImage("step7.jpg");

            Step step8 = new Step();
            step8.SetStep("Step 8");
            step8.SetTime("less than an hour");
            step8.setState(2);
            step8.setImage("step8.jpg");

            List<Step> steps = new ArrayList<>();
            steps.add(step1);
            steps.add(step2);
            steps.add(step3);
            steps.add(step4);
            steps.add(step5);
            steps.add(step6);
            steps.add(step7);
            steps.add(step8);

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
