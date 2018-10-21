package com.snsdevelop.nasa.disaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}
