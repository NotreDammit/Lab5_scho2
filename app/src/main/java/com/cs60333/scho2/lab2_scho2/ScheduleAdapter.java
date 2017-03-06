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

import static java.lang.Integer.parseInt;

/**
 * Created by samcholo on 2/11/17.
 */

public class ScheduleAdapter extends ArrayAdapter<Team> {
    private Activity context;
    private String[] opponentName;
    private String[] dates;
    private Integer[] puppers;
    ArrayList<Team> example = new ArrayList<>();
//    private String[] mascots;
//    private String[] opponentRecords;
//    private String[] ndRecords;
//    private String[] finalScores;
    public ScheduleAdapter (Activity context, String[] teams, String[] dates, Integer[] puppers) {
        super(context, R.layout.schedule_item);
        //this.example = teams;
        this.context=context;
        this.opponentName=teams;
        this.dates=dates;
        this.puppers=puppers;
//        this.schedule=schedule;
//        this.dates=dates;
//        this.puppers=puppers;
//        this.mascots=mascots;
//        this.opponentRecords=opponentRecords;
//        this.ndRecords=ndRecords;
//        this.finalScores=finalScores;
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

        String opponentName1 = this.opponentName[position];
        String dates1 = this.dates[position];
        Integer puppers1 = this.puppers[position];
//        opponentName = example.get(position).getTeamName();
//        puppers = example.get(position).getTeamLogo();
//        dates = example.get(position).getDate();

        teamName.setText(opponentName[position]);
        //int resID = context.getResources().getIdentifier(puppers, "drawable", context.getPackageName());
        //int a = R.drawable.puppers5;
        pupperView.setImageResource(puppers[position]);
        gameDate.setText(dates[position]);

        return scheduleView;
    }
}
