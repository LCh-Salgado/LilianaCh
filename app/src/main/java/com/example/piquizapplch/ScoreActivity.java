package com.example.piquizapplch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Button sendScoreByE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        sendScoreByE = (Button)findViewById(R.id.sendE);

        scoreTV = findViewById(R.id.scoreTV);
        score = 0;
        welcomeToSA = getIntent();
        score = welcomeToSA.getIntExtra("Score", 0);
        scoreTV.setText("" + score);

        sendScoreByE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] addresses = new String[] {"lilianachicas180@gmail.com"};
                String subject = "New score on the video games app";
                String body = "Score of your quiz: " + score;
                composeEmail(addresses, subject, body);


            }
        });
    }

    private void composeEmail(String[] addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}