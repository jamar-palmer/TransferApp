package edu.temple.transferapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    int[] dogImages;

    String name;
    int picID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textView =  findViewById(R.id.txtLabel);
        imageView = findViewById(R.id.imageView);

        dogImages = new int[]{R.drawable.german_shepherd, R.drawable.bulldog,
                R.drawable.poodle, R.drawable.siberian_husky, R.drawable.daschund, R.drawable.pomeranian};

        Intent intent = getIntent();
        name = intent.getStringExtra("description");
        picID = intent.getIntExtra("image", 0);

        textView.setText(name);
        textView.setTextSize(30);

        showPicture(picID);

    }

    private void showPicture(int position) {
            imageView.setImageResource(dogImages[position]);

    }

    @Override
    public void onBackPressed() {
        Intent returnBack = new Intent (DisplayActivity.this, SelectionActivity.class);
        startActivity(returnBack);
        finish();
    }
}