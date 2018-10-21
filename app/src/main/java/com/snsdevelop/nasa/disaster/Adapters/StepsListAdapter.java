package com.snsdevelop.nasa.disaster.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.snsdevelop.nasa.disaster.Entities.Step;
import com.snsdevelop.nasa.disaster.R;
import com.snsdevelop.nasa.disaster.StepViewActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StepsListAdapter extends ArrayAdapter<Step> {

    private final Activity context;
    private final List<Step> steps;

    public StepsListAdapter(Activity context, List<Step> steps) {
        super(context, R.layout.activity_steps_list, steps);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.steps=steps;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        //TODO: use ViewHolder pattern
        View rowView=inflater.inflate(R.layout.steps_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(steps.get(position).GetStep());
        Picasso.get().load(steps.get(position).getImage()).into(imageView);
        rowView.setOnClickListener((v) -> {
            Intent intent = new Intent(context, StepViewActivity.class);
            intent.putExtra("stepPosition", position);
            context.startActivity(intent);
        });
//        extratxt.setText(steps.get(position).GetStep().substring("abc", 0, 4));
        return rowView;
    }
}