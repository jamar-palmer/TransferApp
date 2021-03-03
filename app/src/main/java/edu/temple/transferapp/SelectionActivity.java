package edu.temple.transferapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    Spinner spinner;
    private final int CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Item Selection");

        ArrayList dogList = new ArrayList<String>();
        dogList.add("Please Select A Dog From The List");
        dogList.add("German Shepard");
        dogList.add("Bulldog");
        dogList.add("Poodle");
        dogList.add("Siberian Husky");
        dogList.add("Dachshund");
        dogList.add("Pomeranian");

        ArrayList dogImage = new ArrayList<Integer>();
        dogImage.add(R.drawable.german_shepherd);
        dogImage.add(R.drawable.bulldog);
        dogImage.add( R.drawable.poodle);
        dogImage.add(R.drawable.siberian_husky);
        dogImage.add(R.drawable.daschund);
        dogImage.add(R.drawable.pomeranian);

        spinner = findViewById(R.id.spinner);

        ImageAdapter adapter = new ImageAdapter(this, dogList, dogImage);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position != 0) {
                    Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
                    launchIntent.putExtra("description", dogList.get(position).toString());
                    launchIntent.putExtra("image", position);
                    startActivityForResult(launchIntent, CODE);
                    finish();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }
}