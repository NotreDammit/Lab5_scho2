package com.cs60333.scho2.lab2_scho2;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    String[] schedule = {
            "Ohio State",
            "Florida State",
            "Wake Forest",
            "Boston College",
            "North Carolina",
            "Georgia Tech",
            "North Virginia",
            "Chicago State"
    };

    String[] mascots = {
            "Unicorns",
            "Tadpoles",
            "Pangolins",
            "Dragons",
            "Java Beans",
            "Monsters",
            "Puppers",
            "Penguins"
    };

    String[] opponentRecords = {
            "(1-1)",
            "(3-0)",
            "(2-6)",
            "(16-4)",
            "(12-1)",
            "(15-3)",
            "(7-7)",
            "(0-0)"
    };

    String[] ndRecords = {
            "(1-0)",
            "(2-0)",
            "(3-0)",
            "(4-0)",
            "(5-0)",
            "(6-0)",
            "(7-0)",
            "(8-0)"
    };

    String[] finalScores = {
            "0 - 12",
            "0 - 24",
            "0 - 7",
            "0 - 14",
            "7 - 52",
            "14 - 21",
            "0 - 63",
            "72 - 84"
    };

    String[] dates = {
            "1/1",
            "1/2",
            "1/3",
            "1/4",
            "1/5",
            "1/6",
            "1/7",
            "1/8"
    };

    String[] longDates = {
            "Monday, January 1, 6:00PM",
            "Tuesday, January 2, 6:00PM",
            "Wednesday, January 3, 6:00PM",
            "Thursday, January 4, 6:00PM",
            "Friday, January 5, 6:00PM",
            "Saturday, January 6, 6:00PM",
            "Sunday, January 7, 6:00PM",
            "Monday, January 8, 6:00PM"
    };

    Integer[] puppers = {
            R.drawable.puppers1,
            R.drawable.puppers2,
            R.drawable.puppers3,
            R.drawable.puppers4,
            R.drawable.puppers5,
            R.drawable.puppers6,
            R.drawable.puppers7,
            R.drawable.puppers8
    };

    ArrayList<Team> teams = new ArrayList<>();
//    Team team1 = new Team(new String[]{"Ohio State", "puppers1","Unicorns","(1-1)","(1-0)","0-12","Monday, January 1, 6:00PM"});
//    Team team2 = new Team(new String[]{"Florida State", "puppers2","Tadpoles","(3-0)","(2-0)","0-24","Tuesday, January 2, 6:00PM"});
//    Team team3 = new Team(new String[]{"Wake Forest", "puppers3","Pangolins","(2-6)","(3-0)","0-7","Wednesday, January 3, 6:00PM"});
//    Team team4 = new Team(new String[]{"Boston College", "puppers4","Dragons","(16-4)","(4-0)","0-14","Thursday, January 4, 6:00PM"});
//    Team team5 = new Team(new String[]{"North Carolina", "puppers5","Java Beans","(12-1)","(5-0)","7-52","Friday, January 5, 6:00PM"});
//    Team team6 = new Team(new String[]{"Georgia Tech", "puppers6","Monsters","(15-3)","(6-0)","14-21","Saturday, January 6, 6:00PM"});
//    Team team7 = new Team(new String[]{"North Virginia", "puppers7","Puppers","(7-7)","(7-0)","0-63","Sunday, January 7, 6:00PM"});
//    Team team8 = new Team(new String[]{"Chicago State", "puppers8","Penguins","(0-0)","(8-0)","72-84","Monday, January 8, 6:00PM"});


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String[]> temp;
        MyCsvFileReader csvFile = new MyCsvFileReader(getApplicationContext());
        temp = csvFile.readCsvFile(R.raw.schedule);

        for (int i=0; i<temp.size(); i++) {
            String[] ex = temp.get(i);
            Team team = new Team(ex);
            teams.add(team);
            //Log.d("help", temp.get(i)[0]);
        }

//        teams.add(team1);
//        teams.add(team2);
//        teams.add(team3);
//        teams.add(team4);
//        teams.add(team5);
//        teams.add(team6);
//        teams.add(team7);
//        teams.add(team8);

        ScheduleAdapter adapter = new ScheduleAdapter(this, schedule, dates, puppers);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(adapter);
        scheduleListView.setOnItemClickListener( new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra("teams", teams);
                detailIntent.putExtra("position", position);
                startActivity(detailIntent);

//                detailIntent.putExtra("team", schedule[position]);
//                detailIntent.putExtra("teamLogo", puppers[position]);
//                detailIntent.putExtra("teamMascot", mascots[position]);
//                detailIntent.putExtra("teamRecord", opponentRecords[position]);
//                detailIntent.putExtra("score", finalScores[position]);
//                detailIntent.putExtra("date", longDates[position]);
//                detailIntent.putExtra("record", ndRecords[position]);

//                setContentView(R.layout.activity_detail);
//                Button b = (Button)findViewById(R.id.detailCamera);
//                b.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                        startActivity(cameraIntent);
//                    }
//                });

//                String SelectedItem = schedule[position];
//                Toast.makeText(MainActivity.this, SelectedItem, Toast.LENGTH_SHORT).show();
//                hi

            }
        });
    }
}
