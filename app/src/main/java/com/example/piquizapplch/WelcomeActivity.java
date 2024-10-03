package com.example.piquizapplch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    int button;
    Button goBTN;
    Intent goToQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        goBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToQ = new Intent(WelcomeActivity.this, MainActivity.class);
                goToQ.putExtra("Button", button);
                startActivity(goToQ);

            }
        });


    }
}