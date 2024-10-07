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
    Intent goToSA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        goBTN = (Button)findViewById(R.id.touchBTN);

        goBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSA = new Intent(WelcomeActivity.this, MainActivity.class);
                goToSA.putExtra("Button", button);
                startActivity(goToSA);

            }
        });


    }
}