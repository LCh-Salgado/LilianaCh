package com.example.piquizapplch;

import android.content.Intent;
import android.content.SharedPreferences;
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

    private SharedPreferences mPreferences;
    private String sharedPreferences= "com.example.piquizapplch.sp";
    private final String NAME_KEY = "NAME";
    String initialName;

    TextView hiPlayerTV;
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

        mPreferences = getSharedPreferences(sharedPreferences, MODE_PRIVATE);
        initialName = mPreferences.getString(NAME_KEY, "Player");
        score = 0;
        toastMsg =getString(R.string.wrongToastMsg);
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

        hiPlayerTV = findViewById(R.id.playerTV);
        hiPlayerTV.setText("Hi Player:" + initialName);
        questionTV = findViewById(R.id.questionTV);
        trueBTN = findViewById(R.id.trueBTN);
        falseBTN = findViewById(R.id.falseBTN);
        nextBTN = findViewById(R.id.nextBTN);

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQ.getCorrAns()==true)   {
                    toastMsg = getString(R.string.rightToastMsg);
                    score++;

                }
                else {
                    toastMsg = getString(R.string.wrongToastMsg);

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
                    toastMsg = getString(R.string.rightToastMsg);
                    score++;
                }
                else {
                    toastMsg = getString(R.string.wrongToastMsg);
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