package com.example.piquizapplch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTV;
    int score;
    Intent welcomeToSA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = findViewById(R.id.scoreTV);
        score = 0;
        welcomeToSA = getIntent();
        score = welcomeToSA.getIntExtra("Score", 0);
        scoreTV.setText("" + score);
    }
}