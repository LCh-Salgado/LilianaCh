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
    Button trueBTN, falseBTN, nextBTN;
    int score, duration;
    String toastMsg;
    Toast myToast;
    Intent goToSA;
    Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, currentQ;
    Question[] questions;
    int currentIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        toastMsg ="You got the question wrong.";
        q1 = new Question("The Witcher 3 Wild Hunt was developed by Ubisoft?", false);
        q2 = new Question("The original Super Mario Bross Game was released in 1985?", true);
        q3 = new Question("The game Minecraft was first released in 2011?", true);
        q4 = new Question("There are more than 15 games in the Call Of Duty Series?", false);
        q5 = new Question("The Nintendo Switch was released in 2016?", true);
        q6 = new Question("Pac-Man was originally called Puck Man?", true);
        q7 = new Question("The game Fornite was originally developed as a zombie survival game before the battle royal mode was introduced?",true);
        q8 = new Question("The Pokemon Franchise was created by Sega?", false);
        q9 = new Question("The game Among Us became popular during the COVID-19 pandemic in 2020?", true);
        q10 = new Question("The PlayStation 4 was released before the Xbox One?", true);

        currentIndex = 0;
        currentQ = q1;
        questions = new Question[] {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};

        questionTV = findViewById(R.id.questionTV);
        trueBTN = findViewById(R.id.trueBTN);
        falseBTN = findViewById(R.id.falseBTN);
        nextBTN = findViewById(R.id.nextBTN);

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQ.getCorrAns()==true)   {
                    toastMsg = "You got the question right.";
                    score++;

                }
                else {
                    toastMsg = "You got the question wrong.";

                }
                duration =  Toast.LENGTH_SHORT;
                myToast = Toast.makeText(MainActivity.this, toastMsg, duration);
                myToast.show();

            }
        });

        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQ.getCorrAns()==false) {
                    toastMsg = "You got the question right.";
                    score++;
                }
                else {
                    toastMsg = "You got the question wrong.";
                }
                duration =  Toast.LENGTH_SHORT;
                myToast = Toast.makeText(MainActivity.this, toastMsg, duration);
                myToast.show();

            }
        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex == 9) {
                    goToSA = new Intent(MainActivity.this, ScoreActivity.class);
                    goToSA.putExtra("Score", score);
                    startActivity(goToSA);

                }
                else {
                    currentIndex++;
                    currentQ = questions[currentIndex];
                    questionTV.setText(currentQ.getQText());

                }

            }
        });







    }
}