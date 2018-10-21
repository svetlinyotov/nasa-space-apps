package com.snsdevelop.nasa.disaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.snsdevelop.nasa.disaster.Entities.Step;
import com.snsdevelop.nasa.disaster.Utils.DisasterInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StepViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_view);

        Button buttonListAll = findViewById(R.id.button2);
        buttonListAll.setOnClickListener(view -> {
            Intent myIntent = new Intent(this, StepsListActivity.class);
            startActivity(myIntent);
        });

        Button buttonDone = findViewById(R.id.button);
        buttonListAll.setOnClickListener(view -> {
            List<Step> steps = DisasterInfo.getData("tornado").getSteps();

            int currentStepIndex = 0;

            for (int i = 0; i < steps.size(); i++)
            {
                if (steps.get(i).getState() == 1)
                {
                    currentStepIndex = i;
                }

                ImageView image = findViewById(R.id.imageViewStepImage);
                TextView stepName = findViewById(R.id.textViewStepName);

                steps.get(currentStepIndex).setState(2);
                steps.get(currentStepIndex + 1).setState(1);

                Picasso.get().load(steps.get(currentStepIndex + 1).getImage()).into(image);
                stepName.setText(steps.get(currentStepIndex + 1).GetStep());


//                TextView title = findViewById(R.id.textViewDisasterTitle);
//                TextView description = findViewById(R.id.textViewDisasterContent);
//                TextView expectedIn = findViewById(R.id.textViewExpectedIn);
//                ImageView imageView = findViewById(R.id.imageViewDisaster);
//
//                String d = StoredData.getString(this, StoredData.DISASTER);
//                Disaster disaster = DisasterInfo.getData(d);
//
//                if (disaster != null) {
//                    title.setText(disaster.getTitle());
//                    description.setText(disaster.getDescription());
//                    expectedIn.setText(disaster.getExpectedIn());
//                    Picasso.get().load(disaster.getImage()).into(imageView);
//                }

            }

            //Intent myIntent = new Intent(this, StepsListActivity.class);
            //startActivity(myIntent);
        });
    }
}
