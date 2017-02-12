package com.cs60333.scho2.lab2_scho2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.ArrayList;

/**
 * Created by samcholo on 2/11/17.
 */

public class ScheduleAdapter extends ArrayAdapter<String> {
    private Activity context;
    private String[] schedule;
    private String[] dates;
    private Integer[] puppers;
    public ScheduleAdapter (Activity context, String[] schedule, String[] dates, Integer[] puppers) {
        super(context, R.layout.schedule_item, schedule);
        this.context=context;
        this.schedule=schedule;
        this.dates=dates;
        this.puppers=puppers;
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater scheduleInflater = context.getLayoutInflater();
        View scheduleView = scheduleInflater.inflate(R.layout.schedule_item, null, true);

//        String matchItem = getItem(position);
//        TextView teamName = (TextView) scheduleView.findViewById(R.id.scheduleText);
//        teamName.setText(matchItem);

        TextView teamName = (TextView) scheduleView.findViewById(R.id.nameOfSchool);
        ImageView pupperView = (ImageView) scheduleView.findViewById(R.id.imageOfPuppers);
        TextView gameDate = (TextView) scheduleView.findViewById(R.id.date);

        teamName.setText(schedule[position]);
        pupperView.setImageResource(puppers[position]);
        gameDate.setText(dates[position]);

        return scheduleView;
    }
}
