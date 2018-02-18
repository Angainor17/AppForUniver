package com.example.admin.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class VibrationActivity extends AppCompatActivity {

    Button button;
    SeekBar seekBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();//верхняя панелька
        actionBar.setTitle("Вибрация");//название на верхней панельке
        actionBar.setDisplayHomeAsUpEnabled(true); //отображение кнопки назад на верхней панельке

        setContentView(R.layout.activity_vibro);
        button = findViewById(R.id.button);
        seekBar = findViewById(R.id.seekBar2);
        textView = findViewById(R.id.textView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText(i + " сек");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrate(1000 * seekBar.getProgress());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {//распознаёт нажатие на иконку назад в actionBar и вызывает обработчик нажатия кнопки назад
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    private void vibrate(int milliSec) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);//получаем системный сервис
        v.vibrate(milliSec);
    }
}
