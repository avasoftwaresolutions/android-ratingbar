package com.avasoftwaresolutions.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.avasoftwaresolutions.ratingbar.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatingBar ratingBar = findViewById(R.id.ratingbar);
        ratingBar.setFilledTint();
        ratingBar.setUnfilledTint();
        ratingBar.setStarDrawable();
        ratingBar.setStarDrawableFilled();
        ratingBar.getStars();
        ratingBar.setOnClickListener(listener);

    }
}
