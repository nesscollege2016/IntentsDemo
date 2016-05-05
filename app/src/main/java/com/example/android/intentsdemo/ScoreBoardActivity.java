package com.example.android.intentsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;

public class ScoreBoardActivity extends AppCompatActivity {
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        //get the intent:
        Intent intent = getIntent();

        //get the extras:
        Float score = intent.getFloatExtra("HighScore", 0);
        ratingBar.setRating(score);
    }
}
