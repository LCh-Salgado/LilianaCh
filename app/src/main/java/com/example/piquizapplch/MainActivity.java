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
    Intent atToSA;
    Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, currentQ;
    Question[] questions;
    int currentIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        toastMsg =getString(R.string.wrong_msg);
        q1 = new Question(getString(R.string.q1text), false);
        q2 = new Question(getString(R.string.q2text), true);
        q3 = new Question(getString(R.string.q3text), true);
        q4 = new Question(getString(R.string.q4text), false);
        q5 = new Question(getString(R.string.q5text), true);
        q6 = new Question(getString(R.string.q6text), true);
        q7 = new Question(getString(R.string.q7text),true);
        q8 = new Question(getString(R.string.q8text), false);
        q9 = new Question(getString(R.string.q9text), true);
        q10 = new Question(getString(R.string.q10text), true);

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
                    toastMsg = getString(R.string.trueToastMsg);
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
                    toastMsg = getString(R.string.falseToastMsg);
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
                    atToSA = new Intent(MainActivity.this, ScoreActivity.class);
                    atToSA.putExtra("Score", score);
                    startActivity(atToSA);

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