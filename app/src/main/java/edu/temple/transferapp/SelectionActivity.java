package edu.temple.transferapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    GridView gridView;
    //private final int CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(R.string.titling);

        ArrayList<String> dogList = new ArrayList<String>();
        Resources res = getResources();
        String[] dogNames = res.getStringArray(R.array.dogNames);

        for(int i = 0; i < dogNames.length; i++){
            dogList.add(dogNames[i]);
        }

        ArrayList dogImage = new ArrayList<Integer>();
        dogImage.add(R.drawable.german_shepherd);
        dogImage.add(R.drawable.bulldog);
        dogImage.add( R.drawable.poodle);
        dogImage.add(R.drawable.siberian_husky);
        dogImage.add(R.drawable.daschund);
        dogImage.add(R.drawable.pomeranian);

        gridView = findViewById(R.id.gvNew);

        ImageAdapter adapter = new ImageAdapter(this, dogList, dogImage);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                {
                    Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
                    launchIntent.putExtra("description", dogList.get(position).toString());
                    launchIntent.putExtra("image", position);
                    startActivity(launchIntent);
                    finish();
                }
            }

        });





    }
}