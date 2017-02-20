package com.cs60333.scho2.lab2_scho2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

/**
 * Created by samcholo on 2/20/17.
 */

public class DetailActivity extends Activity {
    @Override
    public void onCreate (Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_detail);
        Button b = (Button)findViewById(R.id.detailCamera);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
            }
        });
//initialize all the widgets of your layout file here.

    }
}
