package com.cs60333.scho2.lab2_scho2;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
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
import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    String[] schedule = {
            "Ohio State",
            "Florida State",
            "Wake Forest",
            "Boston College",
            "North Carolina State",
            "Georgia Tech",
            "North Virginia",
            "Chicago Sate"
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScheduleAdapter adapter = new ScheduleAdapter(this, schedule, dates, puppers);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(adapter);
        scheduleListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setContentView(R.layout.activity_detail);
                Button b = (Button)findViewById(R.id.detailCamera);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(cameraIntent);
                    }
                });
//                String SelectedItem = schedule[position];
//                Toast.makeText(MainActivity.this, SelectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
