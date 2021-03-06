package com.example.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button buttonVibration;
    Button buttonBrowser;
    Button buttonTorch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// привязка Актвити и Layout XML файла

        buttonVibration = findViewById(R.id.buttonVibro); // поиск по заданому XML файлу вьюшки

        buttonVibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VibrationActivity.class);//intent что-то вроде описания события, в данном случае запуск Activity
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

        buttonTorch = findViewById(R.id.buttonTorch);
        buttonTorch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TorchActivity.class);
                startActivity(intent);
            }
        });
    }
}
