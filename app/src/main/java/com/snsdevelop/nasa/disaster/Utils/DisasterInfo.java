package com.snsdevelop.nasa.disaster.Utils;

import com.snsdevelop.nasa.disaster.Entities.Disaster;
import com.snsdevelop.nasa.disaster.Entities.Step;

import java.util.ArrayList;
import java.util.List;

public class DisasterInfo {

    public static Disaster d;
    private static final String NASA_URL = "http://snsdevelop.com/nasa_img";

    public static Disaster getData(String disaster) {
        //TODO: use JSON from server API
        if (disaster.equals("tornado")) {
            d = new Disaster();
            d.setTitle("Tornado");
            d.setExpectedIn("6 hours");
            d.setDescription("According to NOAA, there were over 1,400 tornadoes in 2017. And while tornadoes can strike whenever they please, they're most likely to wreak havoc from April onward til the clock strikes midnight on your summer.\n" +
                    "It's no secret that tornadoes seriously blow, leaving devastation and destruction in their wake. Most importantly, your favorite television metereologist can't always predict when they're coming. This makes it even more important that you know what to do before, during and after a tornado hits. \n");
            d.setImage(NASA_URL + "/tornado.jpg");

            Step step1 = new Step();
            step1.SetStep("Take medicine ");
            step1.SetTime("6 hours");
            step1.setState(1);
            step1.setDescription("Know what alarms or notifications the government uses for tornado watches or warnings");
            step1.setImage(NASA_URL + "/step1.jpg");

            Step step2 = new Step();
            step2.SetStep("Get Tom ");
            step2.SetTime("5 hours");
            step2.setDescription("Don't forget the baby");
            step2.setState(1);
            step2.setImage(NASA_URL + "/step2.jpg");

            Step step3 = new Step();
            step3.SetStep("Plan Ahead ");
            step3.SetTime("5 hours");
            step3.setState(2);
            step3.setDescription("Have a dress rehearsal to make sure everyone is fully prepared to take responsibility for his or her own safety");
            step3.setState(1);
            step3.setImage(NASA_URL + "/step3.jpg");

            Step step4 = new Step();
            step4.SetStep("Watch the Weather ");
            step4.SetTime("4 hours");
            step4.setState(2);
            step4.setDescription("Changing weather patterns are like a cheat sheet telling you a tornado might be coming. Pay attention to weather reports and rely on your own instincts and experience.");
            step4.setImage(NASA_URL + "/step4.jpg");

            Step step5 = new Step();
            step5.SetStep("See for Yourself ");
            step5.SetTime("3 hours");
            step5.setState(2);
            step5.setDescription("Nature doesn't try to pull a fast one when a tornado is coming. Look for a dark, greenish sky, a wall of clouds and large, grapefruit-sized hail.");
            step5.setImage(NASA_URL + "/step5.jpg");

            Step step6 = new Step();
            step6.SetStep("Listen");
            step6.SetTime("2 hours");
            step6.setState(2);
            step6.setDescription("Aside from the alarms, some say tornadoes produce a roar similar to a train.");
            step6.setImage(NASA_URL + "/step6.jpg");

            Step step7 = new Step();
            step7.SetStep("Go Underground ");
            step7.SetTime("1 hours");
            step7.setState(2);
            step7.setDescription("If there's no basement, a small room in the middle of the house is best. And since windows can break, stay away from them at all costs");
            step7.setImage(NASA_URL + "/step7.jpg");

            Step step8 = new Step();
            step8.SetStep("Know When to Leave ");
            step8.SetTime("less than an hour");
            step8.setState(2);
            step8.setImage(NASA_URL + "/step8.jpg");


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
