package com.snsdevelop.nasa.disaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.snsdevelop.nasa.disaster.R;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_preference);

        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);

        editText1.setKeyListener(null);
        editText2.setKeyListener(null);


        //buttonListAll.setOnClickListener(view -> {
          //  Intent myIntent = new Intent(this, StepsListActivity.class);
            //startActivity(myIntent);
        //});

    }
}