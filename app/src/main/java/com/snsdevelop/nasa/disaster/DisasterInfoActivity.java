package com.snsdevelop.nasa.disaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.snsdevelop.nasa.disaster.Entities.Disaster;
import com.snsdevelop.nasa.disaster.Utils.DisasterInfo;
import com.snsdevelop.nasa.disaster.Utils.StoredData;
import com.squareup.picasso.Picasso;

public class DisasterInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster_info);

        TextView title = findViewById(R.id.textViewDisasterTitle);
        TextView description = findViewById(R.id.textViewDisasterContent);
        TextView expectedIn = findViewById(R.id.textViewExpectedIn);
        ImageView imageView = findViewById(R.id.imageViewDisaster);
        Button button = findViewById(R.id.buttonWhatToDo);

        String d = StoredData.getString(this, StoredData.DISASTER);
        Disaster disaster = DisasterInfo.getData(d);

        if (disaster != null) {
            title.setText(disaster.getTitle());
            description.setText(disaster.getDescription());
            expectedIn.setText(disaster.getExpectedIn());
            Picasso.get().load(disaster.getImage()).into(imageView);
            button.setOnClickListener((v) -> startActivity(new Intent(this, StepViewActivity.class)));
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
