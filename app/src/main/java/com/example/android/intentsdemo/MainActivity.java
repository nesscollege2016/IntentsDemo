package com.example.android.intentsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etRating;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = (Button) findViewById(R.id.btnNext);
        etRating = (EditText) findViewById(R.id.etRating);

        btnNext.setOnClickListener(this);

    }

    Float getRating(){
        try {
            Float rating =  Float.valueOf(etRating.getText().toString());
            if (rating >5 || rating <0){
                etRating.setError("Must be 0-5");
                return null;
            }
            return rating;
        }
        catch (Exception e){
            etRating.setError("Must be a valid number");
            return null;
        }
    }
    public void onClick(View v) {
        Float rating = getRating();
        if (rating == null)return;

        //init an intent with the context(this) & the destination class
        Intent intent = new Intent(this, ScoreBoardActivity.class);
        //put some extras:
        intent.putExtra("HighScore", rating);

        //launch the intent
        startActivity(intent);
    }
}
