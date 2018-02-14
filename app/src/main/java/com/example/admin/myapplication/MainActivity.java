package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonVibration;
    Button buttonBrowser;
    Button buttonVibro2;
    Button buttonVibro3;
    Button buttonVibro4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonVibration = findViewById(R.id.buttonVibro);
        buttonVibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VibroActivity.class);
                startActivity(intent);
            }
        });


        buttonBrowser = findViewById(R.id.buttonBrowser);
        buttonBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BrowserActivity.class);
                startActivity(intent);
            }
        });
    }
}
