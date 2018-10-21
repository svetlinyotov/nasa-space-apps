package com.snsdevelop.nasa.disaster;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.snsdevelop.nasa.disaster.Adapters.StepsListAdapter;
import com.snsdevelop.nasa.disaster.Entities.Disaster;
import com.snsdevelop.nasa.disaster.Utils.DisasterInfo;


public class StepsListActivity extends Activity{

    ListView list;
    String[] itemname ={
            "Safari",
            "Camera",
            "Global"
    };

    Integer[] imgid={
            R.drawable.ic_icons8_sun,
            R.drawable.ic_icons8_sun,
            R.drawable.ic_icons8_sun
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_list);

        Disaster disaster = DisasterInfo.getData("tornado");
        Log.d("COOL", String.valueOf(disaster.getSteps().size()));

        StepsListAdapter adapter = new StepsListAdapter(this, disaster.getSteps());
        list=findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            // TODO Auto-generated method stub
            String Slecteditem= itemname[+position];
            Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

        });
    }
}
