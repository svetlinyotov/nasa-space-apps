package com.snsdevelop.nasa.disaster;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.snsdevelop.nasa.disaster.Services.DisasterCheckerService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageSun = findViewById(R.id.imageViewMainActivitySun);

        imageSun.setOnClickListener((view) -> startActivity(new Intent(this, StepViewActivity.class)));

        startService(new Intent(this, DisasterCheckerService.class));
    }
}
