package com.snsdevelop.nasa.disaster;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.snsdevelop.nasa.disaster.Adapters.StepsListAdapter;


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

        StepsListAdapter adapter = new StepsListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
