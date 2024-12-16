package com.example.piquizapplch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    Button goBTN;
    Intent goToSA;
    EditText nameET;

    private SharedPreferences mPreferences;
    private String sharedPreferences= "com.example.piquizapplch.sp";
    private final String NAME_KEY = "NAME";
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        goBTN = (Button)findViewById(R.id.touchBTN);
        nameET = (EditText)findViewById(R.id.typeYourNBTN);

        mPreferences = getSharedPreferences(sharedPreferences, MODE_PRIVATE);

        goBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putString(NAME_KEY, nameET.getText().toString());
                preferencesEditor.apply();
                goToSA = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(goToSA);

            }
        });
    }


}