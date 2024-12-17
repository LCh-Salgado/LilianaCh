package com.example.piquizapplch;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HighScoreActivity extends AppCompatActivity {

    TextView firstPlayerTV;
    TextView firstScorePlayerTV;

    TextView secondPlayerTV;
    TextView secondScorePlayerTV;

    TextView thirdPlayerTV;
    TextView thirdScorePlayerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        firstPlayerTV = (TextView)findViewById(R.id.playerName1TV);
        firstScorePlayerTV = (TextView)findViewById(R.id.playerScore1TV);

        secondPlayerTV = (TextView)findViewById(R.id.playerName2TV);
        secondScorePlayerTV = (TextView)findViewById(R.id.playerScore2TV);

        thirdPlayerTV = (TextView)findViewById(R.id.playerName3TV);
        thirdScorePlayerTV = (TextView)findViewById(R.id.playerScore3TV);


    }
}