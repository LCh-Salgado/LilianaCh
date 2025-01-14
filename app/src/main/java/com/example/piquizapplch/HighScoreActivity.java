package com.example.piquizapplch;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class HighScoreActivity extends AppCompatActivity {

    ArrayList<HighScoreEntry> players;

    int score1;
    int score2;
    int score3;
    int score4;

    String player1;
    String player2;
    String player3;
    String player4;


    TextView firstPlayerTV;
    TextView firstScorePlayerTV;

    TextView secondPlayerTV;
    TextView secondScorePlayerTV;

    TextView thirdPlayerTV;
    TextView thirdScorePlayerTV;

    TextView fourPlayerTV;
    TextView fourScorePlayerTV;

    FirebaseDatabase database;
    DatabaseReference myRef;


    HighScoreEntry playerHighScore1;
    HighScoreEntry playerHighScore2;
    HighScoreEntry playerHighScore3;
    HighScoreEntry playerHighScore4;

    public static final String TAG = "VALUE FB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("highScores");

        players = new ArrayList<HighScoreEntry>();
        firstPlayerTV = (TextView)findViewById(R.id.playerName1TV);
        firstScorePlayerTV = (TextView)findViewById(R.id.playerScore1TV);

        secondPlayerTV = (TextView)findViewById(R.id.playerName2TV);
        secondScorePlayerTV = (TextView)findViewById(R.id.playerScore2TV);

        thirdPlayerTV = (TextView)findViewById(R.id.playerName3TV);
        thirdScorePlayerTV = (TextView)findViewById(R.id.playerScore3TV);

        fourPlayerTV = (TextView)findViewById(R.id.playerName4TV);
        fourScorePlayerTV = (TextView)findViewById(R.id.playerScore4TV);

        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;

        player1 = "";
        player2 = "";
        player3 = "";
        player4 = "";


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot customerSnapShot : dataSnapshot.getChildren()) {
                    HighScoreEntry myHighScore= customerSnapShot.getValue(HighScoreEntry.class);
                    Log.d(TAG, "Value is: " + myHighScore.getName());
                    players.add(myHighScore);
                }

                Collections.sort(players);

                if(players.size()>0){
                    playerHighScore1 = players.get(0);
                    player1 = playerHighScore1.getName();
                    score1 = playerHighScore1.getScore();
                    firstPlayerTV.setText(player1);
                    firstScorePlayerTV.setText(score1 + "");

                if(players.size()>1) {
                    playerHighScore2 = players.get(1);
                    player2 = playerHighScore2.getName();
                    score2 = playerHighScore2.getScore();
                    secondPlayerTV.setText(player2);
                    secondScorePlayerTV.setText(score2 + "");
                }
                if(players.size()>2) {
                    playerHighScore3 = players.get(2);
                    player3 = playerHighScore3.getName();
                    score3 = playerHighScore3.getScore();
                    thirdPlayerTV.setText(player3);
                    thirdScorePlayerTV.setText(score3 + "");
                }
                if(players.size()>3) {
                    playerHighScore4 = players.get(3);
                    player4 = playerHighScore4.getName();
                    score4 = playerHighScore4.getScore();
                    fourPlayerTV.setText(player4);
                    fourScorePlayerTV.setText(score4 + "");
                    }


                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());

            }
        });

    }
}