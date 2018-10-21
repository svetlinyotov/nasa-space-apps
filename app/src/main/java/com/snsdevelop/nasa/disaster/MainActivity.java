package com.snsdevelop.nasa.disaster;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.snsdevelop.nasa.disaster.Services.DisasterCheckerService;
import com.snsdevelop.nasa.disaster.Utils.StoredData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, DisasterCheckerService.class));
        ImageView imageSun = findViewById(R.id.imageViewMainActivitySun);

        String disaster = StoredData.getString(this, StoredData.DISASTER);
        Log.d("COOL", "ASD: " + disaster);
        if (!disaster.equals("null")) {
            startActivity(new Intent(this, DisasterInfoActivity.class));
        }
    }
}
