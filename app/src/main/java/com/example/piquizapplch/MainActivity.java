package com.example.piquizapplch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView questionTV;
    Button trueBTN, falseBTN, doneBTN;
    int score, duration;
    String toastMsg;
    Toast myToast;
    Intent goToSA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        toastMsg ="You got the question wrong.";
        questionTV = findViewById(R.id.questionTV);
        trueBTN = findViewById(R.id.trueBTN);
        falseBTN = findViewById(R.id.falseBTN);
        doneBTN = findViewById(R.id.doneBTN);

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMsg = "You got the question right";
                score++;
                duration =  Toast.LENGTH_SHORT;
                myToast = Toast.makeText(MainActivity.this, toastMsg, duration);
                myToast.show();

            }
        });

        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMsg = "You got the question wrong";
                duration =  Toast.LENGTH_SHORT;
                myToast = Toast.makeText(MainActivity.this, toastMsg, duration);
                myToast.show();

            }
        });

        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSA = new Intent(MainActivity.this, ScoreActivity.class);
                goToSA.putExtra("Score", score);
                startActivity(goToSA);
            }
        });







    }
}