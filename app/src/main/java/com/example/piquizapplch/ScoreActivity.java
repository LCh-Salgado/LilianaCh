package com.example.piquizapplch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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

public class ScoreActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String sharedPreferences= "com.example.piquizapplch.sp";
    private final String NAME_KEY = "NAME";
    String initialName;


    TextView scoreTV;

    TextView hiPlayerTV;

    Intent showHighScoreIntent;

    int score;
    Intent welcomeToSA;
    Button sendScoreByE;
    Button sendScoreFB;

    FirebaseDatabase database;
    DatabaseReference myRef;
    HighScoreEntry player1;
    public static final String TAG = "VALUE FB";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        sendScoreByE = (Button)findViewById(R.id.sendE);
        sendScoreFB = (Button)findViewById(R.id.sendScoreFBBTN);

        scoreTV = findViewById(R.id.scoreTV);
        score = 0;
        welcomeToSA = getIntent();
        score = welcomeToSA.getIntExtra("Score", 0);
        scoreTV.setText("" + score);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("highScores");


        mPreferences = getSharedPreferences(sharedPreferences, MODE_PRIVATE);
        initialName = mPreferences.getString(NAME_KEY, "Player");
        hiPlayerTV = findViewById(R.id.playerNameTV);
        hiPlayerTV.setText("Hi Player:" + initialName);

        sendScoreByE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] addresses = new String[] {getString(R.string.personal_email)};
                String subject = getString(R.string.email_subject);
                String body = getString(R.string.body_score) + score;
                composeEmail(addresses, subject, body);

            }
        });
        sendScoreFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player1 = new HighScoreEntry(initialName, score);
                Log.d(TAG, player1.toString());

                String key = myRef.push().getKey();
                myRef.child(key).setValue(player1);
                showHighScoreIntent = new Intent(ScoreActivity.this, HighScoreActivity.class);
                startActivity(showHighScoreIntent);
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